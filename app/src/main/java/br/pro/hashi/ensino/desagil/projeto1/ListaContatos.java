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

    public String getContact(){
        for (Map.Entry<String, String> entrada : lista.entrySet()){
            System.out.println("Nome = " + entrada.getKey() + "Número = " + entrada.getValue());
        }

    }
}

