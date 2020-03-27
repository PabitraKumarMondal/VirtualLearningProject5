package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao dao;
	
	@Override
	public String insert(Student s) {
		return dao.insert(s);
	}

	@Override
	public String update(Student s) {
		return dao.update(s);
	}

	@Override
	public String delete(Student s) {
		return dao.delete(s);
	}

	@Override
	public int countStudent() {
		return dao.countStudent();
	}

	@Override
	public List<Student> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Student> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Student findById(int id) {
		return dao.findById(id);
	}

}
