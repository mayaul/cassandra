package org.spring.cassandra.example;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(keyspace = "dev", name="test_table_ex3")
@Getter
@Setter
@ToString
public class TestTableEx3 {
	@PartitionKey
	@Column
	Category category;
}
