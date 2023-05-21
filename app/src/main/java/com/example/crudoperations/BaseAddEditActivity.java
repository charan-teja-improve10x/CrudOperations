package com.example.crudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.crudoperations.databinding.ActivityBaseAddEditBinding;

public class BaseAddEditActivity extends AppCompatActivity {

    protected ActivityBaseAddEditBinding binding;
    protected ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseAddEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createTodoInterface();
    }

    protected void createTodoInterface() {
        apiInterface = new TodoListApi().createApiInterface();
    }

    public TodoList setTodoList() {
        TodoList todoList = new TodoList();
        todoList.name = binding.nameTxt.getText().toString();
        todoList.imageUrl = binding.imageUrlTxt.getText().toString();
        return todoList;
    }
}