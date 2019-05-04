package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class ReadyText extends AppCompatActivity {
    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    private String selectedMsg;
    private int msgCounter = 0;
    private LinkedList<TextView> seletor = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readytext);

        TextView msgPronta0 = findViewById(R.id.mmp0);
        TextView msgPronta1 = findViewById(R.id.mmp1);
        TextView msgPronta2 = findViewById(R.id.mmp2);
        TextView msgPronta3 = findViewById(R.id.mmp3);
        TextView msgPronta4 = findViewById(R.id.mmp4);

        seletor.add(msgPronta0);
        seletor.add(msgPronta1);
        seletor.add(msgPronta2);
        seletor.add(msgPronta3);
        seletor.add(msgPronta4);

        // Botão para voltar a tela principal
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReadyText.this, SMSActivity.class));
            }
        });

        Button upButton = findViewById(R.id.upButton);

        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (msgCounter == 0) {
                    msgCounter = 4;
                } else {
                    msgCounter--;
                }
//                if (seletor.get(msgCounter + 1).getTextColors().equals(R.color.red)) {
//
//                }
                seletor.get(msgCounter).setTextColor(getColor(R.color.red));
                selectedMsg = seletor.get(msgCounter).getText().toString();
            }
        });

        Button downButton = findViewById(R.id.downButton);

        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (msgCounter == 4) {
                    msgCounter = 0;
                } else {
                    msgCounter++;
                }
                seletor.get(msgCounter).setTextColor(getColor(R.color.red));
                selectedMsg = seletor.get(msgCounter).getText().toString();
            }
        });

        // Botão para selecionar mensagem
        Button selectButton = findViewById(R.id.selectButton);

        selectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showToast("Mensagem escolhida!");
                Intent intent = new Intent(ReadyText.this, SMSActivity.class);
                intent.putExtra("message", selectedMsg);
                startActivity(intent);
            }
        });
    }
}
