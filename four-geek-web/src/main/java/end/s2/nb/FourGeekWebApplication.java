package end.s2.nb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("end.s2.nb.mapper")
@ComponentScan("end.s2.nb.*")
@SpringBootApplication
public class FourGeekWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FourGeekWebApplication.class, args);
    }
}
