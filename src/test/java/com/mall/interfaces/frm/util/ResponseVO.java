package com.mall.interfaces.frm.util;

import java.util.List;

/**
 * jackson 테스트용 클래스
 * 
 * @since 2020-01-17
 * @author fixalot@lotte.net
 */
public class ResponseVO {
	private String returnCode;
	private String message;
	private String subMessages;
	private Long dataCount;
	private List<Object> data;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubMessages() {
		return subMessages;
	}

	public void setSubMessages(String subMessages) {
		this.subMessages = subMessages;
	}

	public Long getDataCount() {
		return dataCount;
	}

	public void setDataCount(Long dataCount) {
		this.dataCount = dataCount;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVO [returnCode=" + returnCode + ", message=" + message + ", subMessages=" + subMessages + ", dataCount=" + dataCount + ", data=" + data + "]";
	}
}