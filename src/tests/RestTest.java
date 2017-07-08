
/**
 * Created by Ashish on 08-07-2017.
 */
public class RestTest {

    @Test
    public void getRequestFindCapital() throws JSONException {

        //make get request to fetch capital of norway
        Response resp = get("http://restcountries.eu/rest/v1/name/norway");

        //Fetching response in JSON
        JSONArray jsonResponse = new JSONArray(resp.asString());

        //Fetching value of capital parameter
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        //Asserting that capital of Norway is Oslo
        Assert.assertEquals(capital, "Oslo");
    }
}
