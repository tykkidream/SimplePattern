package simple.pattern.orm.tree.object;

import simple.pattern.orm.tree.Tree;

import java.util.List;

/**
 * Created by Tykkidream on 2017/10/16.
 */
public class CatagoryObject implements Tree<Long, CatagoryObject> {
    private Long id;

    private Long parentId;

    private String path;

    private String name;

    private List<CatagoryObject> child;

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

    public List<CatagoryObject> getChild() {
        return child;
    }

    public void setChild(List<CatagoryObject> child) {
        this.child = child;
    }
}
