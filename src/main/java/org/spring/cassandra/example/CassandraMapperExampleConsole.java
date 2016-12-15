package org.spring.cassandra.example;

import com.datastax.driver.core.*;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class CassandraMapperExampleConsole {
	public static void main(String... args) {
		Cluster cluster;
		try {
			cluster = Cluster.builder()
				.addContactPoint("127.0.0.1")
				.build();

			Session session = cluster.connect();

			MappingManager manager = new MappingManager(session);

			Mapper<TestTableEx1> mapper = manager.mapper(TestTableEx1.class);
			/*
			  Insert
			 */
//			TestTableEx1 sample = new TestTableEx1();
//			sample.setCode("N3");
//			sample.setLocation("Namwon");
//			sample.setDescription("NN");
//			sample.setSequence("first");
//			mapper.save(sample);

			/*
			Select, Primary Key 조합을 모두 넣어, 1거만 조회
			 */
			TestTableEx1 testTableEx1 = mapper.get("N1","Seoul");
			System.out.println(testTableEx1.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
