package org.spring.cassandra.codec;

import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.extras.codecs.MappingCodec;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeCodec extends MappingCodec<LocalDateTime, String> {
	public LocalDateTimeCodec() {
		super(TypeCodec.varchar(), java.time.LocalDateTime.class);
	}

	@Override
	protected LocalDateTime deserialize(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		return LocalDateTime.parse(value, formatter);
	}

	@Override
	protected String serialize(LocalDateTime value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		return value.format(formatter);
	}
}
