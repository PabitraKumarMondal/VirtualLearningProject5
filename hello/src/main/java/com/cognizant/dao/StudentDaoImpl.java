package com.cognizant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate2;
	
	@Override
	public String insert(Student s) {
		int row = jdbcTemplate.update("INSERT INTO student VALUES(?, ?, ?)", s.getId(), s.getName(), s.getMarks());
		if (row > 0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String update(Student s) {
		int row = jdbcTemplate.update("UPDATE student SET name=?, marks=? WHERE id=?", s.getName(), s.getMarks(), s.getId());
		if (row > 0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String delete(Student s) {
		int row = jdbcTemplate.update("DELETE FROM student WHERE id=?", s.getId());
		if (row > 0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public int countStudent() {
		return this.findAll().size();
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = jdbcTemplate.query("SELECT * FROM student", 
				(rs,rowNum) -> new Student(rs.getInt(1),rs.getString(2),rs.getInt(3))
				);
		return students;
	}

	@Override
	public List<Student> findByName(String name) {
		Map<String, Object> params = new HashMap<>();
	    params.put("name", name);
		List<Student> students = jdbcTemplate2.query("SELECT * FROM student where name=:name", params,
				(rs,rowNum) -> new Student(rs.getInt(1),rs.getString(2),rs.getInt(3))
				);
		return students;
	}

	@Override
	public Student findById(int id) {
		List<Student> list= this.findAll();
		for (Student student : list) {
			if(student.getId()==id)
				return student;
		}				
		return null;
	}

}
