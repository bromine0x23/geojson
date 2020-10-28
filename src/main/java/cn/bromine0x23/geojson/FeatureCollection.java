package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.3">RFC7946 - The GeoJSON Format</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FeatureCollection extends GeoJsonObject {

	@JsonProperty("features")
	private List<Feature> features = new ArrayList<>();

	@Override
	public void accept(GeoJsonObjectConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public void add(Feature feature) {
		this.features.add(feature);
	}

	public void addAll(Collection<Feature> features) {
		this.features.addAll(features);
	}
}
