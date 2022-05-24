package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Losca
 * @date 2022/5/23 20:35
 */
@Component
//@ConfigurationProperties 会自动热更新
@ConfigurationProperties(prefix = "pattern")
@Data
public class MyConfig {
    private String dateformat;
    private String name;
}
