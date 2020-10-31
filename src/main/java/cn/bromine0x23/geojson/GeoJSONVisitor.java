package cn.bromine0x23.geojson;

public interface GeoJSONVisitor<T> {

	default T visit(Point point) { return null; }

	default T visit(MultiPoint multiPoint) { return null; }

	default T visit(LineString lineString) { return null; }

	default T visit(MultiLineString multiLineString) { return null; }

	default T visit(Polygon polygon) { return null; }

	default T visit(MultiPolygon multiPolygon) { return null; }

	default T visit(GeometryCollection geometryCollection) { return null; }

	default T visit(Feature feature) { return null; }

	default T visit(FeatureCollection featureCollection) { return null; }
}
