import java.net.*;  
import java.io.*;  
  
public class Server {  
    public static void main(String[] args) throws IOException {  
        int port = 12345;  
        ServerSocket serverSocket = new ServerSocket(port);  
        System.out.println("Server started on port " + port);  
  
        while (true) {  
            Socket clientSocket = serverSocket.accept();  
            System.out.println("Client connected from " + clientSocket.getInetAddress());  
  
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  
  
            String inputLine;  
            while ((inputLine = in.readLine()) != null) {  
                System.out.println("Received message: " + inputLine);  
                out.println("Echo: " + inputLine);  
            }  
  
            out.close();  
            in.close();  
            clientSocket.close();  
        }  
    }  
}
