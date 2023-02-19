package com.thymeleaf.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskModel {

    private Long id;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss") // devo avisar ao thymeleaf la na lista por padão mais uma {}
    private Date date;

    public TaskModel (Long id, String name, Date date){
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public TaskModel(){

    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}
