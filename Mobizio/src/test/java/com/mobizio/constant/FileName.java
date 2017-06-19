package com.mobizio.constant;

public class FileName {
	
	public enum FileNames {
		TestDataRelativePath("src/test/resources/testdata/"),
		UserProperties("User"),
		CustomerProperties("Customer"),
		DeviceProperties("Device"),
		BranchProperties("Branch"),
		TaskProperties("Task"),
		FormProperties("Form"),
		RoleProperties("Role"),
		TaskTypeProperties("TaskType"),
		SectionProperties("Section"),
		ServiceProperties("Service"),
		GroupProperties("Group");

		private String value;
		private FileNames(String value) {
			this.value = value;
		}
		
		public String toString() {
			return value;
		}
	}

}
