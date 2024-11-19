package com.java.handle;

import com.java.util.EvaluateMethodUtil;

public class STTRAMHandle {
	

	/*Determine whether it is the method of rule-based judgment
	 * */
	public void STTEvaluateHandleTT(String TTEvaluateMethod, int M, int N) {
		
		EvaluateMethodUtil  evalutateMethodUtil = new EvaluateMethodUtil ();
		
		if(TTEvaluateMethod.equals("rule-based judgment")){
			
			evalutateMethodUtil.JudgmentMethod(M, N);
		}
		else{
			
			System.out.println("other methods!");
		}
		
	}
}
