package end.s2.end.lock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/23 9:56
 */
public abstract class ZookeeperAbstractLock implements ExtLook {
    private static final String CONNECTION = "106.12.204.156:2181";
    protected ZkClient zkClient = new ZkClient(CONNECTION);
    protected String lockPath = "/data/lock";
    protected String currentPath;
    protected String beforePath;
    protected CountDownLatch countDownLatch;

    @Override
    public void getLock() {
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName() + "----------成功获取锁-----------");
        } else {
            // 创建失败等待
            waitLock();
        }
    }

    @Override
    public void unLock() {
        if (null != zkClient) {
            // 如果是第一种要更换为locakPath
            zkClient.delete(lockPath);
            // zkClient.delete(currentPath);
        }
    }

    //创建失败 进行等待
    abstract void waitLock();


    abstract boolean tryLock();
}
