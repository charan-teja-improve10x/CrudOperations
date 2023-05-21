package com.example.crudoperations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends BaseAddEditActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        TodoList todoList = (TodoList) intent.getSerializableExtra("item");
        setData(todoList);
        handleEditBtn(todoList.id);
    }

    private void setData(TodoList todoList) {
        binding.nameTxt.setText(todoList.name);
        binding.imageUrlTxt.setText(todoList.imageUrl);
    }

    private void handleEditBtn(String id) {
        binding.editBtn.setOnClickListener(v -> {
            Call<Void> call =  apiInterface.editTodoListItem(id,setTodoList());
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(EditActivity.this, "Item Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(EditActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
