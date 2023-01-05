package com.km.inclassactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.km.inclassactivity2.model.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameTF;
    private EditText salaryTF;
    private Spinner statusSpinner;
    private Button addBtn;
    private ListView empList;
    private List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();


        addBtn.setOnClickListener(v -> {
            String name = String.valueOf(nameTF.getText());
            if(name == null) {
                Toast.makeText(getApplicationContext(), "Name field is empty, please enter a valid name!", Toast.LENGTH_SHORT).show();
                return;
            }
            Double salary = 0.0;
            try {
                salary = Double.valueOf(String.valueOf(salaryTF.getText()));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Please enter a valid salary!", Toast.LENGTH_SHORT).show();
                return;
            }
            String empStatus = statusSpinner.getSelectedItem().toString();
            if(empStatus == null) {
                Toast.makeText(getApplicationContext(), "Please select an employee status!", Toast.LENGTH_SHORT).show();

            }
            Employee employee = new Employee(name, salary, empStatus);
            employees.add(employee);
            ArrayAdapter<Employee> employeeArrayAdapter = new ArrayAdapter<Employee>(MainActivity.this,
                    android.R.layout.simple_list_item_1, employees);
            empList.setAdapter(employeeArrayAdapter);

        });
    }

    void setup() {
        nameTF = findViewById(R.id.nameTF);
        salaryTF = findViewById(R.id.salaryTF);
        statusSpinner = findViewById(R.id.statusSpinner);
        addBtn = findViewById(R.id.addBtn);
        empList = findViewById(R.id.empList);

        String[] empStatusArr = getResources().getStringArray(R.array.empStatus);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, empStatusArr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter);
    }
}