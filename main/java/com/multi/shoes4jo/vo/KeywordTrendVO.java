package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

@Component("KeywordTrendVO")
public class KeywordTrendVO {
	private String period_sdata;
	private String keyword;
	private String gender;
	private int age;
	private int ratio_cnt;
	
	public KeywordTrendVO() {
	}
	
	public KeywordTrendVO(String period_sdata, String keyword, int ratio_cnt) {
		this.period_sdata = period_sdata;
		this.keyword = keyword;
		this.ratio_cnt = ratio_cnt;
	}
	
	public KeywordTrendVO(String period_sdata, String keyword, String gender, int ratio_cnt) {
		this.period_sdata = period_sdata;
		this.keyword = keyword;
		this.gender = gender;
		this.ratio_cnt = ratio_cnt;
	}
	
	public KeywordTrendVO(String period_sdata, String keyword, int age, int ratio_cnt) {
		this.period_sdata = period_sdata;
		this.keyword = keyword;
		this.age = age;
		this.ratio_cnt = ratio_cnt;
	}

	public String getPeriod_sdata() {
		return period_sdata;
	}

	public void setPeriod_sdata(String period_sdata) {
		this.period_sdata = period_sdata;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRatio_cnt() {
		return ratio_cnt;
	}

	public void setRatio_cnt(int ratio_cnt) {
		this.ratio_cnt = ratio_cnt;
	}
	
}