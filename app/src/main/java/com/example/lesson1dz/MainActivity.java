package com.example.lesson1dz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    TextView textMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.bt1);
        button1.setOnClickListener(this);
        textMain = findViewById(R.id.textMain);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Activity_Iist.class);
        //intent.putExtra("KEY",new DataClass(4,""));
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode!=101)
            return;
        if (resultCode==Activity_Iist.RESULT_OK){
            textMain.setText(data.getStringExtra("RESULT"));
            recreate();
        }
    }
}