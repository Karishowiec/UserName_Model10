package homework;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();

        List<String> numbers = phoneNumber.readFile();

        phoneNumber.validPhoneNumber(numbers);

        WorkUser workUser = new WorkUser();


        List<String> users = workUser.readFile();
        users.remove(0);
        System.out.println(users);
        List<User> userList = workUser.createUsers(users);

        String json = workUser.toJson(userList);
        workUser.writeJson(json);

        WordCount wordCount = new WordCount();
        List<String> strings = wordCount.readFile();
        System.out.println(strings);

        Map<String, Integer> stringIntegerMap = wordCount.countWord(strings);
        System.out.println(stringIntegerMap.toString());


    }

}
