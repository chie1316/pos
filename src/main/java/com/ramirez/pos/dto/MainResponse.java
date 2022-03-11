package com.ramirez.pos.dto;

import java.util.ArrayList;
import java.util.List;

import com.ramirez.pos.enumerator.ResponseCode;
import com.ramirez.pos.enumerator.ResponseTitle;

public class MainResponse<T> {

	private int code;

	private String title;

	private List<ResponseMessage> responseMessages;

	private T data;

	public MainResponse(ResponseCode responseCode, ResponseTitle responseTitle, List<ResponseMessage> responseMessages,
			T data) {
		super();
		this.code = responseCodeConverter(responseCode);
		this.title = responseTitleConverter(responseTitle);
		this.responseMessages = responseMessages;
		this.data = data;
	}

	public MainResponse(ResponseCode responseCode, ResponseTitle responseTitle, String message, T data) {
		super();
		this.code = responseCodeConverter(responseCode);
		this.title = responseTitleConverter(responseTitle);
		this.responseMessages = responseMessageConverter(message);
		this.data = data;
	}

	public MainResponse() {
		super();
	}

	private int responseCodeConverter(ResponseCode responseCode) {

		int resCode = 0;
		switch (responseCode) {
		case SUCCESS:
			resCode = 200;
			break;

		case FAILED:
			resCode = 400;
			break;

		case INVALID_INPUT:
			resCode = 401;
			break;

		case ERROR:
			resCode = 500;
			break;

		default:
			resCode = 0;
			break;
		}
		return resCode;
	}

	private String responseTitleConverter(ResponseTitle responseTitle) {
		return responseTitle.toString().replace("_", " ");
	}

	private List<ResponseMessage> responseMessageConverter(String message) {
		List<ResponseMessage> responseMessageList = new ArrayList<>();
		ResponseMessage responseMessage = new ResponseMessage(message);
		responseMessageList.add(responseMessage);
		return responseMessageList;
	}

	public int getCode() {
		return code;
	}

	public void setCode(ResponseCode responseCode) {
		this.code = responseCodeConverter(responseCode);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ResponseMessage> getResponseMessages() {
		return responseMessages;
	}

	public void setResponseMessages(List<ResponseMessage> responseMessages) {
		this.responseMessages = responseMessages;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
