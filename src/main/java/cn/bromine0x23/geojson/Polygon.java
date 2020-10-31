package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.6">RFC7946 - The GeoJSON Format</a>
 */
@EqualsAndHashCode(callSuper = true)
public class Polygon extends Geometry<List<List<Position>>> {

	protected Polygon() {
	}

	public Polygon(List<List<Position>> coordinates) {
		super(coordinates);
	}

	@SafeVarargs
	public Polygon(List<Position>... positions) {
		this(toCoordinates(positions));
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@SafeVarargs
	protected static List<List<Position>> toCoordinates(List<Position>... positions) {
		List<List<Position>> coordinates = new ArrayList<>(positions.length);
		Collections.addAll(coordinates, positions);
		return coordinates;
	}

}
