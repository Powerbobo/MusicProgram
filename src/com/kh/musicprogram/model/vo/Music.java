package com.kh.musicprogram.model.vo;

public class Music {
	// 필드
	private String title;
	private String singer;
	
	
	// 생성자, getter/setter, toString(), ... 자동완성 가능함!
	// alt + Shift + s => 단축키 혹은 우클릭
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 매개변수 생성자
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	
	// getter/setter 메소드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}

	// toString 오버라이드
	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
}
