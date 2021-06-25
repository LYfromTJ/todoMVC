package com.example.todobackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.todobackend.entity.Todolist;

import java.util.List;

public interface TodolistRepository extends CrudRepository<Todolist,String>{
}
