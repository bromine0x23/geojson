package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * GeoJSON 多边形集合（MultiPolygon）
 *
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.7">RFC 7946 - The GeoJSON Format</a>
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MultiPolygon extends MultiGeometry<List<List<Position>>> {

	public MultiPolygon(@Nonnull List<List<List<Position>>> coordinates) {
		super(coordinates);
	}

	public MultiPolygon(@Nonnull List<List<Position>>... members) {
		super(members);
	}

	@Override
	GeoJSONType getType() {
		return GeoJSONType.MultiPolygon;
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public void add(Polygon polygon) {
		super.add(polygon);
	}

}
