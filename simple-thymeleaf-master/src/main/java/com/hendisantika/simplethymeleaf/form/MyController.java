
package com.hendisantika.simplethymeleaf.form;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;  



@Controller
public class MyController {
	 ModelAndView modelAndView = new ModelAndView();
	    @RequestMapping("/")  
	    public String mainmenu(){  
	        return"mainmenu";  
	    } 
	    @RequestMapping(value="/student")  
	    public String hi(){ 
	    	return "index";
	    	
	    }
	    
@RequestMapping(value="/save", method=RequestMethod.POST)  
public ModelAndView save(@ModelAttribute Student student){  
	 
	
	
		
	
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();           

        StudentRegistration.getInstance().add(student);

        //We are setting the below value just to reply a message back to the caller
        stdregreply.setName(student.getName());
        stdregreply.setAge(student.getAge());
        stdregreply.setRegistrationNumber(student.getRegistrationNumber());
        stdregreply.setRegistrationStatus("Successful");
    	modelAndView.setViewName("save"); 
        return modelAndView;
        
        
	}



	
	@RequestMapping( value="/display")
	public String display ()
	{
		return "getid"; 
	}
	@RequestMapping(method = RequestMethod.POST , value="/show")
	public ModelAndView show(@ModelAttribute Student student) {
		int a=0;
		List <Student> stu=StudentRegistration.getInstance().getStudentRecords();
		for (int i=0;i<stu.size();i++)
		{
			if (stu.get(i).name.equalsIgnoreCase(student.name))
			{
				 modelAndView.addObject("student", stu.get(i));
				 a=1;
				 break;
			}}
			if (a==1)
			{
				modelAndView.setViewName("user-data"); 
			}
			else if (a==0)
			{
				modelAndView.setViewName("user-data1"); 
			}
		
		
		return modelAndView;
		
		
	}


	@RequestMapping( value="/update")
	public String update ()
	{
		return "getchange"; 
	}
	@RequestMapping(method = RequestMethod.POST , value="/update1")
	public ModelAndView update1(@ModelAttribute Student student) {
		
		
		
				String s=StudentRegistration.getInstance().upDateStudent(student.name,student.age);	
			
			if (s.equals("Update successful"))
			{
				modelAndView.setViewName("update"); 
			}
			else if (s.equals("Update un-successful"))
			{
				modelAndView.setViewName("getchange1"); 
			}
		
		
		return modelAndView;
		
		
	}

	@RequestMapping( value="/delete")
	public String delete ()
	{
		return "delete"; 
	}
	@RequestMapping(method = RequestMethod.POST , value="/delete1")
	public ModelAndView delete1(@ModelAttribute Student student) {
		String s=StudentRegistration.getInstance().deleteStudent(student.name);
		
		if (s.equals("Delete successful"))
		{
			modelAndView.setViewName("getdelete"); 
		}
		else if (s.equals("Delete un-successful"))
		{
			modelAndView.setViewName("getdelete1"); 
		}
	
	
	return modelAndView;
	
	
}

}
