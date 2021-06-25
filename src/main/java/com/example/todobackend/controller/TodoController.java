package com.example.todobackend.controller;

import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.todobackend.entity.Todo;
import com.example.todobackend.entity.Todolist;
import com.example.todobackend.repository.TodoRepository;
import com.example.todobackend.repository.TodolistRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private TodolistRepository todolistRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewTodo (@RequestParam String header
	      , @RequestParam String content, @RequestParam String finishtime,
	      @RequestParam String listid) {
		
		//TODO: exception process
		Todolist tl = todolistRepository.findById(listid).get();
		
		Todo t= new Todo();
		t.setHeader(header);
		t.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			t.setFinishtime(sdf.parse(finishtime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.setDone(false);
		t.setTodolist(tl);
		todoRepository.save(t);
		
	    return "Saved";
	}
	
	 @GetMapping(path="/find")
	 public @ResponseBody Iterable<Todo> findByListid(@RequestParam String listid){
		 return todoRepository.findByTodolist(listid);
	 }
	 
	 @DeleteMapping(path="/delete")
	 public @ResponseBody String deleteById(@RequestParam Integer Id) {
		 //TODO exception
		 todoRepository.deleteById(Id);
		 return "Deleted";
	 }
	 
	 @PutMapping(path="/set")
	 public @ResponseBody String set(@RequestParam Integer Id, @RequestParam String header,
			 @RequestParam String content, @RequestParam String finishtime,
			 @RequestParam String listid) {
		 //TODO exception
		 Todo t = todoRepository.findById(Id).get();
		 
		 //TODO: exception process
		 Todolist tl = todolistRepository.findById(listid).get();
		 
		 t.setHeader(header);
		 t.setContent(content);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			t.setFinishtime(sdf.parse(finishtime));
		 } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 t.setTodolist(tl);
		 todoRepository.save(t);
		 return "Changed";
	 }
	 
	 @PutMapping(path="/done")
	 public @ResponseBody String setDone(@RequestParam Integer Id) {
		//TODO exception
		 Todo t = todoRepository.findById(Id).get();
		 t.setDone(true);
		 todoRepository.save(t);
		 return "Done";
	 }
	 
	 @PutMapping(path="/undone")
	 public @ResponseBody String setUndone(@RequestParam Integer Id) {
		//TODO exception
		 Todo t = todoRepository.findById(Id).get();
		 t.setDone(false);
		 todoRepository.save(t);
		 return "Undone";
	 }
}
