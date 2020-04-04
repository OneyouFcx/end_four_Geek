/*
package end.s2.nb.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

*/
/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/26 9:53
 *//*

@RestController
@RequestMapping("/redis")

public class RedisTestController {
    @Autowired
    private RedissonClient redissonClient;

    @PostMapping("lock")
    public String getLock(String key) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int num = i;
            scheduledExecutorService.execute(() -> {
                try {
                    String msg = tryLock("10010");
                    System.out.println(msg + "<<<<" + (num + 1));
                } catch (Exception e) {
                    System.out.println("未知异常" + "<<<<" + (num + 1) + e);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        scheduledExecutorService.shutdown();
        //redissonClient.shutdown();// 关闭连接
        return null;
    }

    public String tryLock(String key) {
        String msg = "获取失败";
        String paramKey = new StringBuffer().append(key).append("-RedissonLock").toString();
        RLock lock = redissonClient.getLock(paramKey);
        try {
            boolean flagLock = lock.tryLock(10, 30, TimeUnit.SECONDS);
            if (flagLock) {
                // 获取到锁
                msg = "获取成功" + Thread.currentThread().getName();
                Thread.sleep(2000);
            } else {
                msg = "获取失败" + Thread.currentThread().getName();
            }
        } catch (Exception e) {
            msg = "异常" + Thread.currentThread().getName();
        } finally {
            // 释放
            if (lock != null && lock.isLocked()) {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + "wait");
        }
        return msg;
    }
}
*/
