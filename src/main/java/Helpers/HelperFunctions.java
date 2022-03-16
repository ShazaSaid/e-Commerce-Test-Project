package Helpers;

import Models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HelperFunctions {
    public static void writeObjectToJsonFile(User user) {
        JSONObject userObject = new JSONObject();
        userObject.put("email", user.getEmail());
        userObject.put("password", user.getPassword());
        try {
            // Writing to a file
            File file = new File("JsonFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");
            System.out.print(userObject);

            fileWriter.write(userObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User readUserDetailsFromJsonFile() {
//JSON parser object to parse read file
        User readUser = new User();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("JsonFile.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject user = (JSONObject) obj;
            System.out.println(user);

            readUser.setEmail((String) user.get("email"));
            readUser.setPassword((String) user.get("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return readUser;
    }
}
