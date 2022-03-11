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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
     Button send;
     Button berechnen;
     EditText MatrikelNMR;
     TextView answer;
     String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MatrikelNMR=findViewById(R.id.editTextNumber);
        answer= findViewById(R.id.textView2);
        send= findViewById(R.id.button);
        send.setOnClickListener(view ->  {
            sendToServer();
        });
    }

    public void sendToServer(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("se2-isys.aau.at", 53212);
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    out.writeBytes(MatrikelNMR.getText().toString()+'\n');
                    txt= br.readLine();

                    out.close();
                    socket.close();
                    answer.setText(txt);

                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.start();
    }
}