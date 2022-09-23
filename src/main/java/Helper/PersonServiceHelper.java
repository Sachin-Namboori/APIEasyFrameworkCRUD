package Helper;

import Utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;
import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.PersonPOJO;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.List;

public class PersonServiceHelper {
    //fetch the data from endpoints get post put patch delete

    private static final String BASE_URI = ConfigManager.getInstance().getString("baseURI");
    private static final String PORT = ConfigManager.getInstance().getString("port");


    public PersonServiceHelper(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

public List<PersonPOJO> getAllPerson(){
    Response response = RestAssured.given().log().all().
            contentType(ContentType.JSON).
            get(EndPoints.get_All_Person).andReturn();

    Type type = new TypeReference<List<PersonPOJO>>(){}.getType();
    List<PersonPOJO> personPOJOList = response.as(type);
    return personPOJOList;
    }

    public Response createPerson(){
        PersonPOJO person = new PersonPOJO();
        person.setId(4);
        person.setFirstName("Sidharth");
        person.setLastName("Namboori");
        person.setAddress("Dream Land, Ireland ");
        person.setPhoneNumbers("12345678910");

        Response  response = RestAssured.given().
                contentType(ContentType.JSON).when().
                body(person).post(EndPoints.create_Person).andReturn();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,"Created");
        return response;
    }

    public Response updatePerson(int id){
        PersonPOJO person = new PersonPOJO();
        person.setAge(5);
        person.setPhoneNumbers("123454321");
        person.setFirstName("Siddharth");
        person.setLastName("Namboora");
        person.setAddress("DreamLand, Ireland");
        Response response = RestAssured.given().contentType(ContentType.JSON).
                pathParam("id",id).when().body(person).
                patch(EndPoints.update_Person).andReturn();

        Assert.assertTrue((response.getStatusCode()==HttpStatus.SC_OK));

        return response;
    }

    public Response deletePerson(int id){
        Response response = RestAssured.given().
                contentType(ContentType.JSON).
                pathParam("id",id).log().all().
                when().delete(EndPoints.get_Single_Person).andReturn();
        Assert.assertTrue((response.getStatusCode()== HttpStatus.SC_OK));
    return response;
    }
}
