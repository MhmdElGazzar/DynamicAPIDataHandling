import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import static org.unitils.reflectionassert.ReflectionAssert.*;


import static io.restassured.RestAssured.given;

public class APIResponseDemo {
    public static LocationBody getTestData() {
        LocationBody expectedresponse= new LocationBody();
        expectedresponse.country="United States";
        expectedresponse.postCode="90210";
        expectedresponse.countryAbbreviation="US";
        LocationBody.Place place= new LocationBody.Place();
        place.placeName= "Beverly Hills";
        place.longitude="-118.4065";
        place.state="California";
        place.stateAbbreviation="CA";
        place.latitude= "34.0901";
        expectedresponse.places.add(place);
        return expectedresponse;
    }

    @Test
    public void try1()
    {LocationBody expectedresponse= getTestData();
       Response response =  given().when().get("http://api.zippopotam.us/us/90210");
       response.prettyPrint();
        JsonPath jsnPath = response.jsonPath();
        Assert.assertEquals(expectedresponse.places.get(0).longitude, jsnPath.get("places[0].longitude"));
    }
//    @Test
//    public void try2()
//    {
//        Response response =  given().when().get("http://api.zippopotam.us/us/90210");
//        Gson gson = new Gson();
//        String jsonString = response.getBody().asString();
//        LocationBody loc= gson.fromJson(jsonString, LocationBody.class);
//        System.out.println(loc);
//    }
    @Test
    public void try2()
    {   //create the pojo
        //call the as method
        LocationBody expectedresponse= getTestData();
        LocationBody location =  given().when().get("http://api.zippopotam.us/us/90210").as(LocationBody.class);
        System.out.println(location.country);
        Assert.assertEquals(expectedresponse,location);
        Assert.assertEquals(expectedresponse.countryAbbreviation,location.countryAbbreviation);
        Assert.assertEquals(expectedresponse.postCode,location.postCode);
        Assert.assertEquals(expectedresponse.places.get(0).latitude,location.places.get(0).latitude);
//
    }
    @Test
    public void try3()
    {  LocationBody expectedresponse= getTestData();
        LocationBody location =  given().when().get("http://api.zippopotam.us/us/90210").as(LocationBody.class);
        System.out.println(location.country);
        assertReflectionEquals(location,expectedresponse);
    }
}
