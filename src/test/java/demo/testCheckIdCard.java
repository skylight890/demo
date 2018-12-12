package demo;

import java.util.ArrayList;

public class testCheckIdCard {

    public static void main(String[] args) {
        ValidateId a = new ValidateId();
        String[] card = {"1234abc2320830198917050034fww32083019891705003x32083019890705005x", "1234abc2320830198907050034fww320830196008204029x32083019890705005x"};
        ArrayList<String> c = new ArrayList<String>();
        c = a.isIdCard(card);
        for(String i : c) {
            System.out.println(i);
        }
    }
}
