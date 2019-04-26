package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;

// Não é permitido mudar nada nessa classe
// exceto o recheio dos três métodos.

public class Translator {
    private final Node root;
    private final HashMap<Character, Node> map;


    // Você deve mudar o recheio deste construtor,
    // de acordo com os requisitos não-funcionais.
    public Translator() {
        root = null;
        map = null;
        String[] Morse = {".","-","..",".-","-.","--","...","..-",".-.",".--","-..","-.-","--.","---","....",
                "...-","..-.",".-..",".--.",".---","-...","-..-","-.-.","-.--","--..","--.-",
                ".....","....-","...--","..---",".----","-....","--...","---..","----.","-----"};
        String[] Alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        Node node5 = new Node('5');
        Node node4 = new Node('4');
        Node node3 = new Node('3');
        Node node2 = new Node('2');
        Node node1 = new Node('1');
        Node nodePlus = new Node('+');
        Node node6 = new Node('6');
        Node nodeEqual = new Node('=');
        Node nodeBar = new Node('/');
        Node node7 = new Node('7');
        Node node8 = new Node('8');
        Node node9 = new Node('9');
        Node node0 = new Node('0');
        Node nodeH = new Node('H');
        nodeH.setLeft(node5);
        nodeH.setRight(node4);
        node5.setParent(nodeH);
        node4.setParent(nodeH);
        Node nodeV = new Node('V');



    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public char morseToChar(String code) {


        return ' ';
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public String charToMorse(char c) {
        return " ";
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }

}
