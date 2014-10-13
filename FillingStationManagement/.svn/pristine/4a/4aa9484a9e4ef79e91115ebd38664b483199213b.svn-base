package com.fr.station.common.bean.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NodeBean implements Serializable {
	
	public NodeBean() {
		super();
	}

	public NodeBean(int upStep, int step, String text, String url, int open) {
		this.upStep = upStep;
		this.step = step;
		this.text = text;
		this.url = url;
		this.open = open;
		children = new ArrayList<NodeBean>();
	}

	private static final long serialVersionUID = 1L;

	private int upStep;

	private int step;

	private String text;

	private String url;

	private int open;

	private List<NodeBean> children;

	public int getUpStep() {
		return upStep;
	}

	public void setUpStep(int upStep) {
		this.upStep = upStep;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getText() {
		return text;
	}

	public void setText(String name) {
		this.text = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public List<NodeBean> getChildren() {
		return children;
	}

	public void setChildren(List<NodeBean> notes) {
		this.children = notes;
	}

	@Override
	public String toString() {
		return "NodeBean [upStep=" + upStep + ", step=" + step + ", text="
				+ text + ", url=" + url + ", open=" + open + ", children="
				+ children + "]";
	}

}
