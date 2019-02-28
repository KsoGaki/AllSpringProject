package fr.afpa.formation.serialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fr.afpa.formation.entity.Vehicule;

public class VehiculeListSerializer extends StdSerializer<Set<Vehicule>> {

	private static final long serialVersionUID = 1L;

	public VehiculeListSerializer() {
		this(null);
	}

	public VehiculeListSerializer(Class<Set<Vehicule>> listVehicule) {
		super(listVehicule);
	}

	@Override
	public void serialize(Set<Vehicule> listVehicule, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		List<Long> listId = new ArrayList<>();
		for (Vehicule vehicule : listVehicule) {
			listId.add(vehicule.getId());
		}
		jsonGenerator.writeObject(listId);
	}


}
