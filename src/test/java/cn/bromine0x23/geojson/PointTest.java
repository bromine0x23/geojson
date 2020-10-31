package cn.bromine0x23.geojson;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PointTest extends GeoJsonObjectTest {

	@Test
	void testSerialize() throws IOException {
		Point point = new Point(10, 30);

		String json = getObjectMapper().writeValueAsString(point);

		assertEquals("{\"type\":\"Point\",\"coordinates\":[10.0,30.0]}",  json);
	}

	@Test
	void testDeserialize() throws IOException {
		String json = "{\"type\":\"Point\",\"coordinates\":[30,10]}";

		GeoJSON geojson = getObjectMapper().readValue(json, GeoJSON.class);

		assertThat(geojson, isA(Point.class));

		Point point = (Point) geojson;

		assertEquals(Position.of(30, 10),  point.getCoordinates());
	}

}