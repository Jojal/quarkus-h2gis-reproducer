package bzh.jojal;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
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
        return "Hello from RESTEasy Reactive";
    }
}
