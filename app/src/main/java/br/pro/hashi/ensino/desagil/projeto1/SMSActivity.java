package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
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
    private boolean numberContato = false;
    private Translator translator;

    private TextView textMessage;
    private TextView textPhone;

    protected Button buttonSend; // Botão de enviar
    protected Button buttonDigit; // Botão de digitar (ponto ou barra)
    protected Button buttonDelete; // Botão de apagar
    protected Button buttonReadyText; // Botão de mensagem pronta
    protected Button buttonSpace; // Botão do espaço
    protected Button buttonDict;
    protected Button buttonContato;

    private String savingPhoneText;
    private String savingMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        textMessage = findViewById(R.id.text_message);
        textPhone = findViewById(R.id.text_phone);

        buttonSend = findViewById(R.id.button_send); // Botão de enviar
        buttonDigit = findViewById(R.id.button_digit); // Botão de digitar (ponto ou barra)
        buttonDelete = findViewById(R.id.button_delete); // Botão de apagar
        buttonReadyText = findViewById(R.id.mmp); // Botão de mensagem pronta
        buttonSpace = findViewById(R.id.space); // Botão do espaço
        buttonDict = findViewById(R.id.dict);

        buttonDict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SMSActivity.this, DicionarioActivity.class));
            }
        });

        if (savingMessageText != null) {
            textMessage.setText(savingMessageText);
        } else {
            textMessage.setText("");
        }

        if (savingPhoneText != null) {
            textPhone.setText(savingPhoneText);
        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String msgPronta = bundle.getString("message");
            textMessage.setText(msgPronta);
        }
      
        buttonContato = findViewById(R.id.contato);

        translator = new Translator();

        // Botão do ponto ou barra
        buttonDigit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!numberContato) {
                    textPhone.append(".");
                } else {
                    textMessage.append(".");
                }
            }
            });

        buttonDigit.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                if (!numberContato) {
                    textPhone.append("-");
                    return true;
                } else {
                    textMessage.append("-");
                    return true;
                }
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
                if (!numberContato) {
                    if (textPhone.getText().toString().isEmpty()) {
                        showToast("O telefone está vazio!");
                    }else{
                    modifyText = textPhone.getText().toString();
                    modifyText = modifyText.substring(0, modifyText.length() - 1);
                    textPhone.setText(modifyText);}
                } else {
                    if (textMessage.getText().toString().isEmpty()) {
                        showToast("A mensagem já está vazia!");
                    }else{
                    modifyText = textMessage.getText().toString();
                    modifyText = modifyText.substring(0, modifyText.length() - 1);
                    textMessage.setText(modifyText);}
                }
            }
        });

        buttonDelete.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                if (!numberContato){
                    if (textPhone.getText().toString().isEmpty()) {
                        showToast("O número já está vazio!");
                    }
                    textPhone.setText("");
                    return true;
                }else{
                    if (textMessage.getText().toString().isEmpty()) {
                        showToast("A mensagem já está vazia!");
                    }
                    textMessage.setText("");
                    return true;
                }
            }
        });

        // Mensagem Pronta
        buttonReadyText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(SMSActivity.this, ReadyText.class));
            }
        });

        // Botão Envio
        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String message = textMessage.getText().toString();
                String telephone = textPhone.getText().toString();
                String last = "";
                String letters = "";

                if (!numberContato) {
                    for (char c : telephone.toCharArray()) {
                        if (c == '.' || c == '-') {
                            last += String.valueOf(c);

                        } else if(c != ' '){
                            letters += String.valueOf(c);
                        }
                    }
                    char numero_char = translator.morseToChar(last);
                    String numero_string = String.valueOf(numero_char);
                    textPhone.setText("");
                    textPhone.append(letters);
                    if (numero_char != ' '){
                        textPhone.append(numero_string);
                    }


                    if (!PhoneNumberUtils.isGlobalPhoneNumber(telephone)) {
                        showToast("Número inválido!");
                        return;
                    } else {
                        numberContato = true;
                    }
                } else {
                    for(char c: message.toCharArray()){
                        if(c=='.'||c=='-'){
                            last += String.valueOf(c);
                        }else{
                            letters += String.valueOf(c);
                        }
                    }

                    char numero_char = translator.morseToChar(last);
                    String numero_string = String.valueOf(numero_char);
                    textMessage.setText("");
                    textMessage.append(letters);
                    textMessage.append(numero_string);


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
                    textMessage.setText("");
                }
            }
        });

        // Botão Espaço
        buttonSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String message = textMessage.getText().toString();
                String telephone = textPhone.getText().toString();
                String last = "";
                String letters = "";
                boolean espaco = true;

                if (!numberContato){
                    for(char c: telephone.toCharArray()){
                        if(c=='.'||c=='-'){
                            last += String.valueOf(c);
                        }else{
                            letters += String.valueOf(c);
                        }
                    }
                    if (last.length()!=5){
                        showToast("Número Inválido");
                        textPhone.setText("");
                        textPhone.append(letters);
                    }else{
                        char numero_char = translator.morseToChar(last);
                        String numero_string = String.valueOf(numero_char);
                        textPhone.setText("");
                        textPhone.append(letters);
                        textPhone.append(numero_string);}

                } else {
                    for(char c: message.toCharArray()){
                        if(c=='.'||c=='-'){
                            last += String.valueOf(c);
                            espaco = false;
                        }else{
                            letters += String.valueOf(c);
                        }
                    }
                    if(!espaco){
                        if (last.length()>5){
                            showToast("Caractere inválido");
                            textMessage.setText("");
                            textMessage.append(letters);
                        } else {
                            char numero_char = translator.morseToChar(last);
                            String numero_string = String.valueOf(numero_char);
                            textMessage.setText("");
                            textMessage.append(letters);
                            textMessage.append(numero_string);
                        }
                    }else{
                        textMessage.append(" ");
                    }

                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savingPhoneText = textPhone.getText().toString();
        savingMessageText = textMessage.getText().toString();
        savedInstanceState.putString("savingMessageText", savingMessageText);
        savedInstanceState.putString("savingPhoneText", savingPhoneText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savingMessageText = savedInstanceState.getString("savingMessageText");
        savingPhoneText = savedInstanceState.getString("savingPhoneText");
        textMessage.setText(savingMessageText);
        textPhone.setText(savingPhoneText);
    }

}
