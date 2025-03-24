package com.task.expedia.data;

public class ExpediaPackage {
	private String packageId;
	private String packageName;

	public ExpediaPackage(String packageId, String packageName) {
		this.packageId = packageId;
		this.packageName = packageName;
	}

	public String getPackageId() { return packageId; }
	public String getPackageName() { return packageName; }
}
