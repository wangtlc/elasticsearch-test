package com.索引创建;

import lombok.Data;

@Data
public class Blog {
	private Integer id;
	private String title;
	private String posttime;
	private String content;

	public Blog() {
	}

	public Blog(Integer id, String title, String posttime, String content) {
		this.id = id;
		this.title = title;
		this.posttime = posttime;
		this.content = content;
	}
	// setter and getter

}