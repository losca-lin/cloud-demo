package cn.itcast.order.client;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Losca
 * @date 2022/5/24 15:47
 */
@FeignClient("user-service")
public interface UserService {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
