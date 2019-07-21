package com.hendisantika.simplethymeleaf.form;

import java.util.ArrayList; 
import java.util.List;



public class StudentRegistration {
	
	private List<Student> studentRecords;
	
	private static StudentRegistration stdregd = null;
	
	private StudentRegistration(){
		studentRecords = new ArrayList<Student>();
	}
	
	public static StudentRegistration getInstance() {
		
		if(stdregd == null) {
			stdregd = new StudentRegistration();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}
	
	public void add(Student std) {
		studentRecords.add(std);
	}
public String upDateStudent(String name,String age) {
		
		for(int i=0; i<studentRecords.size(); i++)
        {
			if (studentRecords.get(i).name.equalsIgnoreCase(name))
			{
				Student stdn = studentRecords.get(i);
			
            	stdn.setAge(age);
            	return "Update successful";
            }
        }
		
		return "Update un-successful";
		
	}
	
	public String deleteStudent(String name) {
		
		for(int i=0; i<studentRecords.size(); i++)
        {
            Student stdn = studentRecords.get(i);
            if(stdn.getName().equals(name)) {
            	studentRecords.remove(i);//update the new record
            	return "Delete successful";
            }
        }
		
		return "Delete un-successful";
		
	}


	public List<Student> getStudentRecords() {
		return studentRecords;
	}

}
