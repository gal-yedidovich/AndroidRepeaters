import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Tester {
	public static void main(String[] args) throws IOException {
		//instantiating server
		HttpServer server = HttpServer.create(new InetSocketAddress("10.0.29.49",8080), 0);

		server.createContext("/", new IndexHandler());
		server.createContext("/signIn", new SignInHandler());

		//starting server
		server.start();


		//Client
		String response = new HttpRequest("http://localhost:80/signIn")
				.prepare(HttpRequest.Method.POST)
				.withData("Groot")
				.sendAndReadString();

		System.out.println(response);
	}
}
