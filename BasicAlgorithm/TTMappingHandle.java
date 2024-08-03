package com.java.handle;


import java.util.ArrayList;
import java.util.List;

import com.java.util.BinaryUtil;
import com.java.util.CommonUtil;
import com.java.util.PermunateUtil;

public class TTMappingHandle {

	/*The Basic of zeroTT algorithm*/
	public void permunateFindMapping(int number){
		
		BinaryUtil binaryUtil=new BinaryUtil();
		
		CommonUtil commonUtil = new CommonUtil();
		
		PermunateUtil permunateUtil=new PermunateUtil();
		
		number = commonUtil.getResultNumber(number);
		
		String binaryString = binaryUtil.totalBinaryFromGivenInt(number);
		
		List<String> stringsList = new ArrayList<>();
		
		String [] arrString=binaryString.split(",");
		
		for(int i = 0; i < arrString.length; i++){
			
			stringsList.add(arrString[i]);
		}	
		//Get all possible sequences.
		permunateUtil.strPermute(arrString);
	}
}
