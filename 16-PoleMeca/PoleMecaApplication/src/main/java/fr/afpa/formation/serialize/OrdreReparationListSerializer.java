package fr.afpa.formation.serialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fr.afpa.formation.entity.OrdreReparation;

public class OrdreReparationListSerializer extends StdSerializer<Set<OrdreReparation>> {

	private static final long serialVersionUID = 1L;

	public OrdreReparationListSerializer() {
		this(null);
	}

	public OrdreReparationListSerializer(Class<Set<OrdreReparation>> listOrdreReparation) {
		super(listOrdreReparation);
	}

	@Override
	public void serialize(Set<OrdreReparation> listOrdreReparation, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		List<Long> listId = new ArrayList<>();
		for (OrdreReparation ordreReparation : listOrdreReparation) {
			listId.add(ordreReparation.getId());
		}
		jsonGenerator.writeObject(listId);
	}


}
