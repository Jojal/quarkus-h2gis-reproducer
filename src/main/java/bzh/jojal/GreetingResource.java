package bzh.jojal;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject
    EntityManager em;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello() {
        TypedQuery<Boolean> query = em.createQuery("SELECT ST_Contains('POLYGON((1 1, 8 1, 8 7, 1 7, 1 1))', 'POINT(4 234)')", Boolean.class);
        List<Boolean> resultList = query.getResultList();
        if(!resultList.isEmpty()) {
            System.err.println(resultList.get(0));
        }


        Query nativeQuery = em.createNativeQuery("CALL SHPWrite('/Users/jordan/Documents/T/Dev/postgis/gis/h2/area.shp', '(SELECT geom FROM LOCATION where id=1)')");
        nativeQuery.executeUpdate();

        nativeQuery = em.createNativeQuery("CALL KMLWrite('/Users/jordan/Documents/T/Dev/postgis/gis/h2/area.kml', '(SELECT geom FROM LOCATION)')");
        nativeQuery.executeUpdate();

        int firstResult = nativeQuery.getFirstResult();

        System.err.println(firstResult);

        return "Hello from RESTEasy Reactive";
    }
}
