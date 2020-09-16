package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.7">RFC7946 - The GeoJSON Format</a>
 */
@EqualsAndHashCode(callSuper = true)
public class MultiPolygon extends MultiGeometry<List<List<Position>>> {

	protected MultiPolygon() {
	}

	public MultiPolygon(@Nonnull List<List<List<Position>>> coordinates) {
		super(coordinates);
	}

	public MultiPolygon(@Nonnull List<List<Position>>... members) {
		super(members);
	}

	public void add(Polygon polygon) {
		super.add(polygon);
	}

}
