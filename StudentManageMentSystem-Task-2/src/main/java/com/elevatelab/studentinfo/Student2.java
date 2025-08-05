package com.elevatelab.studentinfo;

public class Student2 {
    private int id;
    private String name;
    private double marks;
    private long phone;
    private String email;
   
    public Student2() {}

    public Student2(int id,String name,double marks,long phone,String email) {
        this.id=id;
        this.name=name;
        this.marks=marks;
        this.phone=phone;
        this.email=email;     
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", marks=" + marks + ", phone=" + phone + ", email=" + email
				+ "]";
	}
}

