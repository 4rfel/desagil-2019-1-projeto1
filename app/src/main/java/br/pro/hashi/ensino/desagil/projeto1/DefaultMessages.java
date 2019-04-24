package br.pro.hashi.ensino.desagil.projeto1;

import java.util.LinkedList;

public class DefaultMessages {
    private LinkedList<String> messages_list;

    public DefaultMessages(){
        messages_list = new LinkedList<>();
        messages_list.add("Estou com fome");
        messages_list.add("Estou com sede");
        messages_list.add("Preciso ir ao banheiro");
        messages_list.add("Venha rapidamente");
        messages_list.add("Sinto dor");
    }

    public String getMessage(int index) {
        return messages_list.get(index);
    }
}