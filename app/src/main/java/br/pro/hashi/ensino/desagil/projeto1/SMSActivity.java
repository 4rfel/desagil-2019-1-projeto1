package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class SMSActivity extends AppCompatActivity {

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    private String modifyText;
    private long lastClickTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        TextView textMessage = findViewById(R.id.text_message);
        TextView textPhone = findViewById(R.id.text_phone);
        Button buttonSend = findViewById(R.id.button_send); // Botão de enviar

        Button buttonDigit = findViewById(R.id.button_digit); // Botão de digitar (ponto ou barra)
        Button buttonDelete = findViewById(R.id.button_delete); // Botão de apagar

        Button buttonMsgPronta = findViewById(R.id.mmp); // Botão de mensagem pronta

        Button buttonDict = findViewById(R.id.dict);

        textMessage.setText("");

        // Botão do ponto ou barra
        buttonDigit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textMessage.append(".");
            }
            });

        buttonDigit.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                textMessage.append("-");
                return true;
            }
        });

        // Botão dicionário -> funcionalidade ainda a ser implementada
//        buttonDict.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(this, activity_sms.class));
//            }
//        });

        // Botão Delete
        buttonDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (textMessage.getText().toString().isEmpty()) {
                    showToast("A mensagem já está vazia!");
                }
                modifyText = textMessage.getText().toString();
                modifyText = modifyText.substring(0, modifyText.length() - 1);
                textMessage.setText(modifyText);
            }
        });

        buttonDelete.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                if (textMessage.getText().toString().isEmpty()) {
                    showToast("A mensagem já está vazia!");
                }
                textMessage.setText("");
                return true;
            }
        });

        // Modo Mensagem Pronta

        buttonMsgPronta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // implementar funcionalidade
            }
        });
    }
}
