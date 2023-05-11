/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsc.cshms;

import com.formdev.flatlaf.FlatLaf;
import edu.fsc.cshms.data.DataManager;
import edu.fsc.cshms.forms.MainMenuForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UIManager.installLookAndFeel("FlatLightLaf", "com.formdev.flatlaf.FlatLightLaf");
        UIManager.installLookAndFeel("FlatDarkLaf", "com.formdev.flatlaf.FlatDarkLaf");
        UIManager.installLookAndFeel("FlatIntelliJLaf", "com.formdev.flatlaf.FlatIntelliJLaf");
        UIManager.installLookAndFeel("FlatDarculaLaf", "com.formdev.flatlaf.FlatDarculaLaf");
                
        DataManager dataManager = DataManager.getDataManager();
        
        try {
            dataManager.loadDataSet();
         
            String activeThemeClassName = dataManager.getActiveTheme();
            System.err.println(activeThemeClassName);
            
            String appTheme = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        
            try {
                if(activeThemeClassName != null)
                    appTheme = activeThemeClassName;
            
                UIManager.setLookAndFeel(appTheme);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MainMenuForm mainMenu = new MainMenuForm();
        mainMenu.setVisible(true);
    }
    
}