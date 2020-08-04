package cn.jiyun.dao;



import cn.jiyun.client.UserClient;
import cn.jiyun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDAO {
  /*  @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;*/

    @Autowired
    private UserClient userClient;

    public User queryUserById(Long id){
        //     String uri = "http://localhost:8081/user/"+id;
//        return this.restTemplate.getForObject(uri,User.class);
       /* List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        ServiceInstance instance = instances.get(0);
        //获取service-provider的信息
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;*/
        return this.userClient.queryById(id);


    }
}
