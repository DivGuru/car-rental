package com.lease.customer.controller;

public class CustomerError {

	private String message;
	private int status;
	private String timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public CustomerError() {
		
	}
	public CustomerError(String message, int status, String timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + ", timestamp=" + timestamp + "]";
	}
	
}
