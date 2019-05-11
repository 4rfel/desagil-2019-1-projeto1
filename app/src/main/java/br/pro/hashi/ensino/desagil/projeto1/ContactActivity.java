package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;

public class ContactActivity extends AppCompatActivity {

    protected Button backButton;
    protected Button upButton;
    protected Button downButton;
    protected Button selectButton;

    private int contactCounter = 0;

    protected String[] contactsNames;
    protected String[] contactsNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactsNames = new String[100];
        contactsNumbers = new String[100];

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ContactActivity.this, SMSActivity.class);
                setResult(2, intent);
                finish();
            }
        });

        contactsNames = getIntent().getStringArrayExtra("names");
        contactsNumbers = getIntent().getStringArrayExtra("numbers");

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
