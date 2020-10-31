package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.4">RFC7946 - The GeoJSON Format</a>
 */
@EqualsAndHashCode(callSuper = true)
public class LineString extends Geometry<List<Position>> {

	protected LineString() {
		super(new ArrayList<>());
	}

	public LineString(@Nonnull List<Position> coordinates) {
		super(coordinates);
		assertCoordinates(getCoordinates());
	}

	public LineString(Position... positions) {
		this(toCoordinates(positions));
	}

	@Override
	GeoJSONType getType() {
		return GeoJSONType.LineString;
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

	protected void assertCoordinates(@Nonnull List<Position> coordinates) {
		if (coordinates.size() < 2) {
			throw new IllegalArgumentException("The \"coordinates\" member of LineString should have two or more positions.");
		}
	}

	protected static List<Position> toCoordinates(Position... positions) {
		List<Position> coordinates = new ArrayList<>(positions.length);
		Collections.addAll(coordinates, positions);
		return coordinates;
	}

}
