package com.example.intent_data_result;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtName;
    Button btnEdit;

    int REQUEST_CODE_EDIT = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.txtViewName);
        btnEdit = (Button) findViewById(R.id.buttonEdit);

        //su kien chuyen man hinh
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivityForResult(intent, REQUEST_CODE_EDIT);//nhan kq tu man hinh khac tra ve
            }
        });
    }

    @Override
    //nhan ket qua man hinh khac tra ve Main
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //kiem tra: dung request , result co dung ben man hinh gui du lieu ko, kiem tra data co du lieu hay ko
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            String name = data.getStringExtra("New");
            txtName.setText(name);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
