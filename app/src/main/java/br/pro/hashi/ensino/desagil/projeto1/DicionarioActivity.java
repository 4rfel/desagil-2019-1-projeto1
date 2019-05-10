package br.pro.hashi.ensino.desagil.projeto1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class DicionarioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dict);

        Character[] alfa = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        View linearlayout1 = findViewById(R.id.linear1);
        View linearlayout2 = findViewById(R.id.linear2);
        Translator tree = new Translator();
        int i = 0;
        for (Character c:alfa){
            String morse = tree.charToMorse(c);
            TextView texto = new TextView(this);
            texto.setTextSize(14);
            texto.setText(c.toString() + " || "+morse);
            texto.setId(i);
            texto.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            if (i >= 18){
                ((LinearLayout) linearlayout2).addView(texto);
            }else{
                ((LinearLayout) linearlayout1).addView(texto);
            }
            i++;
        }

        // Botão para voltar a tela principal
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DicionarioActivity.this,SMSActivity.class);
                setResult(2,intent);
                finish();
            }
        });

        LinkedList<String> Morse = new LinkedList<>(tree.getCodes());
        View linearlayout3 = findViewById(R.id.linear3);
        View linearlayout4 = findViewById(R.id.linear4);
        int j = 0;
        Character[] Alfabeto = new Character[]{'e','t','i','a','n','m','s','u','r','w','d','k','g','o','h','v','f','l','p','j','b','x','c','y','z','q','5','4','3','2','1','6','7','8','9','0'};
        for (String c:Morse){
            TextView texto = new TextView(this);
            texto.setTextSize(14);
            texto.setText(Alfabeto[j].toString() +" || " + c );
            texto.setId(j);
            texto.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            if (j >= 18){
                ((LinearLayout) linearlayout3).addView(texto);
            }else{
                ((LinearLayout) linearlayout4).addView(texto);
            }
            j++;


    }
}}