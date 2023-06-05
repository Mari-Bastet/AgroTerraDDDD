package pkg.fiap.agroterra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStreamWriter;

public class ChatGPT {

    public static void GPTResponde(String message) {
	        String url = "https://api.openai.com/v1/chat/completions";
	        String apiKey = "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";
	        String model = "gpt-3.5-turbo";
	        
	        try {
	            URL obj = new URL(url);
	            

	            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	            
	            con.setRequestMethod("POST");
	            con.setRequestProperty("Authorization", "Bearer " + apiKey);
	            con.setRequestProperty("Content-Type", "application/json");

	            // Build the request body
	            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
	            con.setDoOutput(true);
	            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
	            writer.write(body);
	            writer.flush();
	            writer.close();

	            // Get the response
	            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();

	            //System.out.println(response);
	            System.out.println((response.toString().split("\"content\":\"")[1].split("\"")[0]).substring(0));
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }

	    }
    }

