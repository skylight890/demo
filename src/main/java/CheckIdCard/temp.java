package CheckIdCard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temp {

    public static void getNum(String str1) {
        String pattern = "(\\d{17}(x|X))|(\\d{18,})";
        //String pattern = "\w+@(\w+\.)+\w+";
        Matcher m = Pattern.compile(pattern).matcher(str1);
//        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
////            System.out.println("Found value: " + m.group(2) );
////            System.out.println("Found value: " + m.group(3) );
//        } else {
//            System.out.println("NO MATCH");
//        }
        while(m.find()){
            String a = m.group();
            System.out.println(a);
        }
    }

    public static void main(String args[]) {
        //getNum("1234abc2320830198907050034fww32083088819890705003X32083019890705005x");
        //getNum("hello abc bbc cbc ccc");
        String a="bcefwef";
//        char[] char1 = a.toCharArray();
//        for(char i : char1) {
//            System.out.println(i);
//        }
        System.out.println(a.substring(0,1));
    }
}
