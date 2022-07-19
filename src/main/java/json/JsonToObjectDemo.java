package json;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.FileReader;
import java.io.IOException;

public class JsonToObjectDemo {
    public String color;
    public String type;

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader(".\\src\\main\\resources\\car.json");
        JsonToObjectDemo objectToJsonDemo = objectMapper.readValue(reader, JsonToObjectDemo.class);
        System.out.println(objectToJsonDemo.color);
    }
}
