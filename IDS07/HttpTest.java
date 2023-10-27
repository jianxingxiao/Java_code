import java.net.HttpURLConnection;  
import java.net.URL;  
import java.io.BufferedReader;  
import java.io.InputStreamReader;  
  
public class HttpTest {  
    public static void main(String[] args) throws Exception {  
        String url = "http://example.com";  
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();  
        conn.setRequestMethod("GET");  
        conn.setDoOutput(true);  
  
        int responseCode = conn.getResponseCode();  
        System.out.println("Response Code: " + responseCode);  
  
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
        String line;  
        while ((line = reader.readLine()) != null) {  
            System.out.println(line);  
        }  
        reader.close();  
    }  
}
