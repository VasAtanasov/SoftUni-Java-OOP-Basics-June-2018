package L12InterfacesExercise.Ex04Telephony;

import java.util.List;

public class SmartPhoneImpl implements SmartPhone {


    @Override
    public void call(List<String> numbers) {
        for (String number : numbers) {
            if (number.matches("[0-9]*")) {
                System.out.println(String.format("Calling... %s", number));
            } else {
                System.out.println("Invalid number!");
            }
        }
    }

    @Override
    public void browse(List<String> sites) {
        for (String site : sites) {
            if (site.matches("[^0-9]*")) {
                System.out.println(String.format("Browsing: %s!", site));
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }
}
