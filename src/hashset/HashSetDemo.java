package hashset;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        // 如何构造HashSet
        Set<String> set = new HashSet<>();

        Collection<Integer> c = new ArrayList<>();
        c.add(100);
        c.add(100);
        c.add(1);
        c.add(1);
        c.add(1);
        c.add(1);
        c.add(5);
        Set<Integer> integerSet = new HashSet<>(c);

        // size/IsEmpty

        // Expected: 3
        System.out.println("Size of integer set: " + integerSet.size());
        System.out.println("IsEmpty for set: " + set.isEmpty());

        // contains

        if (integerSet.contains(100)) {
            System.out.println("100 belongs to this set.");
        } else {
            // doSomething
        }

        System.out.println("Java is in set? - " + set.contains("Java"));

        // add
        set.add("String");
        set.add("Java");
        set.add("XXXXX");

        System.out.println("IsEmpty for set: " + set.isEmpty());
        System.out.println("Java is in set after adding ? - " + set.contains("Java"));
        System.out.println("java is in set after adding ? - " + set.contains("java"));

        // remove
        System.out.println("Size: " + set.size());
        System.out.println("Remove result for XXXX: " + set.remove("XXXX"));
        System.out.println("Size after removing XXXX: " + set.size());
        System.out.println("Remove result for XXXXX: " + set.remove("XXXXX"));
        System.out.println("Size: " + set.size());

        // bulk operation
        List<String> stringList = new ArrayList<>();
        stringList.add("123X");
        stringList.add("String");
        stringList.add("Java");
        set.addAll(stringList);
        System.out.println("Size after addAll: " + set.size());

        System.out.println("RetainAll: " + set.retainAll(stringList));
        // System.out.println("RemoveAll: " + set.removeAll(stringList));

        // 如何遍历HashSet
        // 1. 迭代器(不推荐）
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator Element: " + iterator.next());
        }

        // 2. for-each（推荐）
        for (String element : set) {
            System.out.println("Foreach Element: " + element);
        }

        // 3. lambda（个人最推荐）
        set.forEach(System.out::println);
        set.forEach(element -> System.out.println("Foreach Element: " + element));





    }
}
