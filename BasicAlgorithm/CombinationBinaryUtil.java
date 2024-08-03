package com.java.util;

import java.util.ArrayList;
import java.util.List;

import com.java.model.CellTransition;
import com.java.model.Combination;

public class CombinationBinaryUtil {

	/*Get the sequences of the original comparison.
	 * @param stringsList   The binary string sequence.
	 * @return A collection of converted binary strings.
	 * */
	public List<Combination> getSTTOriginalList(List<String> stringsList) {
		
		List <Combination> STTOriginalList =new ArrayList<Combination>();
		
		for(int i= 0;i<stringsList.size();i++,i++){
			
			Combination combinationNode=new Combination();
				
				combinationNode.setX(stringsList.get(i));
				
				combinationNode.setY(stringsList.get(i+1));
				
				STTOriginalList.add(combinationNode);			
		}
		
		return  STTOriginalList;
	}

	/*Get the number of TT of the binary strings.
	 * @param STTOriginalList   The binary string sequence.
	 * @param arrString  The binary string array.
	 * @return the number of TT.
	 * */
	public long STTTransition(List<Combination> STTOriginalList, String[] arrString) {
		
		long totalTT = 0;
		
		for(int i = 0; i< STTOriginalList.size();i++){
			
			Combination combination = STTOriginalList.get(i);
		
			totalTT=totalTT + SubeginStrTTTransition(combination, arrString);
		
			}
		
		return totalTT;
	}

	/*Get the number of TT of one of the binary strings.
	 * @param combination   The binary string.
	 * @param arrString  The binary string array.
	 * @return the number of TT.
	 * */
	public long SubeginStrTTTransition(Combination combination, String [] arrString) {
		
		long subTotalTT=0;
		
		CommonUtil commonUtil = new CommonUtil();
		
		String firstString = combination.getX();
		
		String secondString = combination.getY();
		
		for(int i=0;i<arrString.length;i++){
			
			CellTransition firstBacicMLCSTTRAM = commonUtil.BinaryTransition(arrString[i],firstString);
			
			CellTransition secondBacicMLCSTTRAM = commonUtil.BinaryTransition(arrString[i],secondString);
			
			CellTransition tempBacicMLCSTTRAM = getMinTT(firstBacicMLCSTTRAM , secondBacicMLCSTTRAM);
			
			subTotalTT= subTotalTT + tempBacicMLCSTTRAM.getTT();		
		}
				
		return subTotalTT;
					
	}

	/*Get the number of minTT.
	 * @param firstCellTransition   The first cellTransition.
	 * @param firstCellTransition  The second cellTransition.
	 * @return The  cellTransition of min number of TT.
	 * */
	public CellTransition getMinTT(CellTransition firstCellTransition, CellTransition secondCellTransition) {
		
		double ZTFactor=0.0;
		double STFactor=0.843;
		double HTFactor=1.659;
		double TTFactor=2.502;
				
		if(firstCellTransition.getTT() >secondCellTransition.getTT()){
			
			return secondCellTransition; 
			
		}
		else if(firstCellTransition.getTT()<secondCellTransition.getTT()){
			
			return firstCellTransition;
		}
		else{
			
			double firstBasicMLC=ZTFactor*firstCellTransition.getZT()+STFactor*firstCellTransition.getST()+HTFactor*firstCellTransition.getHT()+TTFactor*firstCellTransition.getTT();
			
			double secondBasicMLC=ZTFactor*secondCellTransition.getZT()+STFactor*secondCellTransition.getST()+HTFactor*secondCellTransition.getHT()+TTFactor*secondCellTransition.getTT();
			
			if(firstBasicMLC < secondBasicMLC){
				
				return firstCellTransition;
			}
			else{
				
				return secondCellTransition;
			}
						
		}		
	}

	/*Get the energy consumption of the sequences
	 * @param stringsList  The binary string sequence.
	 * @return The energy of the binary string sequence.
	 * */
	public double countEnergy(List<String> stringsList) {
		
		List<String> checkAl=new ArrayList<String>();
		
		double energy = 0;
		
		for(int i=0;i<stringsList.size();i++,i++){
			
			checkAl.add(stringsList.get(i));
			checkAl.add(stringsList.get(i+1));
			
			double teEnergy = countForEveryConverserTTEnergy(stringsList,checkAl);
			
			energy = energy + teEnergy;
			
			checkAl.clear();
		}

		
		return energy;
		
	}

	/*Get the energy consumption of one of the sequence.
	 * @param lists The binary string sequences.
	 * @checkAl  one cell of the string sequence.
	 * @return The energy of one of the binary string sequences.
	 * */
	private double countForEveryConverserTTEnergy(List<String> lists, List<String> checkAl) {
		
		double energy = 0;
		
		for(int i=0;i<lists.size();i++){
			
			
			double tempEnergy = coutForStringConverserEnergy(lists.get(i),checkAl);
			
			
			energy = energy+ tempEnergy;
		}
		
		return energy;
	}

	/*Get the energy consumption of one cell.
	 * @param str The binary string sequence.
	 * @checkAl  one cell of the string sequence.
	 * @return The energy of one of the binary string sequence.
	 * */
	private double coutForStringConverserEnergy(String str, List<String> checkAl) {
		
		double energy = 0;
		
		int a,b;
		
		String str1=checkAl.get(0);
		
		String str2=checkAl.get(1);
		
		a=compareInverseString(str,str1);
		
		b=compareInverseString(str,str2);
		
		if(a > b){
							
			energy = energy + countEvergyEnergy(str,str2);
			
		}else if(a < b){
					
			energy = energy + countEvergyEnergy(str,str1);
			
		}else{
			
			
			double energy1 = countEvergyEnergy(str,str1);
			
			double energy2 = countEvergyEnergy(str,str2);
			
			if(energy1 < energy2){
				
				energy = energy + energy1;
				
			}
			else{
				
				energy = energy + energy2;
			}
			
		}
					
		return energy;
	}

	/*Get the energy of one transition.
	 * @param str1 The binary string sequence.
	 * @param str2  The binary string sequence.
	 * @return The energy of one transition.
	 * */
	private double countEvergyEnergy(String str1, String str2) {
		
		double energy = 0;
		
		if(str1.length()==str2.length()){
			
			int k=0;
			
			while(k < str1.length()){
				
				String bs = str1.substring(k, k+2);
				
				String es = str2.substring(k, k+2);
				
				energy = compareInversreBinaryEnergy(bs,es) + energy;
				
				k = k + 2;
			}
			
		}
		
		else{
			
			System.out.println("The string passed in is incorrect");
			
		}
		
		return energy;
	}
	
	//Calculate the number of TT in string comparison, such as 0000, 1010, the number of TT is 2.
		public int compareInverseString(String str1,String str2){
			int n=0;
			
			if(str1.length() == str2.length()){
				
				int k = 0;
				
				while(k < str1.length()){
					
					String bs = str1.substring(k, k + 2);
					
					String es = str2.substring(k, k + 2);
					
					n = compareInversreBinary(bs, es) + n;
					
					k = k + 2;
				}
				
			}
			
			else{
				
				System.out.println("The string passed in is incorrect");
				
			}
			
			return n;
		}
		
		//Determine the number of binary digits TT, such as 00,10, the number of TT is 1.
		public int compareInversreBinary(String bs, String es) {
			
			int n = 0;
			
			if((bs.equals("00")&&es.equals("10"))||(bs.equals("01")&&es.equals("10"))||(bs.equals("10")&&es.equals("01"))||(bs.equals("11")&&es.equals("01")))
			{
				
				n = 1;
			}
			
			return n;
		}	

		//Get the number of energy.
		private double compareInversreBinaryEnergy(String bs, String es) {
		
		double TEnergy = 0;
		
		double ZTEnergy = 0, STEnergy =0.843, HTEnergy =1.659, TTEnergy =2.502;
		
		if((bs.equals("00")&&es.equals("00"))||(bs.equals("01")&&es.equals("01"))||(bs.equals("10")&&es.equals("10"))||(bs.equals("11")&&es.equals("11")))
		{
			
			TEnergy = TEnergy + ZTEnergy*1;
		}
		else if((bs.equals("00")&&es.equals("01"))||(bs.equals("01")&&es.equals("00"))||(bs.equals("10")&&es.equals("11"))||(bs.equals("11")&&es.equals("10"))){
			
			TEnergy = TEnergy + STEnergy*1;
		}
		
		else if((bs.equals("00")&&es.equals("11"))||(bs.equals("01")&&es.equals("11"))||(bs.equals("10")&&es.equals("00"))||(bs.equals("11")&&es.equals("00"))){
			
			TEnergy = TEnergy + HTEnergy*1;
			
		}
		
		else if((bs.equals("00")&&es.equals("10"))||(bs.equals("01")&&es.equals("10"))||(bs.equals("10")&&es.equals("01"))||(bs.equals("11")&&es.equals("01")))
		{
			TEnergy = TEnergy + TTEnergy*1;
		}
		
		return TEnergy;
	 }
			
	}