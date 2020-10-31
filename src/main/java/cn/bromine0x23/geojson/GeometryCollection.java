package cn.bromine0x23.geojson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 * @see <a href="https://tools.ietf.org/html/rfc7946#section-3.1.8">RFC7946 - The GeoJSON Format</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GeometryCollection extends GeoJSON implements Iterable<Geometry<?>> {

	@JsonProperty("geometries")
	private List<Geometry<?>> geometries = new ArrayList<>();

	protected GeometryCollection() {
	}

	public GeometryCollection(List<Geometry<?>> geometries) {
		this.geometries = geometries;
	}

	public GeometryCollection(Geometry<?>... geometries) {
		this();
		for (Geometry<?> geometry : geometries) {
			add(geometry);
		}
	}

	@Override
	public void accept(GeoJSONConsumer consumer) {
		consumer.consume(this);
	}

	@Override
	public <T> T accept(GeoJSONVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Nonnull
	@Override
	public Iterator<Geometry<?>> iterator() {
		return geometries != null ? geometries.iterator() : Collections.emptyIterator();
	}

	public void add(Geometry<?> geometry) {
		geometries.add(geometry);
	}

}
