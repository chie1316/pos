package com.ramirez.pos;

import java.util.List;

import com.ramirez.pos.dto.ResponseMessage;
import com.ramirez.pos.enumerator.ResponseCode;

public class CustomException extends Exception {

	/**
	 * Custom POS Exception
	 */
	private static final long serialVersionUID = 789723477912284700L;

	private final ResponseCode responseCode;

	private final String title;

	private final transient List<ResponseMessage> responseMessages;

	public CustomException(ResponseCode responseCode, String title, List<ResponseMessage> responseMessages) {
		super();
		this.responseCode = responseCode;
		this.title = title;
		this.responseMessages = responseMessages;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public String getTitle() {
		return title;
	}

	public List<ResponseMessage> getResponseMessages() {
		return responseMessages;
	}

}
