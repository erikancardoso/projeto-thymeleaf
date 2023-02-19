package com.thymeleaf.layout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thymeleaf.model.TaskModel;

@Controller
public class TaskController {
    
    List<TaskModel> tasks = new ArrayList<>(); //lista para guardar as informações do form, depois passar para o banco de dados
    //criando rota para acessar o html
    @GetMapping("/create")
    public String home(){
        return "create"; //deve ser o mesmo nome do arquivo html
    }
    @PostMapping("/create")
    public String create(TaskModel task){
        Long id= tasks.size() + 1L; //organizar por id dentro da lista tasks
        tasks.add(new TaskModel(id, task.getName(), task.getDate()));
        //System.out.println("O nome da tarefa é " + task.getName());
        return "redirect:/list"; //redirect chama a url que deve chamar
    }
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("list"); // retornando atributos para o objeto, fazendo um mapeamento da classe com os objetos em html
        mv.addObject("tasks", tasks);// passar um objeto que são as minhas tasks (chave, valor)
        return mv;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("create");
        TaskModel taskFind = tasks.stream().filter(task -> id.equals(task.getId())).findFirst().get();
         mv.addObject("task", taskFind); 
         return mv;

    }
}
