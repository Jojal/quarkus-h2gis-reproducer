package bzh.jojal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.h2.mvstore.db.NullValueDataType;
import org.h2gis.functions.factory.H2GISFunctions;
import org.h2gis.functions.io.kml.KMLWrite;
import org.h2gis.functions.io.shp.SHPWrite;
import org.h2gis.functions.spatial.convert.ST_PointFromText;
import org.h2gis.functions.spatial.convert.ST_PolyFromText;
import org.h2gis.functions.spatial.metadata.FindGeometryMetadata;
import org.h2gis.functions.spatial.predicates.ST_Contains;
import org.hibernate.spatial.dialect.h2gis.H2GisDialectContributor;
import org.hibernate.spatial.integration.SpatialService;

@RegisterForReflection(targets = {
        ST_Contains.class,
        ST_PointFromText.class,
        ST_PolyFromText.class,
        H2GISFunctions.class,
        FindGeometryMetadata.class,
        H2GisDialectContributor.class,
        SpatialService.class,
        SHPWrite.class,
        KMLWrite.class,
        NullValueDataType.class
})
public class ReflectionConfig {
}
