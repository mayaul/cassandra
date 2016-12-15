package org.spring.cassandra.example;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(keyspace = "dev", name="test_table_ex2")
@Getter
@Setter
@ToString
public class TestTableEx2 {
	@PartitionKey
	@Column
	String key1;

	@PartitionKey(1)
	@Column
	String key2;

	@Column
	LocalDate localDate;

	@Column
	LocalDateTime localDateTime;
}
