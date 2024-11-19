package com.java.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.java.model.CellTransition;
import com.java.model.CodeData;

public class PermutationUtil {
    
    List<List<String>> res = new ArrayList<>();
    
	List<CodeData> temp = new ArrayList<>();
	
	List<String> tempString = new ArrayList<>();
	
	CommonUtil commonUtil = new CommonUtil();
	
	/*Full sequence
	 * @param  arrlist  original sequence
	 * @return  res  All sequences after full sequence
	 */
    public List<List<String>> permute(String[] arrlist) {
    	
    	if (arrlist.length == 0) {
           
    		return res;
        }
        
    	backtracking(arrlist);
        
    	return res;
    }
 
    /*Get a single sequence that meets the conditions
	 * @param  arrlist  Original sequence
	 */
    public void backtracking(String[] arrlist) {
        
    	if (tempString.size() == arrlist.length) {  
            
        	res.add(new ArrayList<>( tempString));    
    		
        	return;
        }
    	
        for (int i = 0; i < arrlist.length; i++) {
            
        	if ( tempString.contains(arrlist[i]))
                
        		continue;
            
        	 tempString.add(arrlist[i]);
            
        	backtracking(arrlist);
            
        	 tempString.remove( tempString.size() - 1);
        }
    }
    
}