package cn.com.agree.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;


public class MyRibbonRule extends AbstractLoadBalancerRule {

	private int total = 0;
	private int index = 0;
	
	public Server choose(ILoadBalancer lb,Object key) {
		if(lb == null) {
			return null;
		}
		 Server server = null;
		
		 while(server == null) {
			 if (Thread.interrupted()) {
	                return null;
	            }
			 List<Server> upServerList = lb.getReachableServers();  //获取所有的正常的服务提供者
			 if(upServerList.size() == 0) {
				 return null;
			 }
			 if(total<5) {
				 server = upServerList.get(index);
				 System.out.println("第"+(total+1)+"次："+server.getHostPort());
				 total++;
			 }else {
				total = 0;
				index++;
				if(index >= upServerList.size()) {
					index = 0;
				}
			 }
			 if (server == null) {
					Thread.yield();
					continue;
				}
				if (server.isAlive()) {
					return (server);
				}
				server = null;
				Thread.yield();
		 }
		return server;
	}
	
	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(),key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

}
