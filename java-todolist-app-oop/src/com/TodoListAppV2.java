package com;

import com.repository.TodoListRepository;
import com.repository.TodoListRepositoryImpl;
import com.service.TodoListService;
import com.service.TodoListServiceImpl;
import com.view.TodoListView;

public class TodoListAppV2 {
    public static void main(String[] args) {
     TodoListRepository todoListRepository = new TodoListRepositoryImpl();
     TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
     TodoListView todoListView = new TodoListView(todoListService);

     todoListView.showTodoList();
    }

}
