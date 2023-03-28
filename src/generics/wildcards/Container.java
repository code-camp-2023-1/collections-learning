package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Container<T> {
    List<T> items;

    public Container() {
        this.items = new ArrayList<>();;
    }

    public List<T> getItems() {
        return items;
    }

    public void addItem(T item) {
        items.add(item);
    }

    // 无限定通配符 ？：List<?> list表示list可以持有任意类型的元素
    public static void process(List<?> list) {
        //不确定list里面具体是什么类型，所以不能进行写操作
        //list.add(new Integer(1));
        //list.add("abc");
        //list.add(new Apple());
        for (Object obj : list) {
            System.out.println(obj);
        }

        Object element = list.get(0);
        System.out.println("Element: " + element);
    }

    // 上界通配符 ？extends T ：List<? extends Fruit> list表示list中持有Fruit以及Fruit子类的对象
    public static void processWithExtends(List<? extends Fruit> list) {
        // 不确定list里面具体是什么类型，所以不能进行写操作
        // 有可能是Apple，有可能是Banana，也有可能是Fruit
        // list.add(new Apple()); //Error
        // list.add(new Banana()); //Error
        // list.add(new Fruit()); //Error

        Fruit element = list.get(0);
        System.out.println("processWithExtends - element: " + element);
    }

    // 下界通配符 ？super T ：List<? super Fruit> list表示list中持有Fruit以及Fruit父类的对象
    public static void processWithSuper(List<? super Fruit> list) {
        // 有可能是Apple，有可能是Banana，也有可能是Fruit
        list.add(new Apple());
        Fruit fruit = new Apple();
        list.add(fruit);
        list.add(new Banana());
        list.add(new Fruit());
        // list.add(new Object());
        // list.add(new Food());

        // Apple apple = list.get(0); // Error
        // Fruit fruit1 = list.get(1); // Error
        Object object = list.get(0);

        // System.out.println("processWithSuper - element: " + element);
    }

    public void doSomething() {
        Container<T> tContainer = new Container<>();
        tContainer.process(tContainer.getItems());
    }


    public static void main(String[] args) {
        Container<Apple> appleContainer = new Container<>();
        appleContainer.addItem(new Apple());

        List<Apple> appleList = appleContainer.getItems();


        Container<Banana> bananaContainer = new Container<>();
        bananaContainer.addItem(new Banana());
        bananaContainer.addItem(new Banana());

        List<Banana> bananaList = bananaContainer.getItems();

        Container<Food> foodContainer = new Container<>();
        foodContainer.addItem(new Food());
        List<Food> foodList = foodContainer.getItems();

        Container<?> appleContainer2 = new Container<Apple>();

        process(appleList);
        process(bananaList);
        process(foodList);
        // process(new ArrayList<String>());

        // 上界通配符
        processWithExtends(appleList);
        processWithExtends(bananaList);

        List<GreenApple> greenAppleList = new ArrayList<>();
        greenAppleList.add(new GreenApple());

        processWithExtends(greenAppleList);
        // processWithExtends(foodList);
        // processWithExtends(new ArrayList<Object>());

        // 下界通配符
        ArrayList<Object> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object());
        processWithSuper(objectArrayList);
        // processWithSuper(appleList);
        processWithSuper(foodList);

    }
}
