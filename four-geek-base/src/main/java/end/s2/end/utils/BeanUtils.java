package end.s2.end.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import org.springframework.cglib.beans.BeanCopier;

public class BeanUtils {
    private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    private BeanUtils() {
        super();
    }

    /**
     * </br>
     * 新方法 copyProperties(Class<T> src, Class<V> dest)
     *
     * @param src
     * @param dest
     */
    public static void copyProperties(Object src, Object dest) {
        if (null == src || null == dest) {
            return;
        }
        String beanKey = generateKey(src.getClass(), dest.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(src.getClass(), dest.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(src, dest, null);
    }

    public static <V> V copyProperties(Object src, Class<V> clazz) {
        if (null == src) {
            return null;
        }
        String beanKey = generateKey(src.getClass(), clazz);
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(src.getClass(), clazz, false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        V destObj = null;
        try {
            destObj = clazz.newInstance();
            copier.copy(src, destObj, null);
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("Bean复制出现异常", e);
        }
        return destObj;

    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    public static <T, V> List<V> coventList(final List<T> srcList, final Class<V> clazz) {
        if (clazz != null && !isEmpty(srcList)) {
            List<V> list = Lists.newArrayList();
            srcList.forEach(t -> {
                V v = BeanUtils.copyProperties(t, clazz);
                list.add(v);
            });
            return list;
        }
        return Lists.newArrayList();
    }

    public static boolean isEmpty(Collection collection)
    {
        return collection == null || collection.isEmpty();
    }


}
