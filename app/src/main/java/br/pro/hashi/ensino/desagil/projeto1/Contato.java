package br.pro.hashi.ensino.desagil.projeto1;

public class Contato {

    private String name;
    private String numero;

    public Contato(String nome, String num){
        this.name = nome;
        this.numero = num;
    }

    public String getName(){
        return this.name;
    }

    public String getNum(){
        return this.numero;
    }
}

