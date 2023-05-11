/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsc.cshms.data;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author user
 */
public class DataSet extends Vector<DataSetEntry> implements Serializable {
    
    @Override
    public synchronized boolean add(DataSetEntry entry) {
        if(contains(entry))
           return false;
        
        return super.add(entry);
    }
    
    public synchronized DataSetEntry get(String entryName) {
        int indexOfEntry = indexOf(entryName, 0);
        
        if(indexOfEntry < 0)
            return null;
        
        return (DataSetEntry) elementData[indexOfEntry];
    }
    
    @Override
    public synchronized int indexOf(Object entryName, int index) {
        for (int i = index ; i < elementCount ; i++) {
            if(entryName instanceof String) {
                if(String.valueOf(entryName).equals(((DataSetEntry) elementData[i]).getEntryName()))
                    return i;
            } else if(entryName instanceof DataSetEntry) {
                if(String.valueOf(((DataSetEntry) entryName).getEntryName()).equals(((DataSetEntry) elementData[i]).getEntryName()))
                    return i;
            } else {
                if(entryName.equals(elementData[i]))
                    return i;
            }
        }
        
        return -1;
    }
    
//    @Override
//    public boolean contains(Object o) {
//        return indexOf(o, 0) >= 0;
//    }
    
}
