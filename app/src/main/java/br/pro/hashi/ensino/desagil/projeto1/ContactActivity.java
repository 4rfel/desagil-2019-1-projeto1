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
    private HashMap<String, String> map;

    private int contactCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        String nomes = getIntent().getStringExtra("name");
        String numbers = getIntent().getStringExtra("number");
        Contato contato = new Contato(nomes, numbers);

        View Linear = findViewById(R.id.contatos);
        backButton = findViewById(R.id.backButton);
        int counter = 0;
        for (String nome:nomes){
            TextView texto = new TextView(this);
            texto.setTextSize(14);
            texto.setText(nome + ": " + numbers[counter]);
            texto.setId(counter);
            texto.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) Linear).addView(texto);
            counter ++;
        }


        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ContactActivity.this, SMSActivity.class);
                setResult(2, intent);
                finish();
            }
        });

        upButton = findViewById(R.id.upButton);

        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for (String nome: nomes) {
                    if (contactCounter == nomes.size()-1) {

                        contactCounter--;
                    }
                }
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
