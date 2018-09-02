import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

public class SignInHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange request) throws IOException {
		if (request.getRequestMethod().equals("POST")) {
			//read
			InputStream is = request.getRequestBody(); //get input stream from client
			int b;
			StringBuilder sb = new StringBuilder(); //string builder to hold the final result (string)
			while ((b = is.read()) != -1) {
				sb.append((char) b);
			}
			System.out.println(sb.toString()); //print the message from client

			//write
			String resMsg = "Hello " + sb.toString();
			byte[] data = resMsg.getBytes();

			request.sendResponseHeaders(200, data.length);
			request.getResponseBody().write(data);
		} else {
			request.sendResponseHeaders(405, 0);
		}
		request.close();
	}
}
