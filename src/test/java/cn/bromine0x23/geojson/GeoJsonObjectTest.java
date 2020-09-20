package cn.bromine0x23.geojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

abstract class GeoJsonObjectTest {

	@Getter
	private final ObjectMapper objectMapper = new ObjectMapper();

}