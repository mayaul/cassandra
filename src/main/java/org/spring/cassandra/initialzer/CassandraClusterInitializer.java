package org.spring.cassandra.initialzer;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.Configuration;
import com.datastax.driver.core.Host;
import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.extras.codecs.jdk8.LocalDateCodec;
import com.google.common.collect.Lists;
import org.spring.cassandra.codec.LocalDateTimeCodec;
import org.spring.cassandra.example.Category;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;

public class CassandraClusterInitializer implements Cluster.Initializer {
	public String getClusterName() {
		return "order.cassandra";
	}

	public List<InetSocketAddress> getContactPoints() {
		List<InetSocketAddress> hosts = Lists.newArrayList();

		hosts.add(new InetSocketAddress("127.0.0.1", 9042));
		return hosts;
	}

	public Configuration getConfiguration() {
		return Configuration.builder()
			.withCodecRegistry(new CodecRegistry()
				.register(LocalDateCodec.instance)
				.register(new EnumNameCodec<>(Category.class))
				.register(new LocalDateTimeCodec()))
			.build();
	}

	public Collection<Host.StateListener> getInitialListeners() {
		return Lists.newArrayList();
	}
}
