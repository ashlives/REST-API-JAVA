
import groovy.json.JsonException;
import groovy.json.internal.JsonParserCharArray;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.io.InputStream;

/**
 * Created by Ashish on 08-07-2017.
 */
public class RestTest {

    @Test
    public void getRequestFindCapital() throws JsonException {

        given().when().get("http://www.google.com").then().statusCode(200);

        /*//make get request to fetch capital of norway
        Response resp = get("http://restcountries.eu/rest/v1/name/norway");

        //Fetching response in JSON
        JSONArray jsonResponse = new JSONArray(resp.asString());

        //Fetching value of capital parameter
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        //Asserting that capital of Norway is Oslo
        Assert.assertEquals(capital, "Oslo");*/
    }

    @Test
    public void getOffer(){
        given()
                .contentType(ContentType.JSON)
                .header("X-VIU-AUTH","eyJhbGciOiJBMTI4S1ciLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.zhN2xlAeYvYoTFNw1kxtslXbh6g5qEoNQ8GsFfeHlSGfW3uv0D_IwQ.hRlT48xDygnU5KEn8gZssw.EMMHCFEySJgk_BYBuVIiAtX1NpHnQly7WoVjFMY9D1-w1TsVWvfKB7jBe_8ViDSMkEeVoT30EVf4HP0rBBUIQmdXpswMfJsG7tyQbGsb0wMXIpZICE_mWEuZYFqwGc9UMI60h3DZo58-As1bCLptrd6WpqB185lkJt9-JbRFQdvg3m9nhUZ6sp_iI0ApI1Qs36-EjpiQRUW5QKuEj56NbKWFU9UQbR4fp5Ioh8z6mRwXojUvYDDzeVnk5Ri-1IkbY3UBqvG9ejgdpXykh2HSLg.49fl0qFUahHtZCFyKcylKQ")
                .when()
                .get("https://www.viu.com/api/users/v2/getoffer?appid=viu_desktop")
                .then()
                .statusCode(200)
                .body("id", equalTo("viutrial"))
                .body("partner", equalTo("Trial"));
    }
}
