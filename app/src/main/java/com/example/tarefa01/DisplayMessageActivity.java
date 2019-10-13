package com.example.tarefa01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Obter Intent que inicia a actividade e coller o texto
        Intent intent = getIntent();
        String mensaxe = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Poñer o texto no textView
        TextView textView = findViewById(R.id.textView);
        textView.setText(mensaxe);
    }
}
