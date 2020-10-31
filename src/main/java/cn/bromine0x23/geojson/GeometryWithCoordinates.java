package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * GeoJSON 带坐标几何图形
 *
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public abstract class GeometryWithCoordinates<TCoordinates> extends Geometry {

	@JsonProperty("coordinates")
	@Getter
	@Setter
	protected TCoordinates coordinates;

	protected GeometryWithCoordinates(TCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(coordinates=" + this.getCoordinates() + ",super=" + super.toString() + ")";
	}

}
