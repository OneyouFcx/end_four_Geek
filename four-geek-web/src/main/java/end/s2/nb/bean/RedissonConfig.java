package end.s2.nb.bean;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/26 10:17
 */
@Configuration
public class RedissonConfig {
    @Autowired
    private Environment environment;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(environment.getProperty("redis.config.host"))
                .setPassword(environment.getProperty("spring.redis.password"))
                .setConnectionMinimumIdleSize(5)// 连接池不能太大不然会报错 mmp
                .setConnectionPoolSize(5)
                .setPingConnectionInterval(60);
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
