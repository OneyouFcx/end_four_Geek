package end.s2.nb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenTrantLockTest {
    //------------------------  TODO 实现公平锁和非公平锁 -----------------------------
    // true 表示公平锁 有序.
    ReentrantLock orderly = new ReentrantLock(true);
    // true 表示非公平锁 无序.
    ReentrantLock unordered = new ReentrantLock(false);

    // 获取公平锁
    public void queryOrderly() {
        try {
            orderly.lock();
            System.out.println("-----" + Thread.currentThread().getName() + "成功获的锁");
        } finally {
            orderly.unlock();
        }
    }

    // 获取非公平锁
    public void queryUnordered() {
        try {
            unordered.lock();
            System.out.println("-----" + Thread.currentThread().getName() + "成功获的锁");
        } finally {
            unordered.unlock();
        }
    }

    //  线程池数量
    public static final int exePool = 10;

    public static void main(String[] args) {
        ReenTrantLockTest threadLock = new ReenTrantLockTest();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            threadLock.queryUnordered();
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        Arrays.stream(threads).forEach(thred -> thred.start());




       /* ExecutorService execut = Executors.newFixedThreadPool(exePool);
        for(int i=0;i<10;i++){
            execut.execute(runnable);
        }
        execut.shutdown();*/
    }

}

//------------------------  TODO 可重入锁  -----------------------------
//TODO  两种实现方式  ReenTrantLock和Synchronized.
class Test1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("第1次获取锁，这个锁是：" + lock);

                    int index = 1;
                    while (true) {
                        try {
                            lock.lock();
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);
                            if (index == 10) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }

                    }

                } catch (Exception e) {
                    System.out.println("5555");
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        System.out.println("--------------第二个线程");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    for (int i = 0; i < 20; i++) {
                        System.out.println("threadName:" + Thread.currentThread().getName());
                    }
                } catch (Exception e) {
                    System.out.println("没有获取到锁");
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

}

//------------------------  TODO 独占锁与共享锁  -----------------------------
//  TODO 写锁是独占锁,读锁就是共享锁.    存在互斥的关系（读写 写读  写写）.
class ReenTrantReadWirteLockTest {

    public volatile Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    // 读写锁
    ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock(true);

    public void put(String key, String value) {
        // 获取锁
        rwlock.writeLock().lock();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println("线程" + Thread.currentThread().getName() + "写成功,key:" + key);
        // 释放锁
        rwlock.writeLock().unlock();
    }

    public String get(String key) {
        // 获取锁
        rwlock.readLock().lock();
        String val = map.get(key);
        System.out.println("线程" + Thread.currentThread().getName() + "读取成功，val:" + val);
        rwlock.readLock().unlock();
        return val;
    }
}

class TestReadWriteLock {
    public static void main(String[] args) {
        ReenTrantReadWirteLockTest rwlock = new ReenTrantReadWirteLockTest();
        rwlock.put("测试", "测试");
        ExecutorService exec = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 6; i++) {
            int finalNum = i;
            exec.execute(() -> {
                rwlock.put(finalNum + "", finalNum + "");
            });
        }

        for (int i = 0; i < 5; i++) {
            int finalNum = i;
            System.out.println("直接从map中获取：" + rwlock.getMap().get(finalNum + ""));
            exec.execute(() -> rwlock.get(finalNum + ""));
        }
        exec.shutdown();
    }
}
//------------------------  TODO 互斥锁  -----------------------------
// TODO  实现有很多方式就不一一举例（synchronized、ReenTrantLock、ReenTrantReadWirteLock）


//------------------------  TODO 乐观锁、悲观锁  -----------------------------
//  针对数据库操作的一种锁

