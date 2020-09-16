package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.5">RFC7946 - The GeoJSON Format</a>
 */
@EqualsAndHashCode(callSuper = true)
public class MultiLineString extends MultiGeometry<List<Position>> {

	protected MultiLineString() {
	}

	public MultiLineString(@Nonnull List<List<Position>> coordinates) {
		super(coordinates);
	}

	public MultiLineString(@Nonnull List<Position>... members) {
		super(members);
	}

	public void add(LineString line) {
		super.add(line);
	}

}
