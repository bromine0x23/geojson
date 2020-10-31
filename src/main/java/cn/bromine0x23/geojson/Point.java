package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * GeoJSON 点（Point）
 *
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.2">RFC 7946 - The GeoJSON Format</a>
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Point extends GeometryWithCoordinates<Position> {

	public Point(@Nonnull Position position) {
		super(position);
	}

	public Point(double longitude, double latitude) {
		this(Position.of(longitude, latitude));
	}

	public Point(double longitude, double latitude, double altitude) {
		this(Position.of(longitude, latitude, altitude));
	}

	@Override
	GeoJSONType getType() {
		return GeoJSONType.Point;
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
