package com.java.test;

import org.junit.Test;

import com.java.handle.TTMappingHandle;
import com.java.util.BinaryUtil;

public class STTRAMTest {
	
	/*Test the Basic of zeroTT algorithm
	 * @param N   the number of bits
	 * */
	@Test
	public void test_PermunateFindMapping(){
		
		int N = 4;
		
		TTMappingHandle ttMappingHandle=new TTMappingHandle();
		
		ttMappingHandle.permunateFindMapping(N);
		
	}
	
	}