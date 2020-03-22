package end.s2.nb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@MapperScan("end.s2.nb.mapper")
@ComponentScan("end.s2.nb.*")
@SpringBootApplication
public class FourGeekWebApplication {
    // user:chh
    // user:yhh
    // user:fcx 111
    // 测试
    // OKOK
    public static void main(String[] args) {
        SpringApplication.run(FourGeekWebApplication.class, args);
    }
}
