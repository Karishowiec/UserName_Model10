package homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    public void validPhoneNumber(List<String> phoneNumbers) {
        for (String number : phoneNumbers) {
            if (validPhoneNumber(number)) {
                System.out.println(number);
            }
        }

    }

    private boolean validPhoneNumber(String phoneNumberClient) {
        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumberClient);
        return matcher.matches();
    }

    public List<String> readFile() {
        try {
            return Files.readAllLines(Paths.get("files/numbers.txt"));
        } catch (IOException e) {
            System.out.println("File cannot read");
        }
        return new ArrayList<>();
    }

}

