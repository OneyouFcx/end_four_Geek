package end.s2.nb.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/24 10:24
 */
public class CountTest {
    private static final int THREADS_COUNT = 2;

    public static int count = 0;
    public static volatile int countVolatile = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(0, 1);
    int a = 0;

    public static void increase() {
        count++;
        countVolatile++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    increase();
                }
                countDownLatch.countDown();
            });
            threads[i].start();
        }
        countDownLatch.await();
        System.out.println(count);
        System.out.println(countVolatile);
        System.out.println(atomicInteger.get());
        System.out.println(asr.getReference() + "---" + asr.getStamp());
    }
}
