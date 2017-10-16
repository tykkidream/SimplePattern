说明
=================

本工具是将表结构为`id`、`parent_id`的平面结构，转换为具有`List child`字段的树形结构。

[Test示例](src/test/java/simple/pattern/orm/tree/TreeTest.java)

- `CatagoryRow`类表示产品类型表的实体，`id`为主键，`parentId`为父项主键，`name`为名称。如果`id`与`parentId`相同，表示这是一个根节点。
- `CatagoryObject`类表示产品类型的聚合，`id`、`parentId`、`name`与`CatagoryRow`一样，`child`表示子项集合，每个子项也是`CatagoryObject`类型。