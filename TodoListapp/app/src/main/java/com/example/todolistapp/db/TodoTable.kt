package com.example.todolistapp.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.todolistapp.Todo

object TodoTable{
    val TABLE_NAME = "todos"
    object Colums{
        val ID = "id"
        val TASK = "task"
        val DONE = "done"
    }

    val CMD_CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS $TABLE_NAME(
        ${Colums.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Colums.TASK} TEXT,
        ${Colums.DONE} BOOLEAN
        );
    """.trimIndent()

    fun insertTodo(db: SQLiteDatabase, todo: Todo){
        val row = ContentValues()
        row.put(Colums.TASK, todo.task)
        row.put(Colums.DONE, todo.done)

        db.insert(TABLE_NAME,null,row)
    }

    fun getAllTodos(db: SQLiteDatabase): ArrayList<Todo>{
        val todos = ArrayList<Todo>()
        var c = db.query(
            TABLE_NAME,
            arrayOf(Colums.ID , Colums.TASK , Colums.DONE),
            null,null,null,null,null
        )

        while (c.moveToNext()){
            val todo = Todo(c.getString(1), c.getInt(2)==1)
            todos.add(todo)
        }
        return todos

    }


}

