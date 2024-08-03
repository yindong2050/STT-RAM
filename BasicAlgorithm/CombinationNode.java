package com.java.model;

import java.util.*;

public class CombinationNode {

    private List<Combination> combinations;
    
    private Set<String> elementSet;

    private Integer cachedHashCode;

    public CombinationNode() {
        combinations = new ArrayList<>();
        elementSet = new HashSet<>();
    }

    public List<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(List<Combination> combinations) {
        this.combinations = combinations;
    }

    public boolean add(Combination combination) {
        combinations.add(combination);
        elementSet.add(combination.getX());
        elementSet.add(combination.getY());
        return true;
    }

    public boolean contains(Combination combination) {
    	
        return elementSet.contains(combination.getX()) || elementSet.contains(combination.getY());
    }

    public void removeLast() {
        Combination combination = combinations.get(combinations.size() - 1);
        combinations.remove(combinations.size() - 1);
        elementSet.remove(combination.getX());
        elementSet.remove(combination.getY());
    }

    public boolean equals(CombinationNode combinationNode) {
        for(Combination currCombination : combinationNode.getCombinations()) {
            boolean exist = false;
            for (Combination combination : combinations) {
                if(currCombination.equals(combination)) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
            cachedHashCode = calculateHashCode();
        return cachedHashCode;
    }

    private int calculateHashCode() {
        int result = 0;
        for(Combination combination : combinations) {
            result = 31 * result + combination.hashCode();
        }
        return result;
    }
}
