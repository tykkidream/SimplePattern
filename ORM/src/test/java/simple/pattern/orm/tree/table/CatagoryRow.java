package simple.pattern.orm.tree.table;

import simple.pattern.orm.tree.Row;

/**
 * Created by Tykkidream on 2017/10/16.
 */
public class CatagoryRow implements Row{
    private Long id;

    private Long parentId;

    private String path;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
