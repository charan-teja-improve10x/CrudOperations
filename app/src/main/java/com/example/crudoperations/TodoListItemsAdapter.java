package com.example.crudoperations;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudoperations.databinding.TodoListItemBinding;
import com.squareup.picasso.Picasso;

public class TodoListItemsAdapter extends RecyclerView.Adapter<TodoListViewHolder> {

    TodoList[] items;
    OnTodoListListener listener;

    public TodoListItemsAdapter(TodoList[] todoLists) {
        items = todoLists;
    }

    void createTodoListObject(TodoList[] items) {
        this.items = items;
        notifyDataSetChanged();
    }

    void createTodoItemListener(OnTodoListListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TodoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TodoListItemBinding binding = TodoListItemBinding.inflate(inflater, parent, false);
        TodoListViewHolder viewHolder = new TodoListViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListViewHolder holder, int position) {
        TodoList item = items[position];
        holder.binding.taskNameTxt.setText(item.name);
        Picasso.get().load(item.imageUrl).into(holder.binding.imageIv);
        holder.binding.deleteIb.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Delete Button is Clicked", Toast.LENGTH_SHORT).show();
            listener.onDelete(item.id);
        });

        holder.binding.editIb.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Edit Button is Clicked", Toast.LENGTH_SHORT).show();
            listener.onEdit(item);
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
