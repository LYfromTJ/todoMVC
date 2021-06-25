package com.example.todobackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.todobackend.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer>{
	@Query(value="select * from todo where listid = ?1",nativeQuery=true)
	Iterable<Todo> findByTodolist(String listid);
}
