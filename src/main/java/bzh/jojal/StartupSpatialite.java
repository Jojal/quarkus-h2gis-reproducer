package bzh.jojal;

import io.agroal.api.AgroalDataSource;
import io.agroal.pool.wrapper.ConnectionWrapper;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConnection;
import org.sqlite.core.DB;
import org.sqlite.jdbc4.JDBC4Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Startup(value = 10)
@ApplicationScoped
public class StartupSpatialite {

    public StartupSpatialite(AgroalDataSource defaultDataSource) throws SQLException {

        System.err.println("##################### Load Spatialite");

        SQLiteConfig config = new SQLiteConfig();
        config.enableLoadExtension(true);
        Properties properties = config.toProperties();

        Connection connection = defaultDataSource.getConnection();
        SQLiteConnection unwrap = connection.unwrap(SQLiteConnection.class);
        unwrap.getDatabase().enable_load_extension(true);


        //  connection.getClientInfo().putAll(properties);

        Statement stmt = connection.createStatement();
        stmt.setQueryTimeout(30); // set timeout to 30 sec.

        // loading SpatiaLite
        stmt.execute("SELECT load_extension('/usr/local/lib/mod_spatialite.dylib')");
        // enabling Spatial Metadata
        // using v.2.4.0 this automatically initializes SPATIAL_REF_SYS and GEOMETRY_COLUMNS
        String sql = "SELECT InitSpatialMetadata();";
        stmt.execute(sql);

        stmt.execute("INSERT INTO location(id,name,geom) VALUES (0,'test', ST_PointFromText('POINT(550700 5801000)', 25832))");
    }
}
