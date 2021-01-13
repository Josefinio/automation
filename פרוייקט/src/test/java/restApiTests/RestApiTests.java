package restApiTests;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RestApiTests {

    public static CloseableHttpClient httpClient;
    public static HttpGet httpGet;
    public static CloseableHttpResponse response;
    public static String responseJson;
    public static JSONObject jsonObject;
    public static HttpPost httpPost;
    public static HttpPatch httpPatch;
    //baseUrl = "https://jsonplaceholder.typicode.com/";

    public static void setUpGetRequest(String url) throws IOException {
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
    }

    public static void setUpPostRequest(String url,String postBody) throws IOException {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(postBody));
    }

    public static void setUpPatchRequest(String url,String fetchBody) throws UnsupportedEncodingException {
        httpClient = HttpClients.createDefault();
        httpPatch = new HttpPatch(url);
        httpPatch.setEntity(new StringEntity(fetchBody));
        httpPatch.addHeader("Content-Type", "application/json");

    }

    public static void getResponse(HttpRequestBase base) throws IOException {
        response = httpClient.execute(base);
        responseJson = EntityUtils.toString(response.getEntity());
        jsonObject = new JSONObject(responseJson);
    }

    @Test
    public void testSomeGetRequests() throws IOException {
        setUpGetRequest( "https://jsonplaceholder.typicode.com/posts/1");
        getResponse(httpGet);
        System.out.println(responseJson);
        Assert.assertTrue(response.getStatusLine().getStatusCode()==200);
        System.out.println(jsonObject.get("userId").toString());
        Assert.assertTrue(jsonObject.get("userId").equals(1));
        Assert.assertTrue(jsonObject.get("title").toString().contains("sunt aut"));
    }

    @Test
    public void testSomePostRequest() throws IOException {
        setUpPostRequest("https://jsonplaceholder.typicode.com/posts/","{\"id\":1,\n" +
                "     \"userId\":1,\n" +
                "    \"title\": \"sambalulu\",\n" +
                "    \"body\": \" architecto\"\n" +
                "}");
        getResponse(httpPost);
        System.out.println(jsonObject.toString());
        Assert.assertTrue(response.getStatusLine().getStatusCode()==201);
    }

    @Test
    public void testSomePatchRequest() throws IOException {
      setUpPatchRequest("https://jsonplaceholder.typicode.com/posts/1","{\n" +
              "    \"title\": \"sambalulu\",\n" +
              "    \"body\": \" architecto\"\n" +
              "}");
        getResponse(httpPatch);
        System.out.println(jsonObject.toString());
        Assert.assertTrue(jsonObject.get("title").toString()=="sambalulu");
    }
}
