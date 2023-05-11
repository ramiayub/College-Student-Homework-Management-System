/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fsc.cshms.data;

import edu.fsc.cshms.homework.Homework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author user
 */

public final class DataManager {
    
    private static DataManager instance = null;
    
    private String path;
    
    private DataSet activeDataSet;
    
    private DataManager(String path) {
        this.path = path;
        this.activeDataSet = new DataSet();
    }
    
    public String getPath() {
        return path;
    }
    
    public DataSet getDataSet() {
        return activeDataSet;
    }
    
    public void setHomeworks(LinkedList<Homework> homeworks) {        
        DataSetEntry homeworksDataSetEntry = new DataSetEntry("homeworks", homeworks);
        
        if(activeDataSet.contains(homeworksDataSetEntry))
            activeDataSet.remove(activeDataSet.indexOf(homeworksDataSetEntry.getEntryName(), 0));
        
        activeDataSet.add(homeworksDataSetEntry);
    }
    
    public LinkedList<Homework> getHomeworks() {
        DataSet dataSet = getDataSet();
        
        if(dataSet.get("homeworks") == null)
            return new LinkedList<Homework>();
        
        return (LinkedList<Homework>) dataSet.get("homeworks").getContent();
    }
    
    public void setActiveTheme(String themeClassName) {
        DataSetEntry themeDataSetEntry = new DataSetEntry("active-theme", themeClassName);
        
        if(activeDataSet.contains(themeDataSetEntry.getEntryName()))
            activeDataSet.remove(activeDataSet.indexOf(themeDataSetEntry.getEntryName(), 0));
        
        activeDataSet.add(themeDataSetEntry);
    }
    
    public String getActiveTheme() {
        DataSet dataSet = getDataSet();
        
        DataSetEntry dataSetEntry = dataSet.get("active-theme");
        
        return dataSetEntry != null ? (String) dataSetEntry.getContent() : null;
    }
    
    public void dumpDataSet() throws IOException, ClassNotFoundException {
        File pathFile = new File(getPath());
        
        if(pathFile.isFile() && !pathFile.exists()) {
            pathFile.createNewFile();
        }
        
        FileOutputStream fos = new FileOutputStream(pathFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(this.activeDataSet);
        
        oos.close();
        fos.close();
        
        loadDataSet();
    }
    
    public void loadDataSet() throws IOException, ClassNotFoundException {
        DataSet dataSet;
        
        File pathFile = new File(getPath());
        
        if(!pathFile.exists()) {
            pathFile.createNewFile();
        }
        
        if(pathFile.length() <= 0)
            return;
        
        FileInputStream fis = new FileInputStream(pathFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        dataSet = (DataSet) ois.readObject();
        
        ois.close();
        fis.close();
        
        this.activeDataSet = dataSet;
    }
    
    public static DataManager getDataManager() {
        if(instance == null) {
            String pathSeparator = System.getProperty("file.separator");
            
            String path = System.getProperty("user.home");
            
            path = String.format("%s%s%s", path, path.endsWith(pathSeparator) ? "" : pathSeparator, ".cshms.dat");
            instance = new DataManager(path);
        }
        
        return instance;
    }
}
