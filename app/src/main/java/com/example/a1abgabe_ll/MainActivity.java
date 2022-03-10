package com.example.a1abgabe_ll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     Button Prim;
     TextView MatrikelNMR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MatrikelNMR=findViewById(R.id.textView);
        Prim= findViewById(R.id.button);
        Prim.setOnClickListener(new View.OnClickListener() {
            //Zum Server
            @Override
            public void onClick(View view) {
                MatrikelNMR.setText("Deine Matrikelnummer: ");
            }
        });

        //Prim-Code
        /*
        public class prim {
    public static void main(String[] args) {
        int Eingabe = 100;

        for (int i = 1; i < Eingabe; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    static boolean isPrime(int number){
        boolean isprime=true;
        for (int i = 2; i<number; i++){
            if(number%i==0){
                isprime=false;
                break;
            }
        }
        return isprime;
    }
} */

    }
    //Code mit Knöpfe




}