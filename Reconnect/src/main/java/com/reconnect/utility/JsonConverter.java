package com.reconnect.utility;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.reconnect.model.Contact;

public class JsonConverter {

	private static Gson gson;

	public JsonConverter() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();
	}

	public String convertListToJson(List<Contact> list) {
		JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("Contactlist", jarray);
		return jsonObject.toString();
	}

	public String convertObjToJson(Contact contact1) {
		return gson.toJson(contact1);
	}
}
