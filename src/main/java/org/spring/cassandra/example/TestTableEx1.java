package org.spring.cassandra.example;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(keyspace = "dev", name="test_table_ex1")
@Setter
@Getter
@ToString
public class TestTableEx1 {
	@PartitionKey
	@Column
	private String code;

	@ClusteringColumn
	@Column
	private String location;

	@Column
	private String description;

	@Column
	private String sequence;
}
