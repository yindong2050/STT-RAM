package com.java.handle;


import com.java.util.BinaryUtil;
import com.java.util.CombinationUtil;
import com.java.util.CommonUtil;

public class TTMappingHandle {
	/*The advanced algorithm*/
	public void advancedCombinationFindMapping(int number) {
		
		BinaryUtil binaryUtil = new BinaryUtil();
		
		CommonUtil commonUtil = new CommonUtil();
		
		CombinationUtil combinationUtil=new CombinationUtil();
		
		number = commonUtil.getResultNumber(number);
		
		String str = binaryUtil.totalBinaryFromGivenInt(number);
		
		String [] arrayString = commonUtil.binaryStringToArray(str);
		
		int groupSize=arrayString.length/2;
		
		//Get all possible sequences.
	    combinationUtil.getAdvancedCombinations(arrayString, groupSize);

	}
}
