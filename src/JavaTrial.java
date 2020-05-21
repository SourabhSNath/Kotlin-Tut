import java.util.ArrayList;
import java.util.Arrays;

public class JavaTrial {
    public JavaTrial(String s) {
        s = "This is a useless constructor";
    }

    public static void main(String[] args) {

        System.out.println();

        String s = "Sourabh";
        var x = s.toCharArray();
        var l = new ArrayList<Character>();
        for (var c : x) {
            l.add(c);
        }

        var that = That.thatter();

        System.out.println(l);

        var color = Color.Red;
        System.out.println(color.getColor());
    }

    private static void method() {
        var list = Arrays.asList(1, 22, 3);
        var sum = list.stream().mapToInt(Integer::intValue).sum();
    }
}

class Sth extends JavaTrial {

    public Sth(String s) {
        super(s);
    }
}

abstract class That {
    static int thatter() {
        return 0;
    }
}

enum Color {
    Red("RED COLOR"), Blue("BLUE"), Green("GREEN");

    private final String color;

    private Color(String color) {
        this.color = color;
    }

    String getColor() {
        return color;
    }
};