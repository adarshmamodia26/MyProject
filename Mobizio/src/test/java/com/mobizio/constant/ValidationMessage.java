package com.mobizio.constant;

public class ValidationMessage {
	
	public enum Validation
	{
		LoginFailedMessage("Login Failed! Invalid username or password!");
		
		private String value;
		private Validation(String value)
		{
			this.value=value;
		}
		
		public String toString() {
			return value;
		}
	}
}