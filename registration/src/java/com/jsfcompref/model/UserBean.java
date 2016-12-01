package com.jsfcompref.model;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class UserBean {
    
    protected String firstName;
    protected String lastName;
    protected Date dob;
    protected String sex;
    protected String email;
    protected String serviceLevel = "medium";

    public UserBean() {
        System.out.println("Constructor");
    }

    public String getFirstName() {
        System.out.println("getFirstName");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("setFirstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }
    
    public void validateEmail(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        System.out.println("Validating email...");
        String emailStr = (String) value;
        if (-1 == emailStr.indexOf("@")) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

    public String addConfirmedUser() {
        System.out.println("Saving user's data..." + this);
	boolean added = true; // actual application may fail to add user
	FacesMessage doneMessage = null;
	String outcome = null;
	if (added) {
	    doneMessage = new FacesMessage("Successfully added new user");
	    outcome = "done";
	} else {
	    doneMessage = new FacesMessage("Failed to add new user");
	    outcome = "register";
	}
        FacesContext.getCurrentInstance().addMessage(null, doneMessage);
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Other Message"));
        return outcome; // + .xhtml
    }

    @Override
    public String toString() {
        return "UserBean{" + "firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", sex=" + sex + ", email=" + email + ", serviceLevel=" + serviceLevel + '}';
    }
   
    
}
