package com.example.tarefa01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tarefa01.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Código que se executa cando o usuario pulsa o botón enviar */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);

        Calendar calendario= Calendar.getInstance();
        int anoActual = calendario.get(Calendar.YEAR);

        int anoNacemento = 0;

        try {

            anoNacemento = Integer.parseInt(editText.getText().toString());

            int idade = anoActual - anoNacemento;

            if (idade < 0) {
                intent.putExtra(EXTRA_MESSAGE, "Erro: tecleaches un ano posterior ao actual!!");
            } else {
                if (idade == 0) {
                    intent.putExtra(EXTRA_MESSAGE, "Naciches no ano actual!!");
                } else {
                    if (idade > 110) {
                        intent.putExtra(EXTRA_MESSAGE, "Este ano cumples ... " + idade + " anos?");
                    } else {
                        intent.putExtra(EXTRA_MESSAGE, "Este ano cumples " + idade + " anos.");
                    }
                }
            }
        } catch (Exception erro){
            intent.putExtra(EXTRA_MESSAGE, "Erro: revisa o ano de nacemento que tecleaches.");
        }

    startActivity(intent);
    }



}

