package capgemini.lecture2_homework;

import java.util.List;

public class StringReplacement {

    // this is Mr.Segey the initial variant with in plus a regex input verification

    public static String replaceVarInit(final String text) {

        final List<String> RULES = List.of("AB", "BA", "CD", "DC");

        if (text == null || text.isEmpty()) {
            return text;
        }

        if (!text.matches("[A-D]+")) {
            System.out.println("you have to enter a string containing only leters : A,B,C,D in any order");
        }
        boolean changed = true;

        String current = text;

        while (changed) {

            int lengthBegin = current.length();

            for (String rule : RULES) {
                current = current.replaceAll(rule, "");
            }
            changed = lengthBegin != current.length();
        }

        return current;
    }

// this is variant witch is executed with aprox.50 % lower time
    public static String replaceVar1(final String text) {

        final List<String> RULES = List.of("AB", "BA", "CD", "DC");

        if (text == null || text.isEmpty()) {
            return text;
        }

        if (!text.matches("[A-D]+")) {
            System.out.println("you have to enter a string containing only leters : A,B,C,D in any order");
        }

        boolean changed = true;

        String current = text;

        // 1.I made a preliminary remove

        for (String rule : RULES) {
            // if (current.contains(rule)){
            current = current.replace(rule, "");//}
        }
// 2.Verify if is necesary to go formard with replace

        if (current.contains("AB") || current.contains("BA") || current.contains("CD") || current.contains("DC")) {

// 3.If is necesary I apply exact Mr.Sergey method
            while (changed) {

                int lengthBegin = current.length();

                for (String rule : RULES) {
                    // if (current.contains(rule)){
                    current = current.replaceAll(rule, "");//}
                }
                changed = lengthBegin != current.length();
            }
        }

        return current;
    }


    public static void main(String[] args) {

        String probeStr = "ABABABABABABABBCBCBCBCB";

        // a way to measure the time necesary to execute one or the other method
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            replaceVar1(probeStr);
        }

        long finishTime = System.nanoTime();

        System.out.println(replaceVar1(probeStr));

        System.out.println((int) (finishTime - startTime) / 1_000_000 + " ms");
    }

}

