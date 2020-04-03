/*
package end.s2.nb.controller;


import end.s2.nb.page.ITestDemoPageService;
import end.s2.nb.util.RedisLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

*/
/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 13:16
 *//*

@RestController
@RequestMapping("/test")

public class TestController {
    @Autowired
    ITestDemoPageService testDemoPageService;
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
    // 最后一次加水时间
    static long lastTime = System.currentTimeMillis();
    // 当前水量
    static int water = 4;
    // 水流速度/s
    static int rate = 4;
    // 桶的容量
    static int capacity = 10;

    public static void main(String[] args) {

        //计算当前水量
        ScheduledExecutorService execu = Executors.newScheduledThreadPool(5);

        execu.scheduleWithFixedDelay(() -> {
            long now = System.currentTimeMillis();
            water = Math.max(0, (int) (water - (now - lastTime) * rate / 1000));
            int permits = (int) (Math.random() * 8) + 1;
            // log.info("请求数：" + permits + "，当前桶余量：" + (capacity - water));
            lastTime = now;
            if (capacity - water < permits) {
                // 若桶满,则拒绝
                //   log.info("限流了");
            } else {
                // 还有容量
                water += permits;
                // log.info("剩余容量=" + (capacity - water));
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    @RedisLimit(key = "msg", period = 10, count = 2, name = "test")
    @GetMapping("/msg")
    public Object test() {
        System.out.println("测试");
        return ATOMIC_INTEGER.incrementAndGet();
    }
}
*/
