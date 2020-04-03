package end.s2.nb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "end.s2.nb.rpc.api")
public class DemoTestStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoTestStartApplication.class, args);
    }
}
