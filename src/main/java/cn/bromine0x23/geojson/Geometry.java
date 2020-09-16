package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 */
@EqualsAndHashCode(callSuper = true)
public abstract class Geometry<TCoordinates> extends GeoJsonObject {

	@JsonProperty("coordinates")
	@Getter
	@Setter
	protected TCoordinates coordinates;

	protected Geometry() {
	}

	protected Geometry(TCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "(coordinates=" + this.getCoordinates() + ",super=" + super.toString() + ")";
	}

}
