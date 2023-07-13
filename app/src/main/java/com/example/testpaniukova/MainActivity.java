package com.example.testpaniukova;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> MainList;
//    List<Integer> DrinkList;
    private int quantity1;
    private int quantity2;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainList = new ArrayList<>();
  //      DrinkList=new ArrayList<Integer>();
        quantity1 =0;
        quantity2=0;
    }

    public void MainChoice(View view)
    {
        CheckBox cb=(CheckBox)view;
        if(cb.isChecked())
            MainList.add(cb.getText().toString());
        else
            MainList.remove(cb.getText().toString());

    }

    @SuppressLint("SetTextI18n")
    private void Quantity1(){
        TextView q= findViewById(R.id.QuantityUpd1);
        q.setText(Integer.toString(quantity1));
    }
    @SuppressLint("SetTextI18n")
    private void Quantity2(){
        TextView q= findViewById(R.id.QuantityUpd2);
        q.setText(Integer.toString(quantity2));
    }


    public void IncreaseQuantity1(View v){
        quantity1++;
        Quantity1();
        if (quantity1>0){
            CheckBox ch = findViewById(R.id.C_W);

            if(!ch.isChecked()){
                ch.setChecked(true);
            }
        }
    }
    public void IncreaseQuantity2(View v){
        quantity2++;
        Quantity2();
        if (quantity2>0){
            CheckBox ch = findViewById(R.id.C_C);

            if(!ch.isChecked()){
                ch.setChecked(true);
            }
        }
    }

    public void DecreaseQuantity1(View v){
        quantity1--;
        if (quantity1<=0){
            quantity1=0;
            CheckBox ch = findViewById(R.id.C_W);
            ch.setChecked(false);}
        Quantity1();
    }

    public void DecreaseQuantity2(View v){
        quantity2--;
        if (quantity2<=0){
            quantity2=0;
            CheckBox ch = findViewById(R.id.C_C);
            ch.setChecked(false);}
        Quantity2();
    }


    public void CheckBoxStatus1(View v){
        CheckBox ch = findViewById(R.id.C_W);
        if(!ch.isChecked())
        {   quantity1=0;
            Quantity1(); }
        else
        {   quantity1=1;
            Quantity1(); }
    }
    public void CheckBoxStatus2(View v){
        CheckBox ch = findViewById(R.id.C_C);
        if(!ch.isChecked())
        {   quantity2=0;
            Quantity2(); }
        else
        {   quantity2=1;
            Quantity2(); }
    }


    public void ConfirmOrder(View view)
    { if (MainList.isEmpty() && quantity1==0 && quantity2==0)
        result="You have not chosen anything.\nPlease return to the main page and make your choice.\nThank you.";
      else {
            result = "Thank you for your order.\nThe following order has been received: ";
            if (!MainList.isEmpty()) {
                result += "\n\nYour main course(s) are: ";
                MainList.forEach(choice -> result += "\n" + choice);
            }
            if (quantity1 != 0 || quantity2 != 0) {
                result += "\n\nYour drink(s) are: ";
                if (quantity1 != 0)
                    result += "\n " + quantity1 + " x Water";
                if (quantity2 != 0)
                    result += "\n " + quantity2 + " x Coca Cola";
            }
      }

        Intent intent = new Intent(this,confirmPaniukova.class);
        intent.putExtra("Order",result);
        startActivity(intent);
    }


}