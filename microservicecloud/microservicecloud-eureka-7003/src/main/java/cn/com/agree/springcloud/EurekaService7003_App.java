package cn.com.agree.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaService7003_App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaService7003_App.class, args);
	}

}
