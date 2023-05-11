/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsc.cshms.homework;

/**
 *
 * @author user
 */
public class CompleteStatus {
    
    private boolean status;
    
    public CompleteStatus(boolean status) {
        this.status = status;
    }
    
    public String toString() {
        return this.status ? "Completed" : "Not Complete";
    }
}
