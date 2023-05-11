/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fsc.cshms.homework;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 *
 * @author user
 */

public class Homework implements Serializable {

    private String name;
    
    private String course;
    
    private String description;
    
    private Date dueDate;
    
    private int timeToSpend;    // in Days
    
    private HomeworkWeight weight;
    
    private boolean complete;
    
    
    public Homework(String name, String course, String description, Date dueDate, int timeToSpend, HomeworkWeight weight) {
        this.name = name;
        this.course = course;
        this.description = description;
        this.dueDate = dueDate;
        this.timeToSpend = timeToSpend;
        this.weight = weight;
        this.complete = false;
    }
    
    
    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    

    public String getCourse() {
        return course;
    }
    

    public void setCourse(String course) {
        this.course = course;
    }
    
    
    public String getDescription() {
        return description;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }
    

    public Date getDueDate() {
        return dueDate;
    }
    

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    

    public int getTimeToSpend() {
        return timeToSpend;
    }
    

    public void setTimeToSpend(int timeToSpend) {
        this.timeToSpend = timeToSpend;
    }
    
    public HomeworkWeight getWeight() {
        return weight;
    }
    

    public void setWeight(HomeworkWeight weight) {
        this.weight = weight;
    }
    
    
    public boolean IsComplete() {
        return complete;
    }
    

    public void setAsCompleted() {
        this.complete = true;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o.getClass() != Homework.class)
            return false;
        
        Homework oHomework = (Homework) o;
        
        boolean equal;
        
        equal = oHomework.getName().equalsIgnoreCase(getName());
        
        if(!equal)
            return equal;
        
        equal = (oHomework.IsComplete() == IsComplete());
        
        return equal;
    }
    
    public Vector<Object> toVector() {
        Vector<Object> asVector = new Vector<Object>();
        asVector.add(this.getName());
        asVector.add(this.getCourse());
        asVector.add(this.getDescription());
        asVector.add(this.getDueDate().toString());
        asVector.add(this.getTimeToSpend());
        asVector.add(this.getWeight().toString());
        asVector.add(new CompleteStatus(this.IsComplete()));
        
        return asVector;
    }
    
    public final static List<String> getFieldColumnNames() {
        return (List<String>) Arrays.asList(new String[]{
            "Name", "Couse", "Description", "Due Date", "Time To Spend", "Weight", "Status"
        });
    }
    
    public final static Class[] getFieldClassTypes() {
        return new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
    }
    
    public final static boolean[] getFieldEditable() {
        return new boolean [] {
                false, false, false, false, false, false, false
            };
    }
    
    public final static String[] getFieldSearchBy() {
        return new String[] { "Due In (Days)", "Course" };
    }
    
    public static LinkedList<Homework> searchBy(String field, boolean excludeCompleted, ListIterator<Homework> listIterator, Object... args) {
        if(field.equals("Due In (Days)")) {
            return searchByDaysFromDueDate(args[0].getClass() == String.class ? Integer.parseInt((String) args[0]) : (int) args[0], listIterator, excludeCompleted);
        } else if (field.equals("Course")) {
            return searchByCourse(args[0].getClass() == String.class ? (String) args[0] : args[0].toString(), listIterator, excludeCompleted);
        }
        
        throw new IllegalArgumentException("Unknown search field " + field);
    }
    
    private static LinkedList<Homework> searchByDaysFromDueDate(int value, ListIterator<Homework> listIterator, boolean excludeCompleted) {
        LinkedList<Homework> homeworks = new LinkedList<Homework>();
        
        if(listIterator.hasNext()) {
            Homework homework = listIterator.next();
            
            Calendar today = Calendar.getInstance();
            today.setTime(new Date());
            
            Calendar dueInCalendar = Calendar.getInstance();
            dueInCalendar.setTime(homework.getDueDate());
            dueInCalendar.add(Calendar.DAY_OF_MONTH, (-1) * value);
                        
            if((today.get(Calendar.DAY_OF_YEAR) == dueInCalendar.get(Calendar.DAY_OF_YEAR) &&
                today.get(Calendar.YEAR) == dueInCalendar.get(Calendar.YEAR)) &&
                !(homework.IsComplete() && excludeCompleted))
                homeworks.add(homework);
                
            homeworks.addAll(searchByDaysFromDueDate(value, listIterator, excludeCompleted));
        }
        
        return homeworks;
    }
    
    private static LinkedList<Homework> searchByCourse(String course, ListIterator<Homework> listIterator, boolean excludeCompleted) {
        LinkedList<Homework> homeworks = new LinkedList<Homework>();
        
        if(listIterator.hasNext()) {
            Homework homework = listIterator.next();
            
            if(homework.getCourse().equalsIgnoreCase(course) && !(homework.IsComplete() && excludeCompleted))
                homeworks.add(homework);
                
            homeworks.addAll(searchByCourse(course, listIterator, excludeCompleted));
        }
        
        return homeworks;
    }
    
}
