package cn.bromine0x23.geojson.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import cn.bromine0x23.geojson.Position;

import java.io.IOException;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see Position
 */
public class PositionDeserializer extends JsonDeserializer<Position> {

	@Override
	public Position deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		if (parser.isExpectedStartArrayToken()) {
			return deserializeArray(parser, context);
		}
		return context.reportInputMismatch(Position.class, "Cannot deserializer.");
	}

	protected Position deserializeArray(JsonParser parser, DeserializationContext context) throws IOException {
		double longitude = extractDouble(parser, context, false);
		double latitude  = extractDouble(parser, context, false);
		double altitude  = extractDouble(parser, context, true);
		return Position.of(longitude, latitude, altitude);
	}

	protected double extractDouble(JsonParser parser, DeserializationContext context, boolean optional) throws IOException {
		JsonToken token = parser.nextToken();
		if (token == null) {
			return optional
				? Double.NaN
				: context.reportInputMismatch(Position.class, "Unexpected end-of-input.");
		}
		switch (token) {
			case END_ARRAY:
				return optional
					? Double.NaN
					: context.reportInputMismatch(Position.class, "Unexpected end-of-input.");
			case VALUE_NUMBER_FLOAT:
				return parser.getDoubleValue();
			case VALUE_NUMBER_INT:
				return parser.getLongValue();
			case VALUE_STRING:
				return parser.getValueAsDouble();
			default:
				return context.reportInputMismatch(Position.class, "Unexpected token (%s).", token.name());
		}
	}
}
