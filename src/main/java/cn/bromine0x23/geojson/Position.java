package cn.bromine0x23.geojson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cn.bromine0x23.geojson.jackson.PositionDeserializer;
import cn.bromine0x23.geojson.jackson.PositionSerializer;
import lombok.Data;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.1">RFC7946 - The GeoJSON Format</a>
 */
@JsonSerialize(using = PositionSerializer.class)
@JsonDeserialize(using = PositionDeserializer.class)
@Data
public class Position {

	/**
	 * 经度
	 */
	private double longitude;

	/**
	 * 纬度
	 */
	private double latitude;

	/**
	 * 海拔
	 */
	private double altitude = Double.NaN;

	public Position(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Position(double longitude, double latitude, double altitude) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
	}

	public boolean hasAltitude() {
		return !Double.isNaN(altitude);
	}

	public static Position of(double longitude, double latitude) {
		return new Position(longitude, latitude);
	}

	public static Position of(double longitude, double latitude, double altitude) {
		return new Position(longitude, latitude, altitude);
	}
}
