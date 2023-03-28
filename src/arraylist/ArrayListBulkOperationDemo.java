package arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListBulkOperationDemo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("A");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("A");
        stringList2.add("a");
        stringList2.add("z");
        // addAll/removeAll/retainAll - 在ArrayList里面实现

        // containsAll - 在AbstractCollection实现，并不是在ArrayList里面实现
        boolean containsAllResult = stringList.containsAll(stringList2);
        System.out.println("Result of method containsAll: " + containsAllResult);

        // addAll
        // 加到ArrayList最后
        stringList.addAll(stringList2);
        for (String str : stringList) {
            System.out.println("String Element: " + str);
        }

        // 加到index位置，后面的元素往后移
        stringList.addAll(1, stringList2);
        // Expected: a A a z b A A a z
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Index: " + i + " String: " + stringList.get(i));
        }

        // removeAll

        // string list: a A a z b A A a z
        Collection<String> stringList3 = new ArrayList<>();
        stringList3.add("a");
        stringList3.add("a");
        stringList3.add("A");
        stringList3.add("Y");

        boolean removeAllResult = stringList.removeAll(stringList3);
        System.out.println("Result of method removeAll: " + removeAllResult);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("removeAll Index: " + i + " String: " + stringList.get(i));
        }

        // retainAll - 类似于交集操作，返回相同的部分
        List<String> stringList4 = new ArrayList<>();
        stringList4.add("a");
        stringList4.add("a");
        stringList4.add("b");
        stringList4.add("b");
        stringList4.add("b");
        stringList4.add("b");
        stringList4.add("b");
        stringList4.add("A");
        List<String> stringList5 = new ArrayList<>();
        stringList5.add("A");
        stringList5.add("a");
        stringList5.add("b");
        stringList5.add("z");

        boolean retainAllResult = stringList4.retainAll(stringList5);

        System.out.println("Result of method retainAll: " + retainAllResult);
        for (int i = 0; i < stringList4.size(); i++) {
            System.out.println("retainAll Index: " + i + " String: " + stringList4.get(i));
        }

    }
}
