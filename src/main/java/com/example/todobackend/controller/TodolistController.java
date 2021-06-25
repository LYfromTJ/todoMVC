package com.example.todobackend.controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PutMapping;

import com.example.todobackend.entity.Todolist;
import com.example.todobackend.repository.TodoRepository;
import com.example.todobackend.repository.TodolistRepository;


@Controller
@RequestMapping("/todolist")
public class TodolistController {
	@Autowired
	private TodolistRepository todolistRepository;
	@Autowired
	private TodoRepository todoRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewTodolist (@RequestParam String name) {
//		Optional<Todolist> otl=todolistRepository.findById(name);
//		if(otl.isPresent()) {
//			return "Todolist already exist";
//		}
//		else {
//			Todolist tl = new Todolist();
//			tl.setName(name);
//			todolistRepository.save(tl);
//			return "Todolist saved";
//		}
		
		Todolist tl = new Todolist();
		tl.setName(name);
		todolistRepository.save(tl);
		return "Saved";
		
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Todolist> getAllTodolist(){
		return todolistRepository.findAll();
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody String deleteTodolist(@RequestParam String name) {
//		Optional<Todolist> otl=todolistRepository.findById(name);
//		if(otl.isPresent()) {
//			todolistRepository.deleteById(name);
//			return "Deleted";
//		}
//		else {
//			return "Unknown todolist name";
//		}
		todoRepository.deleteAll(todoRepository.findByTodolist(name));
		todolistRepository.deleteById(name);
		return "Deleted";
	}
	
	
//	@PutMapping(path="set")
//	public @ResponseBody String setTodolist(@RequestParam String name,
//			@RequestParam String newname) {
//		Optional<Todolist> otl=todolistRepository.findById(name);
//		if(otl.isPresent()) {
//			Todolist tl=otl.get();
//			tl.setName(newname);
//			todolistRepository.save(tl);
//			return "Saved";
//		}
//		else {
//			return "No such todolist";
//		}
//	}
}
