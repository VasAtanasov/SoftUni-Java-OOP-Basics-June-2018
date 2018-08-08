package L12InterfacesExercise.Ex04Telephony;

import java.util.List;

public interface SmartPhone {
    void call(List<String> numbers);

    void browse(List<String> sites);
}
