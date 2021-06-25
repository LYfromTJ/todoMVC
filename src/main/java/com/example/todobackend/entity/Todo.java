package com.example.todobackend.entity;

//import com.example.todobackend.entity.Todolist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity 
@EntityListeners(AuditingEntityListener.class)
public class Todo {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(nullable=false,length=50)
  private String header;

  @Column(nullable=false)
  private String content;
  
  @Column(nullable=false)
  private Boolean done;
  
  @Column(nullable=true)
  @Temporal(TemporalType.DATE)
  private Date finishtime;
  
  @CreatedDate
  @Column(nullable=false)
  @Temporal(TemporalType.DATE)
  private Date createtime;

  @ManyToOne
  @JoinColumn(name="listid")
  private Todolist todolist;




  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  
  public Boolean getDone() {
	  return done;
  }
  
  public void setDone(Boolean done) {
	  this.done=done;
  }
  
  public Date getFinishtime() {
	return finishtime;
  }

  public void setFinishtime(Date finishtime) {
	this.finishtime = finishtime;
  }
  
  public Date getCreatetime() {
	  return createtime;
  }
  
  public void setCreatetime(Date createtime) {
	  this.createtime=createtime;
  }
  
  public Todolist getTodolist() {
	return todolist;
  }

  public void setTodolist(Todolist todolist) {
	this.todolist = todolist;
  }
}