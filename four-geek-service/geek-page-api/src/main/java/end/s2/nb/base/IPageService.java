package end.s2.nb.base;

import java.util.List;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 12:48
 */
public interface IPageService<V, D> {

    List<V> queryList(D dto);
}
