package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
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

        final long bootTime = SystemClock.elapsedRealtime();
        lastClickTime = bootTime;

        textMessage.setText("");

        // Botão do ponto ou barra
        buttonDigit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                if (timeElapsed > 950.0) {
                    textMessage.append("-");
                } else {
                    textMessage.append(".");
                }
                lastClickTime = timeNow;
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
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                if (textMessage.getText().toString().isEmpty()) {
                    showToast("A mensagem já está vazia!");
                }
                if (timeElapsed > 1200.0) {
                    textMessage.setText("");
                } else {
                    modifyText = textMessage.getText().toString();
                    modifyText = modifyText.substring(0, modifyText.length() - 1);
                    textMessage.setText(modifyText);
                }
                lastClickTime = timeNow;
            }
        });
        // Botão Envio
        buttonSend.setOnClickListener((view) -> {
            String message = textMessage.getText().toString();

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            String phone = textPhone.getText().toString();

            // Esta verificação do número de telefone é bem
            // rígida, pois exige até mesmo o código do país.
            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            }

            // Enviar uma mensagem de SMS. Por simplicidade,
            // não estou verificando se foi mesmo enviada,
            // mas é possível fazer uma versão que verifica.
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            // Limpar o campo para nenhum engraçadinho
            // ficar apertando o botão várias vezes.
            textPhone.setText("");
        });
    }
}
