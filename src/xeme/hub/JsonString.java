package xeme.hub;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.stream.JsonWriter;
import com.xeme.Main;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

final class JsonString implements JsonRepresentedObject, ConfigurationSerializable {

	private String _value;

	public JsonString(CharSequence value) {
		_value = value == null ? null : value.toString();
	}

	@Override
	public void writeJson(JsonWriter writer) throws IOException {
		writer.value(getValue());
	}

	public String getValue() {
		return _value;
	}

	public Map<String, Object> serialize() {
		HashMap<String, Object> theSingleValue = new HashMap<String, Object>();
		theSingleValue.put("stringValue", _value);
		return theSingleValue;
	}

	public static JsonString deserialize(Map<String, Object> map) {
		return new JsonString(map.get("stringValue").toString());
	}

	@Override
	public String toString() {
		return _value;
	}

	@Override
	public void writeJson(Main writer) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
