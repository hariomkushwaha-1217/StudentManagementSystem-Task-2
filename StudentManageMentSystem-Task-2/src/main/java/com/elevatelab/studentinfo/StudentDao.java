package com.elevatelab.studentinfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager man=fac.createEntityManager();
	EntityTransaction tran=man.getTransaction();
	
	public Student addStudent(Student st) {
		tran.begin();
		man.persist(st);
		tran.commit();
		return st;
	}

	public Student uqdateStudent(int id,Student st) {
	    tran.begin();
	    Student mdb=man.find(Student.class,id);
	    if (mdb!=null) {
	        mdb.setName(st.getName());
	        mdb.setMarks(st.getMarks());
	        mdb.setPhone(st.getPhone());
	        mdb.setEmail(st.getEmail());
	        tran.commit();
	        return mdb;
	    }
	    else 
	        return null;
	}

	public Student viewStudent(int sid) {
		Query q=man.createQuery("select s from Student s where s.id=?1");
		q.setParameter(1, sid);
		try {
			Student m=(Student)q.getSingleResult();
			return m;
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public Student deleteStudent(int sid) {
	    try {
	        Student student=man.find(Student.class,sid);
	        if (student!=null) {
	            tran.begin();
	            man.remove(student);
	            tran.commit();
	            return student;
	        } else
	            return null;
	    } 
	    catch (NoResultException e) {
	        return null;
	    }
	}
}
