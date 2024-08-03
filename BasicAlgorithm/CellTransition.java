package com.java.model;

/**
 * this is the basic class, it contains four params: ZT, ST, HT, TT. 
 * @param ZT, the number of ZT
 * @param ST, the number of ST
 * @param HT, the number of HT
 * @param TT, the number of TT
 */
public class CellTransition {
	
	private long ZT;
	private long ST;
	private long HT;
	private long TT;
	
	public long getZT() {
		return ZT;
	}
	public void setZT(long zT) {
		ZT = zT;
	}
	public long getST() {
		return ST;
	}
	public void setST(long sT) {
		ST = sT;
	}
	public long getHT() {
		return HT;
	}
	public void setHT(long hT) {
		HT = hT;
	}
	public long getTT() {
		return TT;
	}
	public void setTT(long tT) {
		TT = tT;
	}
}
