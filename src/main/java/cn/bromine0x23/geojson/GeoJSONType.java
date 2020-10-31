package cn.bromine0x23.geojson;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-7">RFC 7946 - The GeoJSON Format</a>
 */
public enum GeoJSONType {
	Point,
	MultiPoint,
	LineString,
	MultiLineString,
	Polygon,
	MultiPolygon,
	GeometryCollection,
	Feature,
	FeatureCollection,

}
