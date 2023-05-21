package com.example.crudoperations;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TodoList implements Serializable {
    @SerializedName("_id")
    public String id;
    public String name;
    public String imageUrl;
}
