package com.java.util;

import com.java.model.CellTransition;

public class CommonUtil {
	
	/*If the entered number is an odd number, change it to an even number
	 * @param number  The number of the codes
	 * @return The number of final codes
	 * */
	public int getResultNumber(int number) {
		
		if(number % 2 == 1){
			
			number=number*2;
		}
		
		return number;
	}
	
	
	/*Convert binary string collection to character array*/
	public String[] binaryStringToArray(String binaryString){
		
		String [] restultArray=binaryString.split(",");
		
		return restultArray;
	}

	
	/*Get the number of TT
	 * @param transitionString  the original string.
	 * @param binaryString    the string need to transition.
	 * @return cellTransition.
	 * */
	public CellTransition BinaryTransition(String transitionString, String binaryString) {
		
		CellTransition  cellTransition = new CellTransition();
		
		BinaryUtil binaryUtil = new BinaryUtil();
		
		if(transitionString.length() == binaryString.length()){
			
			int strLength=binaryString.length();
			
				int k = 0;
				
				while(k < strLength){
					
					String beginStr = transitionString.substring(k, k + 2);
					
					String endStr = binaryString.substring(k, k + 2);
					
					binaryUtil.SubBinaryTransition(beginStr, endStr, cellTransition);
					
					k = k + 2;	
			}
			
		}
		else{
			
			System.out.println("The characters entered are incorrect!");
		}
					
		return cellTransition;
	}

}
