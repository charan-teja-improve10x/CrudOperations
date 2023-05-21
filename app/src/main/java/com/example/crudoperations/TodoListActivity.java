package com.example.crudoperations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.crudoperations.databinding.ActivityTodoListBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoListActivity extends AppCompatActivity implements OnTodoListListener{

    ActivityTodoListBinding binding;
    TodoList[] todoLists = new TodoList[0];
    TodoListItemsAdapter todoListItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        connectAdapter();
        handleFabButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTodoItem();
    }

    private void setupAdapter() {
        todoListItemsAdapter = new TodoListItemsAdapter(todoLists);
        todoListItemsAdapter.createTodoItemListener(this);
    }

    private void connectAdapter() {
        binding.todolistRv.setLayoutManager(new LinearLayoutManager(this));
        binding.todolistRv.setAdapter(todoListItemsAdapter);

    }

    private void handleFabButton() {
      binding.fabIb.setOnClickListener(v -> {
          Intent intent = new Intent(this,AddActivity.class);
          startActivity(intent);
      });
    }
    private void getTodoItem(){
        ApiInterface apiInterface = new TodoListApi().createApiInterface();
        Call<TodoList[]> call = apiInterface.getTodoListItems();
        call.enqueue(new Callback<TodoList[]>() {
            @Override
            public void onResponse(Call<TodoList[]> call, Response<TodoList[]> response) {
                Toast.makeText(TodoListActivity.this, "Size =  " + response.body() , Toast.LENGTH_SHORT).show();
                todoListItemsAdapter.createTodoListObject(response.body());
            }

            @Override
            public void onFailure(Call<TodoList[]> call, Throwable t) {
                Toast.makeText(TodoListActivity.this, "Get Items Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void deleteTaskListItem(String id) {
        ApiInterface apiInterface = new TodoListApi().createApiInterface();
        Call<Void> call = apiInterface.deleteTodoListItem(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                getTodoItem();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDelete(String id) {
        deleteTaskListItem(id);
    }

    @Override
    public void onEdit(TodoList item) {
        Intent intent = new Intent(this,EditActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);

    }
}