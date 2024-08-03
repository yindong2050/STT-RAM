package com.java.util;

import com.java.model.CellTransition;

public class BinaryUtil {

	/*Given a number, output all its binary codes. For example, given the number 2, output 00, 01, 10, 11 separated by ','.
	 * @param num  The number of the code.
	 * @return All of the binary codes from 0 to Math.pow(2, num).
	 * */
	public String totalBinaryFromGivenInt(int num){
		
		String resultBinary="";
		
		if(num < 2 || num > 8)
		{
			
			System.out.println("The number you entered does not conform to the specification");
		}else
		{
			
			for(int i=0;i<Math.pow(2, num);i++)
			{
				
				resultBinary = resultBinary + binaryFromGivenInt(i,num)+",";
				
			}
			
		}
		
		    resultBinary=resultBinary.substring(0, resultBinary.length()-1);
		
			return resultBinary;
	}
	
	/*Given a number, the output is its binary code, such as 5, and output is 101.
	 * @param k The number to be converted.
	 * @param num  The number of the code.
	 * @return The binary code of  k.
	 * */
	public String binaryFromGivenInt(int k,int num){
		
		String result = "";
		
		for(int i = k; i > 0; i/=2){
			
			result = i % 2 + result;
		}
		
		result = formatFromBinary(result,num);
		
		return result;		
	}
	
	/*Fill up the number of binary digits, such as 3 digits, but the calculation is 2 digits, you need to fill in 0 in front, such as 011.
	 * @param s The original binary string.
	 * @param num  The number of the code.
	 * @return A binary string with the leading symbol 0.
	 * */
	public String formatFromBinary(String s,int num){
		
		int n=num-s.length();

		if(n>0){
			
			for(int i=0;i<n;i++){
				
				s="0"+s;
			}
		}
		return s;
	}
	
	/*Get the number of 4 conversions
	 * @param beginStr  the original cell.
	 * @param endStr     the cell needs to transition.
	 * @return cellTransition.
	 * */
	public CellTransition SubBinaryTransition(String beginStr, String endStr, CellTransition cellTransition) {
		
		if((beginStr.equals("00")&&endStr.equals("00"))||(beginStr.equals("01")&&endStr.equals("01"))||(beginStr.equals("10")&&endStr.equals("10"))||(beginStr.equals("11")&&endStr.equals("11")))
		{
			
			cellTransition.setZT(cellTransition.getZT()+1);

		}
		else if((beginStr.equals("00")&&endStr.equals("01"))||(beginStr.equals("01")&&endStr.equals("00"))||(beginStr.equals("10")&&endStr.equals("11"))||(beginStr.equals("11")&&endStr.equals("10"))){
			
			cellTransition.setST(cellTransition.getST()+1);
		}
		
		else if((beginStr.equals("00")&&endStr.equals("11"))||(beginStr.equals("01")&&endStr.equals("11"))||(beginStr.equals("10")&&endStr.equals("00"))||(beginStr.equals("11")&&endStr.equals("00"))){
			
			cellTransition.setHT(cellTransition.getHT()+1);
			
		}
		
		else if((beginStr.equals("00")&&endStr.equals("10"))||(beginStr.equals("01")&&endStr.equals("10"))||(beginStr.equals("10")&&endStr.equals("01"))||(beginStr.equals("11")&&endStr.equals("01")))
		{
			
			cellTransition.setTT(cellTransition.getTT()+1);
		}
		
		return cellTransition;
		}
}
