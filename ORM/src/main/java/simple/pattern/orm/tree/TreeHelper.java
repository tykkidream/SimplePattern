package simple.pattern.orm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeHelper {
    public static  <I,X extends Tree<I, X>, R extends Row<I>> List<X> rowToTree(List<R> rows, TreeRowBuilder<X, R> builder){

        HashMap<I, X> treeMap = new HashMap<>(rows.size());

        int outermostCount = 0;

        for (R row : rows) {
            X tree = builder.buildFromRow(row);

            treeMap.put(tree.getId(), tree);

            if (isaBoolean(row)) {
                outermostCount++;
            }
        }

        List<X> trees = new ArrayList<>(outermostCount);

        for (Map.Entry<I, X> entry : treeMap.entrySet()){
            X tree = entry.getValue();

            if (isaBoolean(tree)) {
                trees.add(tree);
            } else {
                X parentTree = treeMap.get(tree.getParentId());
                if (parentTree == null){
                    // Warn
                    continue;
                }
                List<X> child = parentTree.getChild();
                if (child == null) {
                    child = new ArrayList<>();
                    parentTree.setChild(child);
                }
                child.add(tree);
            }
        }

       return trees;
    }

    private static <I, R extends Row<I>> boolean isaBoolean(R row) {
        return row.getId().equals(row.getParentId()) || row.getParentId() == null;
    }
}
