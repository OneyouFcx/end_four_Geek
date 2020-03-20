package end.s2.nb.base;

import java.util.List;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 10:28
 */
public interface IBaseService<V, D> {
    List<V> queryList(D v);
}
