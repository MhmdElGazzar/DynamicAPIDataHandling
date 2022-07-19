package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectToJsonDemo {


    public String color="yellow";
    public String type="renault";

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectToJsonDemo objectToJsonDemo = new ObjectToJsonDemo();
        objectMapper.writeValue(new File(".\\src\\main\\resources\\car.json"), objectToJsonDemo);
    }
}
