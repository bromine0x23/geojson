package cn.bromine0x23.geojson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:bromine0x23@163.com">Bromine0x23</a>
 */
public abstract class MultiGeometry<TCoordinatesMember> extends Geometry<List<TCoordinatesMember>> {

	protected MultiGeometry() {
		super(new ArrayList<>());
	}

	protected MultiGeometry(List<TCoordinatesMember> coordinates) {
		super(coordinates);
	}

	@SafeVarargs
	protected MultiGeometry(Geometry<TCoordinatesMember>... geometries) {
		super();
		for (Geometry<TCoordinatesMember> geometry : geometries) {
			add(geometry);
		}
	}

	@SafeVarargs
	protected MultiGeometry(TCoordinatesMember ... members) {
		super(toCoordinates(members));
	}

	protected void add(Geometry<TCoordinatesMember> geometry) {
		coordinates.add(geometry.getCoordinates());
	}

	protected static <TCoordinatesMember> List<TCoordinatesMember> toCoordinates(TCoordinatesMember ... members) {
		ArrayList<TCoordinatesMember> coordinates = new ArrayList<>(members.length);
		Collections.addAll(coordinates, members);
		return coordinates;
	}

}
