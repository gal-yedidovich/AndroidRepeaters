import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class Tester {
	public static void main(String[] args) {
		try {
			//Ex 1
			JSONObject gal = new JSONObject();
			gal.put("name", "Gal");
			gal.put("age", 24);
			gal.put("isMarried", false);

			//Ex2
			JSONObject carJson = new JSONObject().put("owner", gal).put("model", "kia picanto").put("year", 2017).put("hasMobileye", true);

			//Ex3 - iterate over json
			Iterator<String> keys = carJson.keys();
			while (keys.hasNext()) {
				String key = keys.next();
				System.out.println(key + " - " + carJson.get(key)); //print each key - value
				System.out.println();
			}

			//Ex 4 - Iterate over JsonArray
			JSONObject androidRepeaters = new JSONObject();
			JSONArray students = new JSONArray().put("Oron").put("Gila").put("Ben").put("Daniel").put("Matityahu");
			androidRepeaters.put("students", students);
			System.out.println(androidRepeaters);
			for (int i = 0; i < students.length(); i++) {
				System.out.println(students.get(i));
			}

			//Ex 5 - reading Json file
			String jsonStr = new String(Files.readAllBytes(Paths.get("files/CakeRecipe.json")));
			JSONObject cakeRecipe = new JSONObject(jsonStr);
			System.out.println(cakeRecipe);


			//Ex 6 - reading form remote server
			String url1 = "http://192.168.252.251/items.json"; //our little XAMPP server
			JSONObject res = new HttpRequest(url1).prepare().sendAndReadJSON();

			//read names
			JSONArray hits = res.getJSONArray("hits");
			for (int i = 0; i < hits.length(); i++) {
				JSONObject info = hits.getJSONObject(i).getJSONObject("_source").getJSONObject("info");
				String name = info.optString("fullName","No Name found");
				System.out.println(name);
			}


		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}
}
