package cn.com.agree.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     //开启Eureka Servicer
public class EurekaService7001_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaService7001_App.class, args);
	}
}
