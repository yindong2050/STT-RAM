package com.java.model;

import java.util.Objects;

/**
 *@param 
 * 
 */

public class Combination {

    private String x;

    private String y;

    private Integer cachedHashCode;

    public Combination(String x, String y) {
        this.x = x;
        this.y = y;
    }
    
    public Combination(){
    	
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    
    public boolean contains(Combination combination) {
        
    	return (x == combination.getX() || x == combination.getY())
                || (y == combination.getX() || y == combination.getY());
    }

    @Override
    public boolean equals(Object o) {
        
    	if (this == o) {
            
        	return true;
        }

        if (o == null || getClass() != o.getClass()) {
            
        	return false;
        }

        Combination that = (Combination) o;
        
        return (x == that.x && y == that.y) || (y == that.x && x == that.y);

    }

    @Override
    public int hashCode() {
        
    	if (cachedHashCode == null) {
        	
            cachedHashCode = calculateHashCode();
        }
        
        return cachedHashCode;
    }

    private int calculateHashCode() {
        
    	return Objects.hash(x, y);
    }
}

