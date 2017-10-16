package simple.pattern.orm.tree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import simple.pattern.orm.tree.object.CatagoryObject;
import simple.pattern.orm.tree.table.CatagoryRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tykkidream on 2017/10/16.
 */
public class TreeTest {
    TreeRowBuilder treeRowBuilder = new TreeRowBuilder<CatagoryObject, CatagoryRow>() {
        @Override
        public CatagoryRow buildFromTree(CatagoryObject tree) {
            return null;
        }

        @Override
        public CatagoryObject buildFromRow(CatagoryRow row) {
            CatagoryObject catagoryObject = new CatagoryObject();
            catagoryObject.setId(row.getId());
            catagoryObject.setParentId(row.getParentId());
            catagoryObject.setName(row.getName());
            return catagoryObject;
        }
    };

    @Test
    public void test(){
        List<CatagoryRow> catagoryRows = createCatagoryRows();

        System.out.println("原数据：");
        System.out.println(JSON.toJSONString(catagoryRows, SerializerFeature.PrettyFormat));

        List<CatagoryObject> catagoryObjects = TreeHelper.rowToTree(catagoryRows, treeRowBuilder);

        System.out.println("转换结果：");
        System.out.println(JSON.toJSONString(catagoryObjects, SerializerFeature.PrettyFormat));
    }

    private List<CatagoryRow> createCatagoryRows() {
        List<CatagoryRow> catagoryRows = new ArrayList<>(6);

        catagoryRows.add(createCatagoryRows(0L, 0L, "tree-0"));
        catagoryRows.add(createCatagoryRows(1L, 0L, "tree-0-1"));
        catagoryRows.add(createCatagoryRows(2L, 0L, "tree-0-2"));
        catagoryRows.add(createCatagoryRows(3L, 1L, "tree-0-1-3"));
        catagoryRows.add(createCatagoryRows(4L, 1L, "tree-0-1-4"));
        catagoryRows.add(createCatagoryRows(5L, 5L, "tree-5"));

        return catagoryRows;
    }

    private CatagoryRow createCatagoryRows(long id, long parentId, String name) {
        CatagoryRow catagoryRow = new CatagoryRow();
        catagoryRow.setId(id);
        catagoryRow.setParentId(parentId);
        catagoryRow.setName(name);
        return catagoryRow;
    }
}
