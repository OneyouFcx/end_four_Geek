package end.s2.end.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/23 10:10
 */

public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {


    @Override
    boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
        } catch (ZkNodeExistsException e) {
            return false;
        }
        return true;
    }

    @Override
    void waitLock() {
        CountDownLatch cdl = new CountDownLatch(1);
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataDeleted(String dataPath) {
                System.out.println("收到节点被删除的消息,停止等待,重新争夺锁");
                cdl.countDown();
            }

            @Override
            public void handleDataChange(String dataPath, Object data) {
            }
        };
        // 监听
        zkClient.subscribeDataChanges(lockPath, listener);
        // 判断锁节点是否存在，存在的话表明有别人
        if (this.zkClient.exists(lockPath)) {
            try {
                // 等待接收到消息后,继续往下执行
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 取消监听消息
        zkClient.unsubscribeDataChanges(lockPath, listener);
        // 需要再次校验有没有别的线程枪锁成功
        getLock();
    }

    // ------------------------------------  根据临时节点排序 获取锁

    /*    *//**
     * 尝试加锁
     *
     * @return
     *//*
    @Override
    public boolean tryLock() {
        // 创建临时顺序节点
        if (this.currentPath == null) {
            // 在lockPath节点下面创建临时顺序节点
            currentPath = zkClient.createEphemeralSequential(lockPath +"/","asd");
        }
        // 获得所有的子节点
        List<String> children = this.zkClient.getChildren(lockPath);

        // 排序list
        Collections.sort(children);

        // 判断当前节点是否是最小的,如果是最小的节点,则表明此这个client可以获取锁
        if (currentPath.equals(lockPath + "/" + children.get(0))) {
            return true;
        } else {
            // 如果不是当前最小的sequence,取到前一个临时节点
            // 1.单独获取临时节点的顺序号
            // 2.查找这个顺序号在children中的下标
            // 3.存储前一个节点的完整路径
            int curIndex = children.indexOf(currentPath.substring(lockPath.length() + 1));
            beforePath = lockPath + "/" + children.get(curIndex - 1);
        }
        return false;
    }
    @Override
    public void waitLock() {
        CountDownLatch cdl = new CountDownLatch(1);
        // 注册watcher
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataDeleted(String dataPath) {
                System.out.println("监听到前一个节点被删除了："+dataPath);
                cdl.countDown();
            }
            @Override
            public void handleDataChange(String dataPath, Object data)  {

            }
        };

        // 监听前一个临时节点
        zkClient.subscribeDataChanges(this.beforePath, listener);

        // 前一个节点还存在,则阻塞自己
        if (this.zkClient.exists(this.beforePath)) {
            try {
                // 直至前一个节点释放锁,才会继续往下执行
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 醒来后,表明前一个临时节点已经被删除,此时客户端可以获取锁 && 取消watcher监听
        zkClient.unsubscribeDataChanges(this.beforePath, listener);
    }*/
}
