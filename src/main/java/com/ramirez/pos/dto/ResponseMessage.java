package com.ramirez.pos.dto;

public class ResponseMessage {

	private String field;

	private String message;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(String message) {
		super();
		this.message = message;
	}

	public ResponseMessage(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
