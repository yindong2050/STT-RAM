package com.java.model;

public class TotalCellTransition extends CellTransition {
	
	private int total_line;
	
	private int ZT_line;
	
	private int TT_line;
	
	public int getTotal_line() {
		return total_line;
	}
	public void setTotal_line(int total_line) {
		this.total_line = total_line;
	}
	public int getZT_line() {
		return ZT_line;
	}
	public void setZT_line(int zT_line) {
		ZT_line = zT_line;
	}
	public int getTT_line() {
		return TT_line;
	}
	public void setTT_line(int tT_line) {
		TT_line = tT_line;
	}
}
