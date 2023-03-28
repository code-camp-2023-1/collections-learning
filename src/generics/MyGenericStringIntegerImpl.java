package generics;

public class MyGenericStringIntegerImpl implements MyGenericI<String, Integer> {
    @Override
    public Integer getElement(String param) {
        return Integer.parseInt(param);
    }

    public <T> void setConfiguration(String configName, T config) {

    }

    public <T> T getConfig(String name) {
        return null;
    }

    public <B, A> B doSomething(A something) {
        System.out.println("Do something");
        return null;
    }

    public static void main(String[] args) {
        MyGenericI<String, Integer> myGenericI = new MyGenericStringIntegerImpl();
        MyGenericStringIntegerImpl myGenericStringInteger = new MyGenericStringIntegerImpl();

        Integer result = myGenericStringInteger.doSomething("Homework");

        Boolean booleanResult = myGenericStringInteger.doSomething(100L);

    }





}
