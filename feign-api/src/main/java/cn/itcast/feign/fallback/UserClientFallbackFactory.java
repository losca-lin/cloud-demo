package cn.itcast.feign.fallback;

import cn.itcast.feign.client.UserService;
import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Losca
 * @date 2022/6/28 14:28
 */
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public User findById(Long id) {
                log.info("用户查询异常",throwable);
                return new User();
            }
        };
    }
}
