package cn.bromine0x23.geojson;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.2">RFC7946 - The GeoJSON Format</a>
 */
@EqualsAndHashCode(callSuper = true)
public class Point extends Geometry<Position> {

	protected Point() {
	}

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
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
