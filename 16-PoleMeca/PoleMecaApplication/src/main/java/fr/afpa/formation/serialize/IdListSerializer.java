package fr.afpa.formation.serialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fr.afpa.formation.dto.IDTO;

public class IdListSerializer<T> extends StdSerializer<Set<T>> {

	private static final long serialVersionUID = 1L;

	public IdListSerializer() {
		this(null);
	}

	public IdListSerializer(Class<Set<T>> listT) {
		super(listT);
	}

	@Override
	public void serialize(Set<T> listT, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		List<Long> listId = new ArrayList<>();
		for (T t : listT) {
			IDTO iDTO = (IDTO) t;
			listId.add( iDTO.getId());
		}
		jsonGenerator.writeObject(listId);
	}


}
