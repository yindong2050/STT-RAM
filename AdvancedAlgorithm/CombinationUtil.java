package com.java.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Combination;
import com.java.model.CombinationList;
import com.java.model.CombinationNode;

public class CombinationUtil {
	
    long minTT =655356;
	
    double minEnergy = 2000000000;
    
	/**
	   * @param array
	   * @param groupSize
	   * @return
	   */
	public CombinationList getAdvancedCombinations(String[] array, int groupSize) {
	      
		  int index = 0;
		  
		  List<Combination> combinations = getCombinations(array);
		  
	      CombinationList combinationList = new CombinationList();
	      
	      CombinationNode currCombination = new CombinationNode();

	      generateAdvancedCombinations(combinations, index, groupSize, combinationList, currCombination);
	      
	      return combinationList;
	  }
	
	
	/**
	   * @param array
	   * @return
	   */
	 public List<Combination> getCombinations(String[] array) {
	      
		  List<Combination> combinations = new ArrayList<>();
	       
		  for (int i = 0; i < array.length - 1; i++) {
	          
			  for (int j = i + 1; j < array.length; j++) {
	              
				  combinations.add(new Combination(array[i], array[j]));
	          }
	      }
	      
		  return combinations;
	  }

	  /**
	   * @param combinations
	   * @param groupSize
	   * @param combinationList
	   * @param currentCombination
	   */
	 public void generateAdvancedCombinations(List<Combination> combinations, int index, int groupSize,
	                                           CombinationList combinationList, CombinationNode currentCombination) {
	      if(currentCombination.getCombinations().size() == groupSize) {
	          
	    	  addIntoCombination(combinationList, currentCombination);
	    	  
	    	  
	      } else {
	          
	    	  for(int i = index; i < combinations.size(); i++) {
	              
	    		  if(!currentCombination.contains(combinations.get(i))) {
	                  
	    			  currentCombination.add(combinations.get(i));
	                  
	    			  generateAdvancedCombinations(combinations, i + 1, groupSize, combinationList, currentCombination);
	                  
	    			  currentCombination.removeLast();
	              }
	          }
	      }
	  }

	 public void addIntoCombination(CombinationList combinationList, CombinationNode combinationNode) {
	      
		  if(!combinationList.contains(combinationNode)) {
	          
	    	  CombinationNode newCombinationNode = new CombinationNode();
	          
	    	  newCombinationNode.getCombinations().addAll(combinationNode.getCombinations());
	          
	    	  CombinationBinaryUtil combinationBinaryUtil =new CombinationBinaryUtil();
		    	
		    	List<String> stringsList = new ArrayList<>();
		    	
		    	for(int i=0;i<newCombinationNode.getCombinations().size();i++){
		    		
		    		String firstStr=newCombinationNode.getCombinations().get(i).getX();
		    		
		    		String secondStr=newCombinationNode.getCombinations().get(i).getY();
		    		
		    		stringsList.add(firstStr);
		    		
		    		stringsList.add(secondStr);
		    	}
		    		
				String[] arrString = stringsList.toArray(new String[stringsList.size()]);
				
				long totalTT = combinationBinaryUtil.STTTransition(newCombinationNode.getCombinations(), arrString);
								
				if(totalTT <= minTT){
					
					double totalEnergy = combinationBinaryUtil.countEnergy(stringsList);
					
					if(totalEnergy - minEnergy < 0.0000001){						
						
						minTT = totalTT;
						
						minEnergy = totalEnergy;
						
						BigDecimal bd = BigDecimal.valueOf(minEnergy).setScale(3, RoundingMode.HALF_UP);
				        
						double roundedValue = bd.doubleValue();
						
						System.out.println("Min number of TTs:"+minTT+",energy consumpution:"+roundedValue+", sequence:"+ stringsList);
						
					}					
				}			
				
			}
						  	    	  
	      }
	
	public void swap(List<Combination> combinations, int i, int j) {
		
		Combination temp = combinations.get(i);
		
		combinations.set(i, combinations.get(j));
		
		combinations.set(j, temp);
		
	}

}
