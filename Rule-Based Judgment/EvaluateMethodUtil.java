package com.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.java.model.CellTransition;
import com.java.model.CodeData;

public class EvaluateMethodUtil {
	
	CommonUtil commonUtil = new CommonUtil();

	/*The rule-based judgment method
	 * @param  M  Data number
	 * @param  N  Code number
	 */
	public  void JudgmentMethod(int M, int N) {
		
		int countNumber = 0;
		
		if(N==(M+1)){
			
			if(N==4){
				
				List<List<String>> res_first = new ArrayList<>();
				
				List<List<String>> res_second = new ArrayList<>();
				
				List<List<String>> res_third = new ArrayList<>();
	
				PermutationUtil permutationUtil = new PermutationUtil();
				
				String[] arrlist_firstPart = new String[]{"0101","0110","1001","1010"};
				
				String[] arrlist_secondPart = new String[]{"0010","1110"};
			
				String[] arrlist_thirdPart = new String[]{"1000","1011"};
				
				res_first  = permutationUtil.permute(arrlist_firstPart);
				
				List<List<String>> new_res_first = res_first.stream().collect(Collectors.toList());
				
				res_first.clear();
				
				res_second  = permutationUtil.permute(arrlist_secondPart);
				
				List<List<String>> new_res_second = res_second.stream().collect(Collectors.toList());
				
				res_second.clear();
				
				res_third  = permutationUtil.permute(arrlist_thirdPart);
				
				List<List<String>> new_res_third = res_third.stream().collect(Collectors.toList());
				
				res_third.clear();
				
				for (int i = 0; i < new_res_first.size(); i++){
					
					for (int j = 0; j < new_res_second.size(); j++){
						
						for (int k = 0; k < new_res_third.size(); k++){
							
							List<String> firstPartString = new_res_first.get(i);
							
							List<String> secondPartString = new_res_second.get(j);
							
							List<String> thirdPartString = new_res_third.get(k);
							
							List<CodeData> codeList = new ArrayList();
							
							CodeData codeData_1 = new CodeData();
							
							codeData_1.setFirstCode("0000");
							codeData_1.setSecondCode(firstPartString.get(0));
							
							CodeData codeData_2 = new CodeData();
							
							codeData_2.setFirstCode("0011");
							codeData_2.setSecondCode(firstPartString.get(1));
							
							CodeData codeData_3 = new CodeData();
							
							codeData_3.setFirstCode("1100");
							codeData_3.setSecondCode(firstPartString.get(2));
							
							CodeData codeData_4 = new CodeData();
							
							codeData_4.setFirstCode("1111");
							codeData_4.setSecondCode(firstPartString.get(3));
							
							CodeData codeData_5 = new CodeData();
							
							codeData_5.setFirstCode("0001");
							codeData_5.setSecondCode(secondPartString.get(0));
							
							CodeData codeData_6 = new CodeData();
							
							codeData_6.setFirstCode("1101");
							codeData_6.setSecondCode(secondPartString.get(1));
							
							CodeData codeData_7 = new CodeData();
							
							codeData_7.setFirstCode("0100");
							codeData_7.setSecondCode(thirdPartString.get(0));
							
							CodeData codeData_8 = new CodeData();
							
							codeData_8.setFirstCode("0111");
							codeData_8.setSecondCode(thirdPartString.get(1));
							
							codeList.add(codeData_1);
							codeList.add(codeData_2);
							codeList.add(codeData_3);
							codeList.add(codeData_4);
							codeList.add(codeData_5);
							codeList.add(codeData_6);
							codeList.add(codeData_7);
							codeList.add(codeData_8);
							
							CellTransition cellTransition = new CellTransition();
				    		
				        	cellTransition = commonUtil.getSTTMessage(codeList);
				        	
				        	for(int m = 0; m <codeList.size();m++){
				        		
				        		System.out.print(codeList.get(m).getFirstCode()+" "+codeList.get(m).getSecondCode()+" ");
				        		
				        	}
				        	System.out.println();
				        	
				        	System.out.println("TT:"+cellTransition.getTT()+" ZT:"+cellTransition.getZT()+" ST:"+cellTransition.getST()+" HT:"+cellTransition.getHT());
				        	double energy = cellTransition.getTT()*2.502+cellTransition.getZT()*0+cellTransition.getST()*0.843+cellTransition.getHT()*1.659;
				        	System.out.println("Energy:"+energy);			        	
							countNumber++;						
						}					
					}
					
				}			
				
			}
			else{
				
				System.out.println("No sequence with TT=0 was found!");
			}
			
		}
		else{
			
			System.out.println("Data initialization setting error!");
			
		}
		
	System.out.println("Total types£º"+countNumber);
		
	}

}
