package arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
    class User {
        int id;
        String name;

    }
    public static void main(String[] args) {
        // 如何构造声明ArrayList

        // (1) 不带类型的
        ArrayList list = new ArrayList();

        // (2) 带类型声明 <>里面全部要引用类型 （基本类型要转化成包装类）
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        // (3) 推荐写法
        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<User> users = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>(100);

        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(3);
        c.add(2);
        c.add(3);
        c.add(1);
        c.add(1);

        List<Integer> integerList2 = new ArrayList<>(c);
        List<Integer> integerList3 = new ArrayList<>();
        for (Integer integer : c) {
            integerList3.add(integer);
        }

        // size/isEmpty/contains
        System.out.println("Size: " + integerList.size());
        integerList.add(100);
        System.out.println("Size: " + integerList.size());
        System.out.println("Is empty: " + integerList.isEmpty());

        if (integerList2.isEmpty()) {
            System.out.println("The list is empty");
        }

        // Expected: 3
        System.out.println("Size of integer list 2: " + integerList2.size());

        System.out.println("contains abc: " + integerList.contains("abc"));
        System.out.println("contains 100: " + integerList.contains(100));

        // indexOf/lastIndexOf
        System.out.println("Index of 100 in integer list 2: "
                + integerList2.indexOf(100));

        System.out.println("Index of 1 in integer list 2: "
                + integerList2.indexOf(1));

        System.out.println("Index of 3 in integer list 2: "
                + integerList2.indexOf(3));

        System.out.println("Index of 2 in integer list 2: "
                + integerList2.indexOf(2));

        // Expected: 4
        System.out.println("Last index of 1 in integer list 2: "
                + integerList2.lastIndexOf(1));

        // Expected: 3
        System.out.println("Last index of 3 in integer list 2: "
                + integerList2.lastIndexOf(3));

        // Expected: 2
        System.out.println("Last index of 2 in integer list 2: "
                + integerList2.lastIndexOf(2));

        System.out.println("Last index of abc in integer list 2: "
                + integerList2.lastIndexOf("abc"));

        // toArray方法
        Object[] arrays = integerList2.toArray();

        for (Object array : arrays) {
            int number = (int) array;
            System.out.println("number in arrays: " + number);
        }

        Integer[] ints = integerList2.toArray(new Integer[0]);
        for (int number : ints) {
            System.out.println("int number: " + number);
        }

        System.out.println("length of ints: " + ints.length);

        // get/add/remove/set

        // get(index) - array[index]
        System.out.println("Element in index 0: " + integerList2.get(0));

        // 遍历
        for (Integer num : integerList2) {
            System.out.println("num: " + num);
        }

        for (int i = 0; i < integerList2.size(); i++) {
            System.out.println("Get number: " + integerList2.get(i));
        }

        // 遍历 lambda 之后学
        integerList2.forEach(System.out::println);

        // set(index, value) - array[index] = value

        // Expected: 3
        System.out.println("Element in index 1: " + integerList2.get(1));
        integerList2.set(1, 10);
        // Expected: 10
        System.out.println("Element in index 1 after setting: " + integerList2.get(1));

        // add
        integerList2.add(5); // 加到最后
        System.out.println("Element in index 6 after adding: " + integerList2.get(6));
        System.out.println("Size: " + integerList2.size());

        integerList2.add(2, 100); //加到index位置，其他后面的元素往右移
        System.out.println("Size: " + integerList2.size()); // 7 or 8 ?


        for (int i = 0; i < integerList2.size(); i++) {
            System.out.println("Index: " + i + " Number: " + integerList2.get(i));
        }

        // remove

        int toRemoved = integerList2.remove(3);
        System.out.println("The element to removed: " + toRemoved);
        boolean isSuccess = integerList2.remove(new Integer(1));
        System.out.println(isSuccess);

        for (int i = 0; i < integerList2.size(); i++) {
            System.out.println("Index: " + i + " Number: " + integerList2.get(i));
        }

        // clear
        System.out.println("Size: " + integerList2.size());
        integerList2.clear();
        System.out.println("Size after method clear(): " + integerList2.size());

        for (int i = 0; i < integerList2.size(); i++) {
            System.out.println("Index: " + i + " Number: " + integerList2.get(i));
        }



    }
}
