package cn.bromine0x23.geojson.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import cn.bromine0x23.geojson.Position;

import java.io.IOException;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see Position
 */
public class PositionSerializer extends JsonSerializer<Position> {

	@Override
	public void serialize(Position value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
		generator.writeStartArray();
		generator.writeNumber(value.getLongitude());
		generator.writeNumber(value.getLatitude());
		if (value.hasAltitude()) {
			generator.writeNumber(value.getAltitude());
		}
		generator.writeEndArray();
	}

}
