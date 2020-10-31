package cn.bromine0x23.geojson;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.*;

class LineStringTest extends GeoJsonObjectTest {

	@Test
	void testSerialize() throws IOException {
		LineString lineString = new LineString(Position.of(10, 30), Position.of(30, 10), Position.of(40, 40));

		String json = getObjectMapper().writeValueAsString(lineString);

		assertEquals("{\"type\":\"LineString\",\"coordinates\":[[10.0,30.0],[30.0,10.0],[40.0,40.0]]}", json);
	}

	@Test
	void testDeserialize() throws IOException {
		String json = "{\"type\":\"LineString\",\"coordinates\":[[30,10],[10,30],[40,40]]}";

		GeoJSON geoJsonObject = getObjectMapper().readValue(json, GeoJSON.class);

		assertThat(geoJsonObject, isA(LineString.class));

		LineString lineString = (LineString) geoJsonObject;

		assertEquals(
			Arrays.asList(Position.of(30, 10), Position.of(10, 30), Position.of(40, 40)),
			lineString.getCoordinates()
		);
	}

}