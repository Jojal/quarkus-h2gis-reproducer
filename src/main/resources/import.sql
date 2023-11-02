CREATE ALIAS IF NOT EXISTS H2GIS_SPATIAL FOR "org.h2gis.functions.factory.H2GISFunctions.load";
CALL H2GIS_SPATIAL();

INSERT INTO location(id,name,geom) VALUES (0,'test', ST_PointFromText('POINT(550700 5801000)', 25832));
