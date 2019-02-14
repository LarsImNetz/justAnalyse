package org.homelinux.moonserver;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public final class LocalDateSerializer extends JsonSerializer<LocalDate> {

	@Override
	public void serialize(final LocalDate date, final JsonGenerator gen, final SerializerProvider arg2) throws IOException {
		gen.writeString(Objects.isNull(date)
				? ""
				: date.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}
