package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
	@Type(Point.class),
	@Type(MultiPoint.class),
	@Type(LineString.class),
	@Type(MultiLineString.class),
	@Type(Polygon.class),
	@Type(MultiPolygon.class),
	@Type(GeometryCollection.class),
	@Type(Feature.class),
	@Type(FeatureCollection.class),
})
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class GeoJsonObject {

	/**
	 * @see <a href="https://tools.ietf.org/html/rfc7946#section-5">RFC7946 - The GeoJSON Format</a>
	 */
	@JsonProperty("bbox")
	private double[] bbox;
}
