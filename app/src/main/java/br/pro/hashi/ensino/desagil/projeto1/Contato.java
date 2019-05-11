package br.pro.hashi.ensino.desagil.projeto1;

public class Contato {
    private String nome;
    private String numero;
    private boolean flag;
    public Contato(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
        this.flag = false;
    }
    public String getName(){return this.nome;}
    public String getNumber(){return this.numero;}
    public boolean getFlag(){return this.flag;}
    public void turnOn(){this.flag = true;}
    public void turnOff(){this.flag = false;}
}
