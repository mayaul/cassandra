package org.spring.cassandra.example;

import com.datastax.driver.core.*;

public class CassandraSimpleExampleConsole {
	public static void main(String... args) {
		Cluster cluster = null;
		try {
			cluster = Cluster.builder()
				.addContactPoint("127.0.0.1")
				.build();

			Session session = cluster.connect();

			ResultSet rs = session.execute("select * from dev.test_table_ex1");

			for (Row row : rs.all()) {
				for (ColumnDefinitions.Definition definition : row.getColumnDefinitions()) {
					System.out.print(row.get(definition.getName(), String.class) + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
