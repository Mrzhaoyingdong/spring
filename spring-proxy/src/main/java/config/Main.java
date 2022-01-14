package config;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s1.add("d");

        s2.add("b");
        s2.add("d");
        s2.add("e");
        s2.add("f");

        s1.removeAll(s2);
        System.out.println(s1);
    }
}
