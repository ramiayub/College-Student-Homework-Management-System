/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsc.cshms.homework.forms;

import edu.fsc.cshms.homework.Homework;
import edu.fsc.cshms.homework.HomeworkWeight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class HomeworkDialog extends javax.swing.JDialog {
    
    private Homework homework = null;

    /**
     * Creates new form AddHomeworkDialog
     */
    public HomeworkDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        
        this.setTitle("New Homework - Add");
        
        this.pack();
    }
    
    public HomeworkDialog(java.awt.Frame parent, boolean modal, Homework homework, boolean updateDialog) {
        super(parent, modal);
        initComponents();
        
        this.homework = homework;
        
        if(hasHomework())
            this.setTitle(this.homework.getName() + " - " + (updateDialog ? "Update" : "View"));
        
        populateUI();
        
        if(!updateDialog) {
            textFieldName.setEditable(false);
            textFieldCourse.setEditable(false);
            textAreaDescription.setEditable(false);
            formattedTextFieldDueDate.setEditable(false);
            spinnerTimeToSpend.setEnabled(false);
            spinnerWeight.setEnabled(false);
            checkBoxPercent.setEnabled(false);
            
            panelDialogControls.setVisible(false);
            this.pack();
        }
    }
    
    private boolean hasHomework() {
        return homework != null;
    }
    
    private void populateUI() {
        if(!hasHomework())
            return;
        
        textFieldName.setText(this.homework.getName());
        textFieldCourse.setText(this.homework.getCourse());
        textAreaDescription.setText(this.homework.getDescription());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        formattedTextFieldDueDate.setValue(sdf.format(this.homework.getDueDate()));
        
        spinnerTimeToSpend.setValue(this.homework.getTimeToSpend());
        
        HomeworkWeight homeworkWeight = this.homework.getWeight();
        spinnerWeight.setValue(homeworkWeight.getWeight());
        checkBoxPercent.setSelected(homeworkWeight.IsPercentage());
    }
    
    public Homework getHomework() {
        if(hasHomework())
            return this.homework;
        
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spinnerWeight = new javax.swing.JSpinner();
        labelWeight = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        labelCourse = new javax.swing.JLabel();
        formattedTextFieldDueDate = new javax.swing.JFormattedTextField();
        labelDueDate = new javax.swing.JLabel();
        spinnerTimeToSpend = new javax.swing.JSpinner();
        labelTimeToSpend = new javax.swing.JLabel();
        textFieldCourse = new javax.swing.JTextField();
        checkBoxPercent = new javax.swing.JCheckBox();
        labelDescription = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();
        panelDialogControls = new javax.swing.JPanel();
        buttonCancel = new javax.swing.JButton();
        buttonSubmitHomework = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        spinnerWeight.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelWeight.setText("Weight (Credits) :");

        labelName.setText("Name: *");

        labelCourse.setText("Course: *");

        try {
            formattedTextFieldDueDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelDueDate.setText("Due Date: *");

        spinnerTimeToSpend.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTimeToSpend.setText("Time to Spend (In Days) :");

        checkBoxPercent.setText("Percentage");

        labelDescription.setText("Description:");

        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        scrollPane.setViewportView(textAreaDescription);

        buttonCancel.setText("Cancel");
        buttonCancel.setMaximumSize(new java.awt.Dimension(128, 28));
        buttonCancel.setMinimumSize(new java.awt.Dimension(128, 28));
        buttonCancel.setPreferredSize(new java.awt.Dimension(128, 28));
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonSubmitHomework.setText("Submit");
        buttonSubmitHomework.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitHomeworkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDialogControlsLayout = new javax.swing.GroupLayout(panelDialogControls);
        panelDialogControls.setLayout(panelDialogControlsLayout);
        panelDialogControlsLayout.setHorizontalGroup(
            panelDialogControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogControlsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSubmitHomework, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDialogControlsLayout.setVerticalGroup(
            panelDialogControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogControlsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDialogControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSubmitHomework))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDialogControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTimeToSpend, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(labelDueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkBoxPercent))
                                    .addComponent(spinnerTimeToSpend, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formattedTextFieldDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(labelCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldName)
                                    .addComponent(textFieldCourse)
                                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCourse)
                    .addComponent(textFieldCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formattedTextFieldDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDueDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTimeToSpend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTimeToSpend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWeight)
                    .addComponent(checkBoxPercent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(panelDialogControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.homework = null;
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonSubmitHomeworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitHomeworkActionPerformed
        boolean validInput = true;
        
        if(textFieldName.getText().trim().equals("")) {
            validInput = false;
        }
        
        if(textFieldCourse.getText().trim().equals("")) {
            validInput = false;
        }
        
        if(formattedTextFieldDueDate.getValue() == null) {
            validInput = false;
        }
        
        if(!validInput) {
            JOptionPane.showMessageDialog(this, "Required field(s) are empty, chech your input", "Missing Input(s)", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            formattedTextFieldDueDate.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(HomeworkDialog.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(this, "Due date format error, check your input", "Format Error", JOptionPane.ERROR_MESSAGE);
            formattedTextFieldDueDate.requestFocus();
            return;
        }
        
        String formattedDueDate = (String) formattedTextFieldDueDate.getValue();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dueDate;
        
        try {
            dueDate = sdf.parse(formattedDueDate);
        } catch (ParseException ex) {
            Logger.getLogger(HomeworkDialog.class.getName()).log(Level.SEVERE, null, ex);
                        
            JOptionPane.showMessageDialog(this, "Due date format error, check your input\n\nHint: Format is dd-MM-yyyy\n\nFor example: 30-05-2023", "Format Error", JOptionPane.ERROR_MESSAGE);
            formattedTextFieldDueDate.requestFocus();
            return;
        }
        
        HomeworkWeight weight = new HomeworkWeight((int) spinnerWeight.getValue(), checkBoxPercent.isSelected());
        
        if(hasHomework()) {
            boolean changed = false;

            changed = !(this.homework.getName().equals(textFieldName.getText()));
            changed = !this.homework.getCourse().equals(textFieldCourse.getText());
            changed = !this.homework.getDescription().equals(textAreaDescription.getText());

            Calendar currentDate = Calendar.getInstance();
            currentDate.setTime(this.homework.getDueDate());

            Calendar newDate = Calendar.getInstance();
            newDate.setTime(dueDate);

            changed = !(currentDate.get(Calendar.DAY_OF_YEAR) == newDate.get(Calendar.DAY_OF_YEAR) &&
                        currentDate.get(Calendar.YEAR) == newDate.get(Calendar.YEAR));

            changed = !(this.homework.getTimeToSpend() == ((int) spinnerTimeToSpend.getValue()));
            changed = !this.homework.getWeight().equals(weight);

            if(!changed) {
                this.homework = null;
                return;
            }
        }

        if(hasHomework()) {
            this.homework.setName(textFieldName.getText());
            this.homework.setCourse(textFieldCourse.getText());
            this.homework.setDescription(textAreaDescription.getText());
            this.homework.setDueDate(dueDate);
            this.homework.setTimeToSpend((int) spinnerTimeToSpend.getValue());
            this.homework.setWeight(weight);
        }
        else {
            this.homework = new Homework(
                textFieldName.getText(),
                textFieldCourse.getText(),
                textAreaDescription.getText(),
                dueDate,
                (int) spinnerTimeToSpend.getValue(),
                weight
            );
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_buttonSubmitHomeworkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSubmitHomework;
    private javax.swing.JCheckBox checkBoxPercent;
    private javax.swing.JFormattedTextField formattedTextFieldDueDate;
    private javax.swing.JLabel labelCourse;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelDueDate;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTimeToSpend;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JPanel panelDialogControls;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSpinner spinnerTimeToSpend;
    private javax.swing.JSpinner spinnerWeight;
    private javax.swing.JTextArea textAreaDescription;
    private javax.swing.JTextField textFieldCourse;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables
}