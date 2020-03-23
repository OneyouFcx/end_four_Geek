package end.s2.end.test;

import end.s2.end.lock.ExtLook;
import end.s2.end.lock.ZookeeperDistrbuteLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/23 10:22
 */
public class OrderService {


    public static void main(String[] args) {
        // 生成订单号
        GeneratorOrderNum orderNumGenerator = new GeneratorOrderNum();


        ExecutorService exec = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> {
                ExtLook lock = new ZookeeperDistrbuteLock();
                try {
                    lock.getLock();
                    System.out.println(Thread.currentThread().getName() + "订单号：" + orderNumGenerator.getNumber());
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + "异常" + e);
                } finally {
                    lock.unLock();
                }
            });
        }
        exec.shutdown();
    }
}
