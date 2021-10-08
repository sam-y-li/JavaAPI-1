import Utiils.APIEndpoints;
import Utiils.Base;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test extends Base {

    @Test
    public void createUser() {
        String endpoint = APIEndpoints.createUser.getResource();

        JSONObject userJson = new JSONObject();
        userJson.put("firstname", "Demo");
        userJson.put("lastname", "John");
        userJson.put("email", "demo@test.com");
        List<String> roles = new ArrayList<>();
        roles.add("normal user");
        userJson.put("roles", roles);

        JSONObject payload = new JSONObject();
        payload.put("user", userJson);

        Response response = post(endpoint, payload);

        System.out.println(response);

        int statusCode = response.getStatusCode();
        String body = response.getBody();



    }

    @Test
    public void deleteUser(Int id){
        String endpoint = APIEndpoints.deleteUser.getResource();

        int id;
        endpoint = endpoint.replace("{id}",id);

        Response response = delete(endpoint);
        int statusCode = response.getStatusCode();

        if (!statusCode == 204) {
            System.out.println("Error - Delete returned status code: " + statusCode);
            Assert.fail();
        }
    }

    @Test
    public void searchVulnerabilities(){
        String endpoint = APIEndpoints.searchVulnerabilities.getResource();

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("connector_names[]","Generic");
        queryParams.put("predicted_exploitable[]","true");
        queryParams.put("popular_target[]","true");

        Response response = get(APIEndpoints.searchVulnerabilities.getResource(), queryParams);

        if (!statusCode == 200) {
            System.out.println("Error - Get returned status code: " + statusCode);
            Assert.fail();
        }

    }
}
