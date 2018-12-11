package CheckIdCard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateId {

    public ValidateId() {};

    public Matcher getNum(String str1) {
        String pattern = "^(\\d{17})(\\d|X|x)?$";
        Matcher matcher = Pattern.compile(pattern).matcher(str1);
        return matcher;
    }
}
