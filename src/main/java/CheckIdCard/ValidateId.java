package CheckIdCard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateId {

    //public ValidateId() {};

    public ArrayList<String> isIdCard(String[] args) {
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < args.length; i++) {
            Matcher m = getCardFromString(args[i]);
            while(m.find()) {
                ArrayList<String> list = getCard(m.group());
                for(String j : list) {
                    if(validate(j)) {
                        result.add(j);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 匹配18位身份证号
     *
     * @param str 待匹配字符串
     */
    public Matcher getCardFromString(String str) {
        String pattern = "(\\d{17,}x)|(\\d{18,})";
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        return matcher;
    }

    /*>=18位的分割成18位*/
    public ArrayList<String> getCard(String str) {
        int len = str.length();
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < len-17; i++){
            list.add(str.substring(i, i+17));
        }

        return list;
    }

    /**
     * 校验末尾值符合预期
     *
     * @param card 身份证号码
     */
    public Boolean checkLastNumber(String card) {
        int[] factors = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        char[] expects = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        int[] int_card = new int[17];
        int result = 0;

        char[] char_card = card.toCharArray();
        char lastnumber = card.substring(17).charAt(0);

        for(int i = 0; i < 17; i++) {
            int_card[i] = Integer.parseInt(char_card[i] + "");
        }
        for(int i = 0; i < 17; i++) {
            result += int_card[i] * factors[i];
        }

        return expects[result % 11] == lastnumber;
    }

    /**
     * 校验生日
     *
     * @param birthday 生日
     */
    public Boolean checkBirthday(String birthday) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if(date == null) {
                return false;
            }
        }

        return true;
    }

    public Boolean validate(String card) {
        String birthday = card.substring(6, 13);
        return checkLastNumber(card) && checkBirthday(birthday);
    }

    public ArrayList<String> getIdCardFromList(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<String>();

        for(String i : list) {
            if(validate(i)) {
                result.add(i);
            }
        }

        return result;
    }


}
