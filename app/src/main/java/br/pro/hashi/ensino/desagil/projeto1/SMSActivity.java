package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
public class SMSActivity extends AppCompatActivity {

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        EditText textMessage = findViewById(R.id.text_message);
//        textMessage.setOnEditorActionListener(textMessageListener);
        EditText textPhone = findViewById(R.id.text_phone);
        //Button buttonSend = findViewById(R.id.button_send);
        Button buttonDigit = findViewById(R.id.button_digit);

//    private TextView.OnEditorActionListener textMessageListener = new TextView.OnEditorActionListener() {
//        @Override
//        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//            switch (actionId) {
//                case EditorInfo.IME_
//            }
//            return false;
//        }
//    };
        buttonDigit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //LinkedList<String> digitado = new LinkedList<>()
                String texto = "";
                texto = texto.concat(".");
                //digitado.add(".");
                textMessage.setText(texto);
                }
            });
//        buttonSend.setOnClickListener((view) -> {
//            String message = textMessage.getText().toString();
//
//            if (message.isEmpty()) {
//                showToast("Mensagem inválida!");
//                return;
//            }
//
//            String phone = textPhone.getText().toString();
//
//            // Esta verificação do número de telefone é bem
//            // rígida, pois exige até mesmo o código do país.
//            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
//                showToast("Número inválido!");
//                return;
//            }
//
//            // Enviar uma mensagem de SMS. Por simplicidade,
//            // não estou verificando se foi mesmo enviada,
//            // mas é possível fazer uma versão que verifica.
//            SmsManager manager = SmsManager.getDefault();
//            manager.sendTextMessage(phone, null, message, null, null);
//
//            // Limpar o campo para nenhum engraçadinho
//            // ficar apertando o botão várias vezes.
//            textPhone.setText("");
//        });
    }
}
