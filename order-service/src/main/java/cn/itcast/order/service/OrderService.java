package cn.itcast.order.service;

import cn.itcast.feign.client.UserService;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //String url = "http://user-service/user/" + order.getUserId();
        //User user = restTemplate.getForObject(url, User.class);
        //Feign默认负载均衡
        User user = userService.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;

    }

    @SentinelResource("goods")
    public void queryGoods(){
        System.err.println("查询商品");
    }
}
