package end.s2.nb;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
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

                            try {
                                //Thread.sleep(new Random().nextInt(200));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (index == 10) {
                                break;
                            }
                        } finally {
                            //lock.unlock();
                        }

                    }

                } catch (Exception e) {
                    System.out.println("5555");
                } finally {
                    lock.unlock();
                }
            }
        }).start();

       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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
