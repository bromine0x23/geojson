package cn.bromine0x23.geojson;

/**
 * @see java.util.function.Consumer
 */
public interface GeoJSONConsumer {

	default void consume(Point point) {}

	default void consume(MultiPoint multiPoint) {}

	default void consume(LineString lineString) {}

	default void consume(MultiLineString multiLineString) {}

	default void consume(Polygon polygon) {}

	default void consume(MultiPolygon multiPolygon) {}

	default void consume(GeometryCollection geometryCollection) {}

	default void consume(Feature feature) {}

	default void consume(FeatureCollection featureCollection) {}
}
