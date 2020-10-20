package lfzh.model;

import java.util.Date;

public class Branch {
	private int id;
	private String name;
	private String short_name;
	private Date come_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public Date getCome_time() {
		return come_time;
	}

	public void setCome_time(Date come_time) {
		this.come_time = come_time;
	}

}
