package com.example.firebase_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit_name = findViewById(R.id.txtName);
        final EditText edit_pos = findViewById(R.id.txtPos);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EmployeeDAO dao = new EmployeeDAO();
        btnSubmit.setOnClickListener(v -> {
            Employee emp = new Employee(edit_name.getText().toString(), edit_pos.getText().toString());
            dao.add(emp).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+ er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}