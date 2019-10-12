package cn.com.agree.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    //本服务启动后会自动注册到服务端
@EnableDiscoveryClient
@EnableCircuitBreaker   //开启断路器
public class DeptProvider8001Hystrix_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001Hystrix_App.class, args);
	}

}
