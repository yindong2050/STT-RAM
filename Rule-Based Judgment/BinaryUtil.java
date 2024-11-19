package com.java.util;

import java.util.List;

import com.java.model.CellTransition;
import com.java.model.CodeData;
import com.java.model.TotalCellTransition;

public class BinaryUtil {
	
		/* Convert hexadecimal data to binary data
		 * @param  hex  Hexadecimal data
		 * @return Binary data
		 */
		public String hexToBinary(String hex){
	
			String binary =  "";
			
			for(int i = 0; i  <  hex.length(); i++){
				 
				 binary=binary + subHexToBinary(hex.charAt(i));
			 }
					
	        return binary;
		
		}
		
		/*
		 * Convert each hexadecimal data into a binary data
		 * @param  subChar Hexadecimal data
		 * @return  Binary data
		 */
		public String subHexToBinary(char subChar){
			
			String result  =  "";
			
			switch(subChar){	
				
			case '0':
				result = "0000";
				break;
			case '1':
				result = "0001";
				break;
			case '2':
				result = "0010";
				break;
			case '3':
				result = "0011";
				break;
			case '4':
				result = "0100";
				break;
			case '5':
				result = "0101";
				break;
			case '6':
				result = "0110";
				break;
			case '7':
				result = "0111";
				break;
			case '8':
				result = "1000";
				break;
			case '9':
				result = "1001";
				break;
			case 'a':
				result = "1010";
				break;
			case 'b':
				result = "1011";
				break;
			case 'c':
				result = "1100";
				break;
			case 'd':
				result = "1101";
				break;
			case 'e':
				result = "1110";
				break;
			case 'f':
				result = "1111";
				break;
			}
			return result;
		}
				
		/* Binary data transformation
		 * @param  beginStr  Original binary two-bit data
		 * @param  endStr   Final binary two-bit data
		 * @param bmt  The result message
		 * @return  The result message
		 */
		public TotalCellTransition subBinaryTransition(String beginStr, String endStr, TotalCellTransition bmt) {
			
			if((beginStr.equals("00")&&endStr.equals("00"))||(beginStr.equals("01")&&endStr.equals("01"))||(beginStr.equals("10")&&endStr.equals("10"))||(beginStr.equals("11")&&endStr.equals("11")))
			{
				
				bmt.setZT(bmt.getZT()+1);

			}
			else if((beginStr.equals("00")&&endStr.equals("01"))||(beginStr.equals("01")&&endStr.equals("00"))||(beginStr.equals("10")&&endStr.equals("11"))||(beginStr.equals("11")&&endStr.equals("10"))){
				
				bmt.setST(bmt.getST()+1);
			}
			
			else if((beginStr.equals("00")&&endStr.equals("11"))||(beginStr.equals("01")&&endStr.equals("11"))||(beginStr.equals("10")&&endStr.equals("00"))||(beginStr.equals("11")&&endStr.equals("00"))){
				
				bmt.setHT(bmt.getHT()+1);
				
			}
			
			else if((beginStr.equals("00")&&endStr.equals("10"))||(beginStr.equals("01")&&endStr.equals("10"))||(beginStr.equals("10")&&endStr.equals("01"))||(beginStr.equals("11")&&endStr.equals("01")))
			{
				
				bmt.setTT(bmt.getTT()+1);
			}
			
			return bmt;
			}

		/* Binary data transformation
		 * @param  beginStr  Original binary two-bit data
		 * @param  endStr   Final binary two-bit data
		 * @param bmt  The result message
		 * @return  The result message
		 */
		public CellTransition SubBinaryTransition(String beginStr, String endStr, CellTransition bmt) {
			
			if((beginStr.equals("00")&&endStr.equals("00"))||(beginStr.equals("01")&&endStr.equals("01"))||(beginStr.equals("10")&&endStr.equals("10"))||(beginStr.equals("11")&&endStr.equals("11")))
			{
				
				bmt.setZT(bmt.getZT()+1);

			}
			else if((beginStr.equals("00")&&endStr.equals("01"))||(beginStr.equals("01")&&endStr.equals("00"))||(beginStr.equals("10")&&endStr.equals("11"))||(beginStr.equals("11")&&endStr.equals("10"))){
				
				bmt.setST(bmt.getST()+1);
			}
			
			else if((beginStr.equals("00")&&endStr.equals("11"))||(beginStr.equals("01")&&endStr.equals("11"))||(beginStr.equals("10")&&endStr.equals("00"))||(beginStr.equals("11")&&endStr.equals("00"))){
				
				bmt.setHT(bmt.getHT()+1);
				
			}
			
			else if((beginStr.equals("00")&&endStr.equals("10"))||(beginStr.equals("01")&&endStr.equals("10"))||(beginStr.equals("10")&&endStr.equals("01"))||(beginStr.equals("11")&&endStr.equals("01")))
			{
				
				bmt.setTT(bmt.getTT()+1);
			}
			
			return bmt;
			}
}
