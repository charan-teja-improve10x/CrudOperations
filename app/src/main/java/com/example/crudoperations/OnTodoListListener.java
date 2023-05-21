package com.example.crudoperations;

public interface OnTodoListListener {

    void onDelete(String id);

    void onEdit(TodoList item);
}
