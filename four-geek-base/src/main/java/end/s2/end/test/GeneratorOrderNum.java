package end.s2.end.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/23 10:20
 */
public class GeneratorOrderNum {
    //区分不同的订单号
    private static int count = 0;

    //单台服务器，多个线程 同事生成订单号
    public synchronized String getNumber() {
        SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return simpt.format(new Date()) + "-" + ++count;  //时间戳后面加了 count
    }
}
