package com.fhbean.springboot.mongodb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import java.net.InetAddress;

@SpringBootApplication
@Slf4j
public class SpringbootMongodbApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext application = SpringApplication.run(SpringbootMongodbApplication.class, args);

		Environment env = application.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Login: \thttp://{}:{}/\n\t" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));


		System.out.println("(♥◠‿◠)ﾉﾞ  启动成功！   ლ(´ڡ`ლ)ﾞ ");
	}
}
