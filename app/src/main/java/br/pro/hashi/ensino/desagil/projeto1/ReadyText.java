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
    private LinkedList<MsgPronta> seletor = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readytext);

        TextView msgPronta0 = findViewById(R.id.mmp0);
        TextView msgPronta1 = findViewById(R.id.mmp1);
        TextView msgPronta2 = findViewById(R.id.mmp2);
        TextView msgPronta3 = findViewById(R.id.mmp3);
        TextView msgPronta4 = findViewById(R.id.mmp4);

        MsgPronta message0 = new MsgPronta(msgPronta0, true,this);
        MsgPronta message1 = new MsgPronta(msgPronta1, false,this);
        MsgPronta message2 = new MsgPronta(msgPronta2, false,this);
        MsgPronta message3 = new MsgPronta(msgPronta3, false,this);
        MsgPronta message4 = new MsgPronta(msgPronta4, false,this);

        seletor.add(message0);
        seletor.add(message1);
        seletor.add(message2);
        seletor.add(message3);
        seletor.add(message4);

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
                for (MsgPronta message: seletor) {
                    if (message.getFlag()) {
                        message.setFlagFalse();
                        message.paintMessage();
                    }
                }
                seletor.get(msgCounter).setFlagTrue();
                seletor.get(msgCounter).paintMessage();
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
                for (MsgPronta message: seletor) {
                    if (message.getFlag()) {
                        message.setFlagFalse();
                        message.paintMessage();
                    }
                }
                seletor.get(msgCounter).setFlagTrue();
                seletor.get(msgCounter).paintMessage();
            }
        });


        // Botão para selecionar mensagem
        Button selectButton = findViewById(R.id.selectButton);

        selectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                selectedMsg = seletor.get(msgCounter).getMessageString();
                showToast("Mensagem escolhida!");
                Intent intent = new Intent(ReadyText.this, SMSActivity.class);
                intent.putExtra("message", selectedMsg);
                startActivity(intent);
            }
        });
    }
}
