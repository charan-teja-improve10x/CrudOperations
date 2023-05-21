package com.example.crudoperations;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends BaseAddEditActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleAddBtn();
    }

    private void handleAddBtn() {
        binding.addBtn.setOnClickListener(v -> {
           Call<TodoList> call =  apiInterface.createTodoListItem(setTodoList());
           call.enqueue(new Callback<TodoList>() {
               @Override
               public void onResponse(Call<TodoList> call, Response<TodoList> response) {
                   Toast.makeText(AddActivity.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
                   finish();
               }

               @Override
               public void onFailure(Call<TodoList> call, Throwable t) {
                   Toast.makeText(AddActivity.this, "failed", Toast.LENGTH_SHORT).show();
               }
           });
        });
    }
}
