package simple.pattern.orm.tree;

/**
 * 请求一个数据行
 * @param <T> 单列主键的类型
 */
public interface Row<T> {
    T getId();

    T getParentId();
}
