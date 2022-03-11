package com.example.a1abgabe_ll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
     Button send;
     EditText MatrikelNMR;
     TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MatrikelNMR=findViewById(R.id.editTextNumber);
        answer= findViewById(R.id.textView);
        send= findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToServer();
            }
        });

    }


    public void sendToServer(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("se2-isys.aau.at", 53212);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    out.close();
                    socket.close();

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.start();
    }
}