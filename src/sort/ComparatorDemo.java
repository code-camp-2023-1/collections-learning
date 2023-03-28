package sort;

import java.util.*;

public class ComparatorDemo {

    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public static void main(String[] args) {
        // Comparator接口 -> 参数传入
        List<String> stringList = new ArrayList<>();
        stringList.add("zba");
        stringList.add("z");
        stringList.add("yx");
        stringList.add("abc");
        stringList.add("a");

        // 1. 写Comparator的实现类，实例化
        Comparator<String> comparator = new StringComparator();
        stringList.sort(comparator); // 等价于Collections.sort(stringList, comparator);


        // 按字母序排序
        stringList.forEach(System.out::println);

        // 2. 匿名类
        // Student -> 先按分数倒序，然后按名字正序
        Student[] students = new Student[6];
        students[0] = new Student(1, "xiaofang", 90);
        students[1] = new Student(2, "xiaoming", 86);
        students[2] = new Student(3, "xiaohong", 94);
        students[3] = new Student(4, "xiaoyuan", 78);
        students[4] = new Student(5, "xiaoxiao", 86);
        students[5] = new Student(6, "a", 86);

        for (Student student : students) {
            System.out.println("Student before sorting: " + student.toString());
        }

        // 就要按分数从低到高
        Arrays.sort(students);

        for (Student student : students) {
            System.out.println("Student with comparable sorting: " + student.toString());
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        });

        // lambda表达式写法
        // Arrays.sort(students, (o1, o2) -> o1.getScore() - o2.getScore());
        // Arrays.sort(students, Comparator.comparingInt(Student::getScore));



        for (Student student : students) {
            System.out.println("Student with comparator sorting: " + student.toString());
        }


                





    }
}
