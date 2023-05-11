/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsc.cshms.data;

import java.io.Serializable;

/**
 *
 * @author user
 */
class DataSetEntry implements Serializable {
    
    private String entryName;
    
    private Object content;
    
    public DataSetEntry(String entryName, Object content) {
        this.entryName = entryName;
        this.content = content;
    }

    public String getEntryName() {
        return entryName;
    }

    public Object getContent() {
        return content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        final DataSetEntry dataSetEntry = (DataSetEntry) obj;
        
        if (this.entryName.equals(dataSetEntry.entryName)) {
            return false;
        }
        
        return true;
    }
    
    
}
