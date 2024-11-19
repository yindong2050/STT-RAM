package com.java.model;

public class OriginalData {
	
	private String firstLineTag;
	
	private String secondLineTag;
	
	private String thirdLineTag;
	
	private int TagNumber;
	
	public OriginalData(int i) {
		
		TagNumber = i;
	}
	
	public OriginalData() {
			
	}
	
	public String getFirstLineTag() {
		return firstLineTag;
	}
	public void setFirstLineTag(String firstLineTag) {
		this.firstLineTag = firstLineTag;
	}
	public String getSecondLineTag() {
		return secondLineTag;
	}
	public void setSecondLineTag(String secondLineTag) {
		this.secondLineTag = secondLineTag;
	}
	public String getThirdLineTag() {
		return thirdLineTag;
	}
	public void setThirdLineTag(String thirdLineTag) {
		this.thirdLineTag = thirdLineTag;
	}
	public int getTagNumber() {
		return TagNumber;
	}
	public void setTagNumber(int tagNumber) {
		TagNumber = tagNumber;
	}
	
	
}
