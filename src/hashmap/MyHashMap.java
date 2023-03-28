package hashmap;


public class MyHashMap<K, V> {
    private static final int DEFAULT_INIT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // Fields
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public Node<K, V> setKey(K key) {
            this.key = key;
            return this;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> setValue(V value) {
            this.value = value;
            return this;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public Node<K, V> setNext(Node<K, V> next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    // 底层数组初始化的容量
    private int initCapacity;

    // 装填因子LF
    private float loadFactor;

    // Hashmap中元素个数
    private int size;

    // 采用数组 + 链表作为底层存储结构
    private Node<K, V>[] table;

    // Constructors
    public MyHashMap() {
        this(DEFAULT_INIT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.initCapacity = initCapacity;
        this.table = new Node[initCapacity];
    }

    // Methods - put/get/remove

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Put key-value entry into my hash map.
     *
     * @param key   specific key.
     * @param value value
     * @return null if add new entry, old value if key exists(update)
     */
    public V put(K key, V value) {
        if (size() >= initCapacity * loadFactor) {
            resize(initCapacity * 2);
        }
        int index = hash(key);
        Node<K, V> node = table[index];

        if (node == null) {
            // 哈希桶为空，直接插入新节点
            this.table[index] = new Node<>(key, value, null);
            size++;
            return null;
        }

        // 哈希桶不为空 两种情况
        // 1. key存在，更新value
        // 2. key不存在，新增key-value
        while (node != null) {
            if (node.key == key) {
                // key存在，更新value
                V oldValue = node.getValue();
                node.setValue(value);
                return oldValue;
            }

            if (node.getNext() == null) {
                // key不存在，新增key-value
                // 尾插法
                Node<K, V> newNode = new Node<>(key, value, null);
                node.setNext(newNode);
                size++;
            }
            node = node.getNext();
        }
        return null;
    }

    private void resize(int newCapacity) {
        System.out.println("Resizing: " + newCapacity);
        Node<K, V>[] newTable = new Node[newCapacity];
        this.initCapacity = newCapacity;
        // rehashing重哈希：遍历老的哈希表中的哈希桶
        for (Node<K, V> node : table) {
            // 遍历链表
            while (node != null) {
                // 在新哈希表的index
                int index = hash(node.getKey());
                Node<K, V> newNode = new Node<>(node.getKey(), node.getValue(), null);
                if (newTable[index] != null) {
                    // 找到合适插入的位置
                    Node<K, V> head = newTable[index];
                    while (head.getNext() != null) {
                        head = head.getNext();
                    }
                    // head.next为null
                    head.setNext(newNode);
                } else {
                    // 直接插入到头节点
                    newTable[index] = newNode;
                }
                node = node.getNext();
            }
        }
        // 最好是把老的table中的元素设置成null, help GC

        // 将新的哈希表指向table
        this.table = newTable;
    }

    private int hash(K key) {
        return Math.max((key.hashCode() % this.initCapacity), 0);
    }

    /**
     * Get related value by specific key.
     *
     * @param key specific key.
     * @return null if key not exists, otherwise, return value with the specific key.
     */
    public V get(K key) {
        // 确定哈希桶：key -> index
        int index = hash(key);

        Node<K, V> node = table[index];
        while (node != null) {
            if (node.getKey() == key) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * Remove related value by specific key.
     *
     * @param key specific key
     * @return null if key not exists, otherwise, return the value to be removed with the specific key.
     */
    public V remove(K key) {
        // 确定哈希桶：key -> index
        int index = hash(key);
        Node<K, V> node = table[index];

        // 针对于链表头节点的逻辑
        if (node == null) {
            return null;
        }

        if (node.getKey() == key) {
            // 1. 保存被删掉node的next
            V oldValue = node.getValue();
            Node<K, V> temp = node.getNext();
            // 2. node的next节点设置为null
            node.setNext(null);
            table[index] = temp;
            size--;
            return oldValue;
        }

        // 针对于非头节点的逻辑
        Node<K, V> prevNode = node;
        Node<K, V> curNode = node.getNext();

        while (curNode != null) {
            // 找到对应的K-V
            if (curNode.getKey() == key) {
                V oldValue = curNode.getValue();
                //prevNode.next = curNode.next;
                prevNode.setNext(curNode.getNext());
                curNode.setNext(null);
                size--;
                return oldValue;
            }

            prevNode = curNode;
            curNode = curNode.getNext();
        }
        return null;
    }


    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        System.out.println("Empty flag: " + hashMap.isEmpty());

        hashMap.put(10, "apple");
        hashMap.put(22, "cat");
        hashMap.put(6, "dog");
        System.out.println("Size of my hash map: " + hashMap.size());

        for (Node<Integer, String> node : hashMap.table) {
            System.out.println(node);
        }

        // Expected: apple
        System.out.println("The value of key 10: " + hashMap.get(10));
        // Expected: cat
        System.out.println("The value of key 22: " + hashMap.get(22));
        // Expected: dog
        System.out.println("The value of key 6: " + hashMap.get(6));
        // Expected: null
        System.out.println("The value of key 54: " + hashMap.get(54));

        hashMap.put(54, "cow");

        // Expected: dog
        System.out.println("The value to removed for key 6: " + hashMap.remove(6));

        // Expected: apple
        System.out.println("The value to removed for key 10: " + hashMap.remove(10));

        // Expected: null
        System.out.println("The value to removed for key 166: " + hashMap.remove(166));

        // Expected: 22 -> 54 -> null
        for (Node<Integer, String> node : hashMap.table) {
            System.out.println(node);
        }

        // Expected: 2
        System.out.println("Size of my hash map: " + hashMap.size());
        System.out.println("Empty flag: " + hashMap.isEmpty());

        MyHashMap<Integer, Integer> intHm = new MyHashMap<>(5, 0.75f);
        intHm.put(10, 3);
        intHm.put(3, 30);
        intHm.put(5, 12);
        intHm.put(4, 988);
        intHm.put(9, 12);
        intHm.put(2, 3);
        intHm.put(8, 30);
        intHm.put(7, 12);
        intHm.put(11, 988);
        intHm.put(12, 12);

        for (Node<Integer, Integer> node : intHm.table) {
            System.out.println(node);
        }

        MyHashMap<String, String> stringMap = new MyHashMap<>(5, 0.5f);
        stringMap.put("aa", "cat");
        stringMap.put("ac", "dog");
        stringMap.put("aaq", "cat");
        stringMap.put("acd", "dog");
        stringMap.put("aa", "cat-dog");
        stringMap.put("bc", "cow");
        stringMap.put("rfc", "apple");
        stringMap.put("cat", "dog");
        stringMap.put("zzz", "zzz");
        stringMap.put("ac", "vvvv");
        stringMap.put("aaaaaaaaaa", "apple");

        for (Node<String, String> node : stringMap.table) {
            System.out.println(node);
        }



    }
}
