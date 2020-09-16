package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.8">RFC7946 - The GeoJSON Format</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GeometryCollection extends GeoJsonObject {

	@JsonProperty("geometries")
	private List<Geometry<?>> geometries = new ArrayList<>();

	protected GeometryCollection() {
	}

	public GeometryCollection(List<Geometry<?>> geometries) {
		this.geometries = geometries;
	}

	public GeometryCollection(Geometry<?>... geometries) {
		this();
		for (Geometry<?> geometry : geometries) {
			add(geometry);
		}
	}

	public void add(Geometry<?> geometry) {
		geometries.add(geometry);
	}

}
