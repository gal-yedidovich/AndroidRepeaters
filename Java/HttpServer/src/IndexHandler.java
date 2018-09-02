import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class IndexHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange request) throws IOException {
		String msg = "Bubu is the king"; //response message
		byte[] data = msg.getBytes(); //response message in bytes (raw data)

		//send status code (200) & Content-length (data.length)
		request.sendResponseHeaders(200, data.length);

		//send response data/body
		OutputStream os = request.getResponseBody();
		os.write(data);

		request.close();
	}
}
