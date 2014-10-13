package com.fr.station.component.report.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownLoad extends ActionSupport {

	private String fileName;

	private int fileLength;

	public void setFileName(String start) {
		this.fileName = start;
	}

	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	public String getFileName() {
		return this.fileName;
	}

	public int getFileLength() {
		return this.fileLength;
	}

	public InputStream getInputStream() {

		String content = "Hahahahaha : " + this.fileName;

		this.setFileLength(content.getBytes().length);
		System.out.println("The File Size : " + content.getBytes().length);
		return new ByteArrayInputStream(content.getBytes());
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
