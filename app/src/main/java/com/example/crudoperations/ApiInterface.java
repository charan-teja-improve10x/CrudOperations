package com.example.crudoperations;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("charanTaskListItem")
    Call<TodoList[]> getTodoListItems();

    @POST("charanTaskListItem")
    Call<TodoList> createTodoListItem(@Body TodoList todoList);

    @DELETE("charanTaskListItem/{id}")
    Call<Void> deleteTodoListItem(@Path("id") String id);

    @PUT("charanTaskListItem/{id}")
    Call<Void> editTodoListItem(@Path("id") String id,@Body TodoList item);
}
