package end.s2.nb.mapper.base;

import java.util.List;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 10:05
 */
public interface BaseMapper<T> {
    /**
     * 查询
     *
     * @param param
     * @return
     */
    List<T> queryAllByKey(T param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    int updateByKey(T param);

    /**
     * 新增
     *
     * @param param
     * @return
     */
    int insert(T param);

    /**
     * 删除
     *
     * @param param
     * @return
     */
    int delBykey(T param);
}
