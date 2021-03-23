import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servertest{

	public static void main(String[] args){

	System.out.println("Server is starting...");

	try{
		ServerSocket server = new ServerSocket(8080);
		Socket connection = server.accept();
		OutputStream response = connection.getOutputStream();

		
		String content = "<h1> This is a title heading on the page </h1>";

		String body  = "HTTP/1.1 200 OK" + "\r\n";
		body += "Content-Type: text/html" + "\r\n";
		body += "Content-Length: " + content.length() + "\r\n";
		body +=  "\r\n";
		body += content;

		response.write(body.getBytes("UTF-8"));
		response.flush();
		server.close();
	}
	catch( IOException ex){
		ex.printStackTrace();
	}

	}

}
