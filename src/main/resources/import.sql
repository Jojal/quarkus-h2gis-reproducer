-- CREATE ALIAS IF NOT EXISTS H2GIS_SPATIAL FOR "org.h2gis.functions.factory.H2GISFunctions.load";
-- CALL H2GIS_SPATIAL();

INSERT INTO location(id,name,geom) VALUES (0,'test', ST_PointFromText('POINT(-4 48)', 4326));
INSERT INTO location(id,name,geom) VALUES (1,'polygon', ST_PolyFromText('POLYGON((10 -25, 34 -20, 38 -35, 13 -39, 10 -25))', 4326));
SELECT ST_Contains('POLYGON((1 1, 8 1, 8 7, 1 7, 1 1))', 'POINT(4 4)');
