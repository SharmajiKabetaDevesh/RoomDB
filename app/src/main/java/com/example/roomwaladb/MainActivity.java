package com.example.roomwaladb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText forWhat,amt;
Button But;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forWhat.findViewById(R.id.forwhat);
        amt=findViewById(R.id.amt);
        But=findViewById(R.id.But);
        Databasehelper databasehelper=Databasehelper.getDB(MainActivity.this);
        But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = forWhat.getText().toString();
                String amount=amt.getText().toString();
                databasehelper.expenseDao().addTransaction(new Expense(title,amount));

            }
        });

        ArrayList<Expense>  arrexpenses = (ArrayList)databasehelper.expenseDao().getAllExpense();
for (int i =0;i<arrexpenses.size();i++){
    Log.d("Title"+arrexpenses.get(i).getTitle(),"ampunt"+arrexpenses.get(i).getAmount());
}
    }
}