package br.pro.hashi.ensino.desagil.projeto1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;

public class ContactActivity extends AppCompatActivity {

    protected Button backButton;
    protected Button upButton;
    protected Button downButton;
    protected Button selectButton;
    LinkedList<Contato> contatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        contatos = new LinkedList<>();
        String tel = getIntent().getStringExtra("tel");
        String[] nomes = getIntent().getStringArrayExtra("names");
        String[] numbers = getIntent().getStringArrayExtra("numbers");
        int cont = 0;
        for (String nome : nomes){
            contatos.add(new Contato(nome, numbers[cont]));
            cont++;
        }

        View Linear = findViewById(R.id.contatos);
        backButton = findViewById(R.id.backButton);
        int counter = 0;
        for (Contato contato : contatos){
            TextView texto = new TextView(this);
            texto.setTextSize(14);
            texto.setText(contato.getName() + ": " + contato.getNumber());
            texto.setId(counter);
            texto.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) Linear).addView(texto);
            counter++;
        }


        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ContactActivity.this, SMSActivity.class);
                intent.putExtra("tel",tel);
                setResult(7, intent);
                finish();
            }
        });

        upButton = findViewById(R.id.upButton);

        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            }
        });

        downButton = findViewById(R.id.downButton);

        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

        selectButton = findViewById(R.id.selectButton);

        selectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
    }
}
