package com.java.test;

import org.junit.Test;

import com.java.handle.TTMappingHandle;

public class STTRAMTest {
	
	
	/*Test the advanced algorithm
	 * @param N   the number of bits
	 * */
	@Test
	public void test_AdvancedCombinationMethod(){
		
		int N = 4;
		
		TTMappingHandle ttMappingHandle=new TTMappingHandle();
		
		ttMappingHandle.advancedCombinationFindMapping(N);
		
	}
	
}