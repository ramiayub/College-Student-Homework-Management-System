/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsc.cshms.homework;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class HomeworkWeight implements Serializable {
    
    private final int weight;
    private final boolean isPercentage;

    public HomeworkWeight(int weight, boolean isPercentage) {
        this.weight = weight;
        this.isPercentage = isPercentage;
    }

    public int getWeight() {
        return weight;
    }

    public boolean IsPercentage() {
        return isPercentage;
    }

    public String toString() {
        return (!IsPercentage() ? String.valueOf(weight) : String.valueOf(weight) + "%");
    }

}
