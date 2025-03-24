package com.task.expedia.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Offers {

	@JsonProperty("package")
	private List<Object> _package;

	public List<Object> getPackage() {
		return _package;
	}

	public void setPackage(List<Object> _package) {
		this._package = _package;
	}

	@Override
	public String toString() {
		return "Offers {" +
				"package=" + _package +
				'}';
	}
}
