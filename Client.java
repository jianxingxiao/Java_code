import java.net.*;  
import java.io.*;  
  
public class Client {  
    public static void main(String[] args) throws IOException {  
        String host = "localhost";  
        int port = 12345;  
        Socket socket = new Socket(host, port);  
        System.out.println("Connected to server");  
  
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));  
  
        String userInput;  
        while ((userInput = stdIn.readLine()) != null) {  
            out.println(userInput);  
            System.out.println("Echo: " + in.readLine());  
        }  
  
        out.close();  
        in.close();  
        stdIn.close();  
        socket.close();  
    }  
}
