package com.mobizio.constant;

public class GlobalConstant {
	
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
		TaskTypePage("Task Types"),
		NewTaskTypePage("New Task Type"),
		Customers("Customers"),
		NewCustomer("New Customer"),
		Subscriptions("Subscriptions"),
		Groups("Groups"),
		NewGroup("New Group"),
		NewUser("New User"),
		FieldTypePopUp("Select a Field Type"),
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
