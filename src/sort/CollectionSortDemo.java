package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(50);
        list.add(7);
        list.add(14);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(26);

        for (Integer element : list) {
            System.out.println("Element of list before sorting: " + element);
        }

        //升序排序
        Collections.sort(list);

        for (Integer element : list) {
            System.out.println("Element of list after sorting: " + element);
        }

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(0.5);
        doubleList.add(50.13);
        doubleList.add(0.7);
        doubleList.add(0.14);
        doubleList.add(0.1);
        doubleList.add(0.2);
        doubleList.add(0.2);
        doubleList.add(0.26);

        Collections.sort(doubleList);

        for (Double element : doubleList) {
            System.out.println("Element of double list after sorting: " + element);
        }

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "xiaofang", 90));
        studentList.add(new Student(2, "xiaoming", 86));
        studentList.add(new Student(3, "xiaohong", 94));
        studentList.add(new Student(4, "xiaoyuan", 78));
        studentList.add(new Student(5, "xiaoxiao", 86));
        studentList.add(new Student(6, "a", 86));

        Collections.sort(studentList);

        for (Student s : studentList) {
            System.out.println("Student after sorting: " + s);
        }





    }
}
