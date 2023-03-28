package generics;

/**
 * The array list for string.
 */
public class MyStringArrayList {
    private final static int DEFAULT_CAPACITY = 10;
    // 属性 field

    /**
     * The data storage of array list.
     */
    private String[] elementData;

    /**
     * The size of array list.
     */
    private int size;

    /**
     * The capacity of array list.
     */
    private int capacity;

    // 构造器 constructor
    public MyStringArrayList() {
        this.elementData = new String[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;

    }

    public MyStringArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("Capacity must be positive.");
        } else if (capacity < DEFAULT_CAPACITY) {
            this.elementData = new String[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
            this.size = 0;
        } else {
            this.elementData = new String[capacity];
            this.capacity = capacity;
            this.size = 0;
        }

    }

    // 方法 Method

    /**
     * Get size of array list.
     * @return the size of array list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determine whether array list contains the specific element
     * @param element Specific element
     * @return true if this array list contains the specific element.
     */
    public boolean contains(String element) {
        return indexOf(element) >= 0;
    }

    /**
     * Get the index of first occurrence of the specific element
     * @param element the specific element
     * @return The index.
     */
    public int indexOf(String element) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Add element to this array list.
     * @param element the element to add
     */
    public void add(String element) {
        add(size, element);
    }

    /**
     * Add element to specific index in array list
     * @param index the index position to add.
     * @param element the element to add
     */
    public void add(int index, String element) {
        // System.out.println("index: " + index);
        if (index < 0 || index > size) {
            throw new RuntimeException(
                    String.format("Index is invalid, index: [%d]", index));
        }

        // 判断capacity, size
        if (size == capacity) {
            // 动态扩容：new_capacity = old_capacity * 2;
            resize(size * 2);
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1]; // elementData[1] = elementData[0]
        }

        elementData[index] = element;
        size++;
    }

    /**
     * Dynamic grow
     * @param newCapacity new aimed capacity
     */
    private void resize(int newCapacity) {
        // 1. Create new array
        String[] newElementData = new String[newCapacity];

        // 2. Copy data from element data array to new element data array
        // System.arraycopy
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }

        // 3. elementData point to new array
        elementData = newElementData;

        // 4. update capacity
        this.capacity = newCapacity;

    }

    /**
     * Remove the element for specific index
     * @param index the index position to remove
     * @return the removed element
     */
    public String remove(int index) {
        // 0. index range check
        rangeCheck(index);
        // 1. Get old value by index.
        String oldValue = elementData[index];

        // 2. copy and shift
        int numToMoved = size - index - 1;
        if (numToMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numToMoved);
        }
        // 3. update size and clear
        elementData[--size] = null;

        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException(
                    String.format("Index is invalid, index: [%d]", index));
        }
    }

    /**
     * Removes the first occurrence of the specified element from this list
     * @param element the specified element to remove.
     * @return true if remove successfully
     */
    public boolean removeByValue(String element) {
        // 遍历找到element，然后再删除移动
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                int numToMoved = size - i - 1;
                if (numToMoved > 0) {
                    System.arraycopy(elementData, i + 1, elementData, i, numToMoved);
                }
                elementData[--size] = null;
                return true;

            }
        }
        return false;
    }

    /**
     * Get element by index.
     * @param index The index to get
     * @return The element to get
     */
    public String get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * Set element with the specific index
     * @param index index to set
     * @param element element to set
     * @return The old element
     */
    public String set(int index, String element) {
        rangeCheck(index);
        String oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }
}
