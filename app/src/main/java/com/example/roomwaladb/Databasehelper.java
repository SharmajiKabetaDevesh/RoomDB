package com.example.roomwaladb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = Expense.class,version = 1,exportSchema = false)
public abstract class Databasehelper extends RoomDatabase {
    private static final String DB_name="expensedb";
private static Databasehelper instance;



public static synchronized Databasehelper getDB(Context context){
if(instance==null){
    instance=Room.databaseBuilder(context,Databasehelper.class,DB_name)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build();
}
return instance;



}
public abstract ExpenseDao expenseDao();
}
