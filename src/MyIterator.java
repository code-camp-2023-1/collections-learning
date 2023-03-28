import java.util.Iterator;

public class MyIterator implements Iterator {

    private final int[] nums;
    private int cursor;

    public MyIterator(int[] nums) {
        this.nums = nums;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != nums.length;
    }

    @Override
    public Object next() {
        int number = nums[cursor];
        cursor++;
        return number;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 6, 7, 9};
        Iterator iterator = new MyIterator(nums);

        while (iterator.hasNext()) {
            int num = (int) iterator.next();// get next element
            System.out.println("The number for iterator: " + num);
        }

        iterator.next();

        int[] nums2 = new int[]{111, 25, 23, 1, 3, 6, 7, 9};
        Iterator iterator1 = new MyIterator(nums2);

        while (iterator1.hasNext())  {
            System.out.println("The next number: " + iterator1.next());
        }
    }

}
