package com.ryz.cn.entity;

public class Menu {
	private Long id;
	private int index;
	private String name;
	private String url;
	private Long parentId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", index=" + index + ", name=" + name + ", url=" + url + ", parentId=" + parentId
				+ "]";
	}
	
	
}
