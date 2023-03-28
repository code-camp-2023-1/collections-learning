package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo<T> {
    //T[] items = new T[100]; //无法创建泛型数组
    //T t = new T(); // //无法创建泛型对象
    public void doSomething(Object element) {
        // 无法对泛型进行实例判断
        /**
        if (element instanceof T) {
            System.out.println("element is T instance");
        }
         **/
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        // MyGenericArrayListV2<String> genericArrayListV2 = new MyGenericArrayListV2<>();
        List<String> stringList = new ArrayList<>(); // List stringList

        // 类型擦除 Type erasure -> 改变javac编译器，不需要改字节码，也不需要改虚拟机




    }
}
