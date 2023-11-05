package bzh.jojal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.h2gis.functions.factory.H2GISFunctions;
import org.h2gis.functions.spatial.convert.ST_PointFromText;
import org.h2gis.functions.spatial.convert.ST_PolyFromText;
import org.h2gis.functions.spatial.metadata.FindGeometryMetadata;
import org.h2gis.functions.spatial.predicates.ST_Contains;

@RegisterForReflection(targets = {
        ST_Contains.class,
        ST_PolyFromText.class,
        ST_PointFromText.class,
        H2GISFunctions.class,
        FindGeometryMetadata.class
})
public class ReflectionConfig {
}
