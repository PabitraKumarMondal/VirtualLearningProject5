package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertPage() {

		return "insert";

	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		// Read the request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int marks = Integer.parseInt(request.getParameter("marks"));
		// Create the student
		Student student = new Student(id, name,marks);
		System.out.println(student);
		// insert student to db

		String res = studentService.insert(student);

		if (res.equals("SUCCESS"))
			request.setAttribute("msg", "Record Inserted");
		else
			request.setAttribute("msg", "Record Not Inserted");
		return "insert";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update() {
		return "update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		// Read the request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int marks = Integer.parseInt(request.getParameter("marks"));
		// Create the student
		Student student = new Student(id, name,marks);
		System.out.println(student);
		// insert student to db

		String res = studentService.update(student);

		if (res.equals("SUCCESS"))
			request.setAttribute("msg", "Record Updated");
		else
			request.setAttribute("msg", "Record Not Updated");
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete() {
		return "delete";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		// Read the request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		// Create the student
		Student student = studentService.findById(id);
		System.out.println(student);
		// insert student to db

		String res = studentService.delete(student);

		if (res.equals("SUCCESS"))
			request.setAttribute("msg", "Record Deleted");
		else
			request.setAttribute("msg", "Record Not Deleted");
		return "delete";
	}
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll(HttpServletRequest request) {
		List<Student> list = studentService.findAll();
		System.out.println(list);
		request.setAttribute("list", list);
		return "display";
	}
	
	@RequestMapping(value = "findByName", method = RequestMethod.GET)
	public String findByName() {
		
		return "findByName";
	}
	
	@RequestMapping(value = "findByName", method = RequestMethod.POST)
	public String findByName(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println(name);
		List<Student> list = studentService.findByName(name);
		System.out.println(list);
		request.setAttribute("list", list);
		return "display";
	}
	
	@RequestMapping(value = "findById", method = RequestMethod.GET)
	public String findById() {
		
		return "findById";
	}
	
	@RequestMapping(value = "findByIdView", method = RequestMethod.POST)
	public String findById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Student st = studentService.findById(id);
		System.out.println(st);
		request.setAttribute("student", st);
		return "findByIdView";
	}
	
	@RequestMapping(value = "countStudent", method = RequestMethod.GET)
	public String countStudent(HttpServletRequest request) {
		List<Student> list = studentService.findAll();
		System.out.println(list.size());
		request.setAttribute("total", list.size());
		return "count";
	}

}