package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * GeoJSON 点集合（MultiPoint）
 *
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.3">RFC 7946 - The GeoJSON Format</a>
 */
@EqualsAndHashCode(callSuper = true)
public class MultiPoint extends MultiGeometry<Position> {

	protected MultiPoint() {
	}

	public MultiPoint(@Nonnull List<Position> coordinates) {
		super(coordinates);
	}

	public MultiPoint(@Nonnull Position... members) {
		super(members);
	}

	@Override
	GeoJSONType getType() {
		return GeoJSONType.MultiPoint;
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public void add(Point point) {
		super.add(point);
	}

}
