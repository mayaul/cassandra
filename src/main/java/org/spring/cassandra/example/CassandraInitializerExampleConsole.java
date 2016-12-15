package org.spring.cassandra.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.spring.cassandra.initialzer.CassandraClusterInitializer;

public class CassandraInitializerExampleConsole {
	public static void main(String... args) {
		Cluster cluster;
		try {
			cluster = Cluster.buildFrom(new CassandraClusterInitializer());

			Session session = cluster.connect();

			MappingManager manager = new MappingManager(session);

			Mapper<TestTableEx1> mapper = manager.mapper(TestTableEx1.class);

			TestTableEx1 testTableEx1 = mapper.get("N1","Seoul");
			System.out.println(testTableEx1.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
