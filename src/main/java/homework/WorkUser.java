package homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WorkUser {
    public List<String> readFile() {
        try {
            return Files.readAllLines(Paths.get("files/names.txt"));
        } catch (IOException e) {
            System.out.println("File cannot read");
        }
        return new ArrayList<>();
    }
    public List<User> createUsers(List<String>users) {
        List<User> result = new ArrayList<>();
        for (String user: users){
            String[] strings = user.split(" ");
            int age = Integer.parseInt(strings[1]);

            User newUser = new User(strings[0], age);
            result.add(newUser);
        }
        return result;
    }
    public String toJson(List<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println(json);
        return json;

    }
    public void writeJson(String json) {
        try {
            Files.write(Paths.get("files/users.json"), json.getBytes());
        } catch (IOException e) {
            System.out.println("Cannot write file");
        }
    }
}

