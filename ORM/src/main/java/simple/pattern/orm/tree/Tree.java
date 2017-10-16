package simple.pattern.orm.tree;

import java.util.List;

/**
 * 表示对象
 * @param <T> 表示ID类型
 * @param <X> 表示数据类型，为实现Tree接口的类自己
 */
public interface Tree<T, X extends Tree> extends Row<T>{
    List<X> getChild();

    void setChild(List<X> child);
}
