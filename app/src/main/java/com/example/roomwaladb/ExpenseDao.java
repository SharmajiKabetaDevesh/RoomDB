package com.example.roomwaladb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {
    @Query("select * from expense")
    List<Expense> getAllExpense();


    @Insert
    void addTransaction(Expense expense);


    @Update
    void updateTx(Expense expense);

    @Delete
    void deleteTx(Expense expense);



}
