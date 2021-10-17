package com.ryde.sg.model;

public class RequestModal<T> {
	
	

	private T requestObj;
	
	public RequestModal() {
	
	}
	
	public RequestModal(T requestObj) {
		this.requestObj = requestObj;
	}

	public T getRequestObj() {
		return requestObj;
	}
	
	@Override
	public String toString() {
		return "RequestModal [requestObj=" + requestObj + "]";
	}


}
