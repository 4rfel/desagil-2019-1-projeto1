package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.Map;


public class ListaContatos {
    private Map<String, String> lista;

    public ListaContatos(){
        this.lista = new HashMap<>();
    }

    public void addContato(Contato pessoa){
        lista.put(pessoa.getName(), pessoa.getNum());

    }

    public void getContact(){
        for (Map.Entry<String, String> entrada : lista.entrySet()){

            String nome = entrada.getKey();
            String num = entrada.getValue();

            System.out.println("Nome = " + nome + "Número = " + num);
        }

    }
}

