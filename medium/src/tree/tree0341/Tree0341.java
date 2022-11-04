package tree.tree0341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0341
 * @create 2022-11-04-20:01
 */
public class Tree0341 {
    public static void main(String[] args) {

    }
}

//public class NestedIterator implements Iterator<Integer> {
//    private List<Integer> vals;
//    private Iterator<Integer> cur;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        vals = new ArrayList<Integer>();
//        dfs(nestedList);
//        cur = vals.iterator();
//    }
//
//    @Override
//    public Integer next() {
//        return cur.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return cur.hasNext();
//    }
//
//    private void dfs(List<NestedInteger> nestedList) {
//        for (NestedInteger nest : nestedList) {
//            if (nest.isInteger()) {
//                vals.add(nest.getInteger());
//            } else {
//                dfs(nest.getList());
//            }
//        }
//    }
//}