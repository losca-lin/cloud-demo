package cn.itcast.feign.client;

import cn.itcast.feign.fallback.UserClientFallbackFactory;
import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Losca
 * @date 2022/5/24 15:47
 */
@FeignClient(value = "user-service",fallbackFactory = UserClientFallbackFactory.class)
public interface UserService {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
