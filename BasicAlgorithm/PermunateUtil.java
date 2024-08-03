package com.java.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Combination;

public class PermunateUtil {

	//Set the original minTT.
	long minTT =655356;
	
	//Set the original minEnergy.
    double minEnergy = 2000000000;
   
    /*  The main method of basic algorithm.
     * @param arrString  The original binary code sequence.
     * */
   	public void strPermute(String[] arrString) {
   		   
       	 do {
       		 
       		 List<String> strings = new ArrayList<String>();
               
       		 for (String subString : arrString) {
                   
       				 strings.add(subString);
               }
               
       		   CombinationBinaryUtil combinationBinaryUtil =new CombinationBinaryUtil();
   				
    			List <Combination> STTOriginalList = combinationBinaryUtil.getSTTOriginalList(strings);
    			
    			long totalTT=combinationBinaryUtil.STTTransition(STTOriginalList, arrString);
    			
    			//Comparison of TT values.
    			if(totalTT <= minTT){
   				
   				double totalEnergy = combinationBinaryUtil.countEnergy(strings);
   				
   			//Due to the influence of floating point data precision, errors within 0.0000001 are considered equal.
   				if(totalEnergy - minEnergy < 0.0000001){						
   					
   					minTT = totalTT;
   					
   					minEnergy = totalEnergy;
   					
   					BigDecimal bd = BigDecimal.valueOf(minEnergy).setScale(3, RoundingMode.HALF_UP);
   			        
   					double roundedValue = bd.doubleValue();
   					
   					System.out.println("Min number of TTs:"+minTT+",energy consumpution:"+roundedValue+", sequence:"+ strings);
   				}					
   			}
    			 
           } while (lexNextPerm(arrString, arrString.length));	 
       }
    
    
	
    /*The basic algorithm*/
	static boolean lexNextPerm(String[] str, int n) { // Algorithm Complexity: O(n)
        
    	if (n > 0) { // if the parameters are valid
            // find max{ j | j >= 0 && j < n - 1 && set[j] < set[j + 1] }
            
    		int j;
            
    		for (j = n - 2; j >= 0; j--) {
                
    			//int result = str[j].compareTo(str[j+1]);
    			
    			if (str[j].compareTo(str[j+1]) < 0)
                    
    				break;
            }
             if (j == -1) {  // indicate the last permutation
                
            	 reverse(str, 0, n - 1);
                
            	 return false;
            } else {
                // find max{ l | l > j && l < n && set[l] > set[j] }
                int l;
               
                for (l = n - 1; l > j; l--) {
                    
                	//if (str[l] > str[j])
                	
                	if(str[l].compareTo(str[j]) > 0)
                        
                		break;
                }
                
                interchange(str, j, l); // interchange set[j] <-> set[l]
                
                reverse(str, j + 1, n - 1); // reverse set[j+1] ... set[n-1]
            }
            
             return true;
        }
         
    	return false;
    }
    
	// interchange set[i] <-> set[j]
    static void interchange(String[] str, int i, int j) {
        String temp = str[i];
        
        str[i] = str[j];
        
        str[j] = temp;
    }
    
     // reverse set[i] ... set[j]
    static void reverse(String[] str, int i, int j) {
        
    	int lim = i + (j - i) / 2;
        
    	for (int k = i; k <= lim; k++) {
            
    		interchange(str, k, j - k + i);
        }
    }	
}
