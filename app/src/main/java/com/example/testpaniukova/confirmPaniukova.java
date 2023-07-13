package com.example.testpaniukova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class confirmPaniukova extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmpaniukova);
        TextView OrderText=(TextView) findViewById(R.id.infoText2);
        Intent intent=getIntent();
        String getOrder=intent.getStringExtra("Order");
        OrderText.setText(getOrder);

    }
    public void ReturnButton(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
