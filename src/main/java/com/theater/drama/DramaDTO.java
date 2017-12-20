package com.theater.drama;

public class DramaDTO {
	
	private int drama_num;
    private String title;
    private String contents;
    private String place;
    private int price;
    private int buy_hit;
    
	public int getDrama_num() {
		return drama_num;
	}
	public void setDrama_num(int drama_num) {
		this.drama_num = drama_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBuy_hit() {
		return buy_hit;
	}
	public void setBuy_hit(int buy_hit) {
		this.buy_hit = buy_hit;
	}
}
