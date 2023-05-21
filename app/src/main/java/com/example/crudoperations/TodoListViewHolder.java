package com.example.crudoperations;

import androidx.recyclerview.widget.RecyclerView;

import com.example.crudoperations.databinding.TodoListItemBinding;

public class TodoListViewHolder extends RecyclerView.ViewHolder {
    TodoListItemBinding binding;

    public TodoListViewHolder(TodoListItemBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }
}
