package org.spring.cassandra.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.spring.cassandra.initialzer.CassandraClusterInitializer;

public class CassandraEnumCodecExampleConsole {
	public static void main(String... args) {
		Cluster cluster;
		try {
			cluster = Cluster.buildFrom(new CassandraClusterInitializer());

			Session session = cluster.connect();

			MappingManager manager = new MappingManager(session);

			Mapper<TestTableEx3> mapper = manager.mapper(TestTableEx3.class);

//			TestTableEx3 testTableEx3 = new TestTableEx3();
//			testTableEx3.setCategory(Category.CATEGORY1);
//			mapper.save(testTableEx3);

			TestTableEx3 testTableEx3 = mapper.get(Category.CATEGORY1);
			System.out.println(testTableEx3.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
