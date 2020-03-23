package end.s2.end.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.repository.support.RedisRepositoryFactoryBean;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/20 11:19
 */
public class RedisConfig implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
