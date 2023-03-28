package generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureDemo {

    public void transform(List<String> list /* List list */) {

    }



    public static void main(String[] args) {

        // 类型擦除 Type erasure -> 改变javac编译器，不需要改字节码，也不需要改虚拟机
        ArrayList arrayList = new ArrayList();
        // ArrayList<String> -> ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();
        // ArrayList<Integer> -> ArrayList 裸类型 Raw Type
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        // integerArrayList.add("abd");

        arrayList = stringArrayList;
        arrayList = integerArrayList;
        arrayList.add("abc");
        arrayList.add(true);
    }
}
