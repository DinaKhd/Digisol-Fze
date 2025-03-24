package com.task.expedia.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class AbInfo {

	private String displayDestinationAlternativeIsAvailable;

	public String getDisplayDestinationAlternativeIsAvailable() {
		return displayDestinationAlternativeIsAvailable;
	}

	public void setDisplayDestinationAlternativeIsAvailable(String displayDestinationAlternativeIsAvailable) {
		this.displayDestinationAlternativeIsAvailable = displayDestinationAlternativeIsAvailable;
	}

	@Override
	public String toString() {
		return "AbInfo{" +
				"displayDestinationAlternativeIsAvailable='" + displayDestinationAlternativeIsAvailable + '\'' +
				'}';
	}
}
