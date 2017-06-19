package com.mobizio.constant;

public class GlobalConstants {
	
	public enum Constant
	{
		UserPage("Users"),
		TaskTypePage("Task Types"),
		NewTaskTypePage("New Task Type"),
		Customers("Customers"),
		NewCustomer("New Customer"),
		Subscriptions("Subscriptions"),
		Groups("Groups"),
		RolesPage("Roles"),
		NewServiceRolePage("New Service Role"),
		NewGroup("New Group"),
		NewUserPage("New User"),
		FieldTypePopUp("Select a Field Type"),
		BranchPage("Branches"),
		EditPassword("Edit Password");
		
		private String value;
		private Constant(String value)
		{
			this.value=value;
		}
		
		public String toString() {
			return value;
		}
	}

}
