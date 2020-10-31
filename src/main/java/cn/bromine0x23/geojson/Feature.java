package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * GeoJSON 特征（Feature）
 *
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.2">RFC 7946 - The GeoJSON Format</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Feature extends GeoJSON {

	@JsonProperty("properties")
	@JsonInclude
	private Map<String, Object> properties = new HashMap<>();

	@JsonProperty("geometry")
	@JsonInclude
	private Geometry geometry;

	@JsonProperty("id")
	private String id;

	@Override
	GeoJSONType getType() {
		return GeoJSONType.Feature;
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@SuppressWarnings("unchecked")
	public <T> T getProperty(String key) {
		return (T) properties.get(key);
	}

	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}
}
