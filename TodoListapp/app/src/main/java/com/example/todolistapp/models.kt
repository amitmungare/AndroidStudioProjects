package com.example.todolistapp

 data class  Todo(var task:String, var done:Boolean){
      override fun toString(): String {
       return this.task
      }
 }