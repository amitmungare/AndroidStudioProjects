package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.todolistapp.db.MyDbHelper
import com.example.todolistapp.db.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoAdapter = ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        val db = MyDbHelper(this).writableDatabase

        fun refreshTodoList(){
            val todoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }

        lvtodos.adapter = todoAdapter
        refreshTodoList()

        btnadd.setOnClickListener {
            val newtodo = Todo(etnewtodo.text.toString(), false)

            TodoTable.insertTodo(db,newtodo)
            refreshTodoList()
        }

    }


}
















