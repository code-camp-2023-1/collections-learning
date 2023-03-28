package sort;

import java.util.Arrays;

public class ArraySortDemo {
    public static void main(String[] args) {
        int[] nums = {100, 3, 4, 5, 2, 2, 1, 3, 7, 9, 9};

        for (int num : nums) {
            System.out.println("The number before sorting: " + num);
        }

        // 按从小到大排序 升序（ascending）原址排序（没有开辟新的数组）
        Arrays.sort(nums);

        for (int num : nums) {
            System.out.println("The number after sorting: " + num);
        }

        // 结论：对基本类型数组都提供了两种sort方法
        // 1. 对整个数组排序
        // 2. 对数组中一段区间排序[fromIndex, toIndex)

        char[] chars = {'a', 'z', 'y', 'v', 'v', 'n', 'm', 'b', 'c', 'a'};

        // index [1, 4]区间排序
        Arrays.sort(chars, 1, 5);

        for (char ch : chars) {
            System.out.println("The char after sorting: " + ch);
        }


        // Student
        Student[] students = new Student[6];
        students[0] = new Student(1, "xiaofang", 90);
        students[1] = new Student(2, "xiaoming", 86);
        students[2] = new Student(3, "xiaohong", 94);
        students[3] = new Student(4, "xiaoyuan", 78);
        students[4] = new Student(5, "xiaoxiao", 86);
        students[5] = new Student(6, "a", 86);

        // 没有明确的比较规则

        // Student implements Comparable
        // 升序/降序
        Arrays.sort(students);

        for (Student student : students) {
            System.out.println("Student: " + student.toString());
        }

        String[] strings = {"abc", "zzz", "dbd", "qwer"};
        Arrays.sort(strings);
        for (String str: strings) {
            System.out.println("String after sorting: " + str);
        }

    }


}


