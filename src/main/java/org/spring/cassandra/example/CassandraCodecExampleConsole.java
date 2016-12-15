package org.spring.cassandra.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.spring.cassandra.initialzer.CassandraClusterInitializer;

public class CassandraCodecExampleConsole {
	public static void main(String... args) {
		Cluster cluster;
		try {
			cluster = Cluster.buildFrom(new CassandraClusterInitializer());

			Session session = cluster.connect();

			MappingManager manager = new MappingManager(session);

			Mapper<TestTableEx2> mapper = manager.mapper(TestTableEx2.class);

//			TestTableEx2 testTableEx2 = new TestTableEx2();
//			testTableEx2.setKey1("100");
//			testTableEx2.setKey2("200");
//			testTableEx2.setLocalDate(LocalDate.now());
//			testTableEx2.setLocalDateTime(LocalDateTime.now());
//			mapper.save(testTableEx2);

			TestTableEx2 testTableEx2 = mapper.get("100","200");
			System.out.println(testTableEx2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
