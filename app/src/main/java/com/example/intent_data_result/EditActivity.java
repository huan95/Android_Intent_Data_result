package com.example.intent_data_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    Button btnConfirm;
    EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
        edtName = (EditText) findViewById(R.id.editTextName);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = edtName.getText().toString();//lay noi dung nguoi dung nhap
                Intent intent = new Intent();
                intent.putExtra("New", newName);
                setResult(RESULT_OK, intent);//kiem tra
                finish();//dong man hinh hien tai
            }
        });
    }
}
