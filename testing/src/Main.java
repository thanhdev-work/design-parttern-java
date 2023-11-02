import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        A a = (A) b;
        System.out.println(a.print());
    }

    public interface A {
        String print();
    }

    public static class B implements A {

        public B() {
        }

        @Override
        public String print() {
            return "B";
        }
    }

    public static class C implements A {
        public C() {
        }

        @Override
        public String print() {
            return "C";
        }
    }


}