package br.pro.hashi.ensino.desagil.projeto1;

import

import java.util.HashMap;
import java.util.Map;

public class ListaContatos {
    private Map lista;

    public ListaContatos(){
        Map lista = new HashMap<>();
    }

    public void addContato(Contato pessoa){
        lista.put(pessoa.getName(), pessoa.getNum());
    }

}
