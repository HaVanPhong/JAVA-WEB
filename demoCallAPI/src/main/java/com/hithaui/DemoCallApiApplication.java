package com.hithaui;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.w3c.dom.ls.LSOutput;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@SpringBootApplication
public class DemoCallApiApplication {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		SpringApplication.run(DemoCallApiApplication.class, args);
//		final String URL="https://apincov.herokuapp.com/countries";
//		Response response=  Request.Get(URL).execute();
//		
//		String json=response.returnContent().toString();
//		
		
		//json-simple
//		System.out.println(contentResponse);
//		JSONArray jsonArray=(JSONArray) JSONValue.parse(json);
//		
//		List<Country> list=new LinkedList<Country>();
//		
//		for (int i=0; i<jsonArray.size();i++) {
//			JSONObject jsonObject =(JSONObject) jsonArray.get(i);
////			System.out.println(jsonObject.get("Recovered"));
//			Country country=new Country(jsonObject.get("Country_Region"), jsonObject.get("Confirmed"), jsonObject.get("Deaths"), jsonObject.get("Recovered"));
//			list.add(country);
//		}
//		list.forEach(System.out::println);
//		
		//moshi
//		Moshi moshi=new Moshi.Builder().build();
//		JsonAdapter<Country[]> jsonAdapter = moshi.adapter(Country[].class);
//		Country[] countries= jsonAdapter.fromJson(json);
//		for (Country country : countries) {
//			System.out.println(country);
//		}
		
		
		
		
	}

}
