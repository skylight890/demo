package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateId {

    /**
     * (string)数组包含的身份证号
     *
     */
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
     * 匹配18位以上或者x结尾的
     *
     * @param str 待匹配字符串
     */
    private Matcher getCardFromString(String str) {
        String pattern = "(\\d{17,}(x|X))|(\\d{18,})";
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        return matcher;
    }

    /**
     * >=18位的分割成18位
     *
     * @param str 正则匹配后>=18位的字符串
     */
    private ArrayList<String> getCard(String str) {
        int len = str.length();
        ArrayList<String> list = new ArrayList<String>();

        for(int i = 0; i < len-17; i++) {
            list.add(str.substring(i, i+18));
        }

        return list;
    }

    /**
     * 校验18位字符是否身份证
     *
     * @param card 身份证号码
     */
    private Boolean validate(String card) {
        String birthday = card.substring(6, 13);
        return checkLastNumber(card) && checkBirthday(birthday);
    }


    /**
     * 校验末尾值符合预期
     *
     * @param card 身份证号码
     */
    private Boolean checkLastNumber(String card) {
        int[] factors = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        char[] expects = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        int[] int_card = new int[17];
        int result = 0;

        char[] char_card = card.toCharArray();
        char lastnumber = card.charAt(17);

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
     * @param birthday string日期yyyyMMdd格式
     */
    private Boolean checkBirthday(String birthday) {
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


}
