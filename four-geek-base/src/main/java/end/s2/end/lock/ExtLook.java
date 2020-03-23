package end.s2.end.lock;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/23 9:55
 */
public interface ExtLook {
    //ExtLock基于zk实现分布式锁
    void getLock();

    //释放锁
    void unLock();
}
