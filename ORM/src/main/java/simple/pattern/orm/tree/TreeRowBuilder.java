package simple.pattern.orm.tree;

public interface TreeRowBuilder<T extends Tree, R extends Row> {
    R buildFromTree(T tree);

    T buildFromRow(R row);
}
