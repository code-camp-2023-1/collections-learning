package hashmap;

public class BitOperationDemo {
    public static void main(String[] args) {
        int h1 = 32342342;
        // 0000 0001 1110 1101 1000 0001 0100 0110
        System.out.println(Integer.toBinaryString(h1));
        // 0000 0000 0000 0000 0000 0001 1110 1101
        System.out.println(Integer.toBinaryString(h1 >>> 16));

        // 0000 0001 1110 1101 1000 0001 0100 0110
        // 0000 0000 0000 0000 0000 0001 1110 1101
        // 0000 0001 1110 1101 1000 0000 1010 1011
        // 0000 0001 1110 1101 1000 0000 1010 1011
        int result = h1 ^ (h1 >>> 16);
        System.out.println(Integer.toBinaryString(result));
    }
}
