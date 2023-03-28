package hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        // 如何构造HashMap
        Map<String, Double> map = new HashMap<>();

        // size/isEmpty
        System.out.println("Size of map: " + map.size()); // 0
        System.out.println("IsEmpty result: " + map.isEmpty()); // true

        // put/putAll/putIfAbsent

        // 1. put：把键值对放入hash map （包含增和改）
        Double oldValue = map.put("abc", 2.3); // null -> add
        System.out.println("The value of abc: " + oldValue);
        System.out.println("The current value of abc: " + map.get("abc")); // 2.3
        oldValue = map.put("abcd", 2.56);
        System.out.println("The value of abcd: " + oldValue); // null -> add
        System.out.println("The current value of abcd: " + map.get("abcd")); // 2.56
        // 覆盖原来键值对，除非你明确地知道要去更新键值对的时候，可以用重复的key调用put方法（更新）
        oldValue = map.put("abc", 2.5);
        System.out.println("2nd: The value of abc: " + oldValue); // 2.3 (old value) -> update
        System.out.println("2nd: The current value of abc: " + map.get("abc")); // 2.5

        // 特例
        oldValue = map.put(null, null); // add
        System.out.println("The value of null: " + oldValue);

        oldValue = map.put(null, null); // update
        System.out.println("The value of null: " + oldValue);

        // 2. putIfAbsent: map.get(key）为null，就把key-value放入map，否则返回key之前对应的value
        Double v = map.putIfAbsent("abc", 10.02); // 2.5
        System.out.println("v of abc: " + v);
        v = map.putIfAbsent("a", 111.11); // null -> add
        System.out.println("v of a: " + v);
        System.out.println("The value of key a: " + map.get("a")); // 111.11

        // 3. putAll 一般情况不建议使用
        System.out.println("The value of key d before putAll: " + map.get("d"));
        System.out.println("The value of key e before putAll: " + map.get("e"));
        System.out.println("The value of key a before putAll: " + map.get("a"));
        Map<String, Double> newMap = new HashMap<>();
        newMap.put("d", 100.12);
        newMap.put("e", 100.13);
        newMap.put("a", 0.1);
        map.putAll(newMap);
        System.out.println("The value of key d: " + map.get("d"));
        System.out.println("The value of key e: " + map.get("e"));
        System.out.println("The value of key a: " + map.get("a"));

        // get/getOrDefault

        // 1. get方法：（1)key在map中：对于传入的key, 存在value，返回这个value （2）key不在map中：对于传入的key， 不存在对应的键值对，返回空
        Double valueOfABC = map.get("abc");
        System.out.println("The value of key abc: " + valueOfABC);

        Double valueOfJava = map.get("java");
        System.out.println("The value of key java: " + valueOfJava);

        // 特例
        map.put("jirengu", null);
        System.out.println("The value of key jirengu: " + map.get("jirengu"));

        System.out.println("The value of key null: " + map.get(null));

        // 2. getOrDefault
        Double valueOfMethodGetOrDefault = map.getOrDefault("a", 10.05);
        System.out.println("The value of getOrDefault for key a: " + valueOfMethodGetOrDefault);

        valueOfMethodGetOrDefault = map.getOrDefault("method", 0.333333);
        System.out.println("The value of getOrDefault for key method: " + valueOfMethodGetOrDefault);

        // containsKey/containsValue
        System.out.println("The result of a: " + map.containsKey("a")); // true
        System.out.println("The result of method: " + map.containsKey("method")); // false

        System.out.println("The result of value 0.11111111: " + map.containsValue(0.11111111)); // false
        System.out.println("The result of value 2.5: " + map.containsValue(2.5)); // true

        // remove
        Double valueToRemove = map.remove("a"); // 0.1
        System.out.println("value to remove for key a: " + valueToRemove);
        System.out.println("The value of key a: " + map.get("a"));
        valueToRemove = map.remove("method"); // null
        System.out.println("value to remove for key method: " + valueToRemove);

        // "abc" -> 2.5
        System.out.println("Size of map: " + map.size());
        boolean isSuccess = map.remove("abc", 100.01);
        System.out.println("Flag isSuccess: " + isSuccess);
        System.out.println("Size of map: " + map.size());
        System.out.println("The value of key abc: " + map.get("abc")); // 2.5
        isSuccess = map.remove("abc", 2.5);
        System.out.println("Flag isSuccess: " + isSuccess); // true
        System.out.println("Size of map: " + map.size());
        System.out.println("The value of key abc: " + map.get("abc")); // null

        // replace -> 代替put做更新操作 只用于更新，如果key不存在，返回null
        oldValue = map.replace("e", 0.55); // 100.13
        System.out.println("The old value before replacing for key e: " + oldValue); //100.13
        System.out.println("The current value for key a: " + map.get("e")); // 0.55

        // keySet/values/entrySet
        Set<String> keys = map.keySet();

        // 遍历所有的key
        for (String key : keys) {
            System.out.println("The key in map: " + key);
        }

        Collection<Double> values = map.values();

        // 遍历所有的value
        for (Double value : values) {
            System.out.println("The value in map: " + value);
        }

        Set<Map.Entry<String,Double>> entries = map.entrySet();

        // 遍历所有的entry
        for (Map.Entry<String,Double> entry : entries) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("The entry in map: " + key + " value: " + value);
        }

















    }
}
