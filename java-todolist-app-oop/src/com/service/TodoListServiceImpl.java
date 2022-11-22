package com.service;

import com.entity.Todolist;
import com.repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;

    }

    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todolist = model[i];
            var no = i+1;

            if (todolist != null){
                System.out.println(no + ". "+todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses menambah todo: "+todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean isDelete = todoListRepository.remove(number);
        if (isDelete){
            System.out.println("Sukses menghapus todo: "+number);
        }else{
            System.out.println("Gagal menghapus todo: "+number);
        }
    }
}