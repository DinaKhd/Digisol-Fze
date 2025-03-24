package com.task.expedia.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class DebugInfo {

	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "DebugInfo{" +
				"requestId='" + requestId + '\'' +
				'}';
	}
}
