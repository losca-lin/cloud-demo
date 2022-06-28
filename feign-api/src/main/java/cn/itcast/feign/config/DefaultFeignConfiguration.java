package cn.itcast.feign.config;

import cn.itcast.feign.fallback.UserClientFallbackFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author Losca
 * @date 2022/6/28 14:42
 */
public class DefaultFeignConfiguration {
    @Bean
    public UserClientFallbackFactory userClientFallbackFactory(){
        return new UserClientFallbackFactory();
    }
}
