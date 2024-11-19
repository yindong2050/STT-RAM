package com.java.util;

import java.util.List;

import com.java.model.CellTransition;
import com.java.model.CodeData;
import com.java.model.TotalCellTransition;

public class CommonUtil {
	
	
	/* Get all transformation information
	 * @param  codeList Original code list
	 * @return Transformation information
	 */
	public CellTransition getSTTMessage(List<CodeData> codeList) {
			
       CellTransition cellTransition = new CellTransition();
	
		for(int i=0; i < codeList.size(); i++){
			
			
			cellTransition = getSubSTTMessage(codeList.get(i), codeList, cellTransition);
			
		}

		return cellTransition;
	}


	/* Get transformation information for a codeList
	 * @param codeData  Original code
	 * @param  codeList Original code list
	 * @param cellTransition  Existing transformation information 
	 * @return Transformation information
	 */
	private CellTransition getSubSTTMessage(CodeData codeData, List<CodeData> codeList, CellTransition cellTransition) {
		
		String firstCode = codeData.getFirstCode();
		
		String secondCode = codeData.getSecondCode();
		
		for(int i=0; i < codeList.size(); i++){
			
			CodeData  tempCodeData = codeList.get(i);
			
			CellTransition cell_first = getEverySTTMessage(firstCode, tempCodeData, cellTransition);
	
			CellTransition cell_second = getEverySTTMessage(secondCode, tempCodeData, cellTransition);
			
			cellTransition.setZT(cellTransition.getZT()+cell_first.getZT()+ cell_second.getZT());
			
			cellTransition.setST(cellTransition.getST()+cell_first.getST()+cell_second.getST());
			
			cellTransition.setHT(cellTransition.getHT()+cell_first.getHT()+cell_second.getHT());
			
			cellTransition.setTT(cellTransition.getTT()+ cell_first.getTT()+cell_second.getTT());
			
		}	
		
		return cellTransition;
	}


	/* Get transformation information for every code
	 * @param stringCode  Original code
	 * @param  tempCodeData  Data that needs to be transformated
	 * @param cellTransition  Existing transformation information 
	 * @return Transformation information
	 */
	private CellTransition getEverySTTMessage(String stringCode, CodeData tempCodeData, CellTransition cellTransition) {
		
		String tempFirstCode = tempCodeData.getFirstCode();
		
		String tempSecondCode = tempCodeData.getSecondCode();
		
		CellTransition firstCodeCellTransition = getTransitionMessage(stringCode, tempFirstCode);
		
		CellTransition secondCodeCellTransition = getTransitionMessage(stringCode, tempSecondCode);
		
		cellTransition = getMinTT(firstCodeCellTransition, secondCodeCellTransition);
		
		
		return cellTransition;
	}


	/* Get transformation information for binary codes
	 * @param firstTagString  Original binary codes
	 * @param  secondTagString  Binary codes that needs to be transformated
	 * @return Transformation information
	 */
	private CellTransition getTransitionMessage(String firstTagString, String secondTagString) {

		CellTransition bmt = new CellTransition(); 
		
		BinaryUtil binaryUtil = new BinaryUtil();
		
		if(firstTagString.length() == secondTagString.length()){
			
			int strLength = secondTagString.length();
				
			int k = 0;
				
				while(k < strLength){
					
					String beginStr = firstTagString.substring(k, k + 2);
					
					String endStr = secondTagString.substring(k, k + 2);
					
					bmt = binaryUtil.SubBinaryTransition(beginStr, endStr, bmt);
									
					k = k + 2;	
			}
			
		}
		else{
			
			System.out.println("Data Error£¡");
		}
				
		return bmt;
	}	
	
	/* Get minimum TT transformation information for binary codes
	 * @param min  Original minimum TT information
	 * @param  st  TT information to be compared
	 * @return The latest TT minimum Information
	 */	
public CellTransition getMinTT(CellTransition min, CellTransition st) {
		
		TotalCellTransition  temp=new TotalCellTransition();
		
		if(st.getTT() < min.getTT()){
			
			temp.setHT(st.getHT());
			temp.setST(st.getST());
			temp.setTT(st.getTT());
			temp.setZT(st.getZT());
		}
		else if(st.getTT()==min.getTT()){
			
	   	 double d1=0*st.getZT()+0.843*st.getST()+1.659*st.getHT()+2.502*st.getTT();
	   	 
	   	 double d2=0*min.getZT()+0.843*min.getST()+1.659*min.getHT()+2.502*min.getTT();
	   	 
	   	 	if(d1<=d2){	   		 
	   	 		temp.setHT(st.getHT());
	   	 		temp.setST(st.getST());
	   	 		temp.setTT(st.getTT());
	   	 		temp.setZT(st.getZT());  		 
	   	 	}
	   	 	else{	   		 
	   	 		temp.setHT(min.getHT());
	   	 		temp.setST(min.getST());
	   	 		temp.setTT(min.getTT());
	   	 		temp.setZT(min.getZT());
	   	 	}
			
		}
		else{
				temp.setHT(min.getHT());
				temp.setST(min.getST());
				temp.setTT(min.getTT());
				temp.setZT(min.getZT());
			
		}
		return temp;
	}
	
}
