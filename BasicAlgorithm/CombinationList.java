package com.java.model;

import java.util.ArrayList;
import java.util.List;


public class CombinationList {

    private long timeCount = 0;

    private List<CombinationNode> combinationNodes;

    public CombinationList() {
        
    	combinationNodes = new ArrayList<>();
    }

    public long getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(long timeCount) {
        this.timeCount = timeCount;
    }

    public List<CombinationNode> getCombinationNodes() {
        return combinationNodes;
    }

    public void setCombinationNodes(List<CombinationNode> combinationNodes) {
        this.combinationNodes = combinationNodes;
    }

    public boolean add(CombinationNode combinationNode) {
        combinationNodes.add(combinationNode);
        return true;
    }

    /**
     * Check if it already exists.
     * @param currentCombinationNode
     * @return
     */
    public boolean contains(CombinationNode currentCombinationNode) {
        
    	long startTime = System.currentTimeMillis();
        
    	for(CombinationNode combinationNode : combinationNodes) {
            
    		if(combinationNode.equals(currentCombinationNode)) {
                
    			long endTime = System.currentTimeMillis();
                
    			timeCount += (endTime - startTime);
                
    			return true;
            }
        }
        
    	long endTime = System.currentTimeMillis();
        
    	timeCount += (endTime - startTime);
        
    	return false;
    }

}
