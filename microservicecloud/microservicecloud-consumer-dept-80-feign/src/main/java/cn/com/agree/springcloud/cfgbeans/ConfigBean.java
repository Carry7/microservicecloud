package cn.com.agree.springcloud.cfgbeans;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration  //表明这是一个配置类
public class ConfigBean {
	
	@Bean
	@LoadBalanced  //开启基于Ribbon的负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*@Bean
	public IRule myRule() {          //指定使用随机的负载均衡算法
		return new RandomRule();
	}*/
}