package cn.com.agree.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //表明这是一个配置类
public class ConfigBean {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}