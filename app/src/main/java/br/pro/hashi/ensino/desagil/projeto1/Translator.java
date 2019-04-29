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
        root = new Node(' ');
        map = new HashMap<>();
        map.put('|',root);

        Node node0 = new Node('0');
        Node node9 = new Node('9');
        Node node8 = new Node('8');
        Node node7 = new Node('7');
        Node node6 = new Node('6');
        Node node5 = new Node('5');
        Node node4 = new Node('4');
        Node node3 = new Node('3');
        Node node2 = new Node('2');
        Node node1 = new Node('1');
        Node nodeA = new Node('a');
        Node nodeB = new Node('b');
        Node nodeC = new Node('c');
        Node nodeD = new Node('d');
        Node nodeE = new Node('e');
        Node nodeF = new Node('f');
        Node nodeG = new Node('g');
        Node nodeH = new Node('h');
        Node nodeI = new Node('i');
        Node nodeJ = new Node('j');
        Node nodeK = new Node('k');
        Node nodeL = new Node('l');
        Node nodeM = new Node('m');
        Node nodeN = new Node('n');
        Node nodeO = new Node('o');
        Node nodeP = new Node('p');
        Node nodeQ = new Node('q');
        Node nodeR = new Node('r');
        Node nodeS = new Node('s');
        Node nodeT = new Node('t');
        Node nodeU = new Node('u');
        Node nodeV = new Node('v');
        Node nodeW = new Node('w');
        Node nodeX = new Node('x');
        Node nodeY = new Node('y');
        Node nodeZ = new Node('z');

        Node nodeGhost1 = new Node('*');
        Node nodeGhost2 = new Node('*');
        Node nodeGhost3 = new Node('*');

        root.setLeft(nodeE);
        nodeE.setParent(root);
        nodeE.setLeft(nodeI);
        nodeE.setRight(nodeA);
        map.put(nodeE.getValue(), nodeE);

        root.setRight(nodeT);
        nodeT.setParent(root);
        nodeT.setLeft(nodeN);
        nodeT.setRight(nodeM);
        map.put(nodeT.getValue(), nodeT);

        nodeA.setParent(nodeE);
        nodeA.setRight(nodeW);
        nodeA.setLeft(nodeR);
        map.put(nodeA.getValue(), nodeA);

        nodeR.setParent(nodeA);
        nodeR.setLeft(nodeL);
        map.put(nodeR.getValue(), nodeR);

        nodeL.setParent(nodeR);
        map.put(nodeL.getValue(), nodeL);

        nodeW.setParent(nodeA);
        nodeW.setRight(nodeJ);
        nodeW.setLeft(nodeP);
        map.put(nodeW.getValue(), nodeW);

        nodeP.setParent(nodeW);
        map.put(nodeP.getValue(), nodeP);

        nodeJ.setParent(nodeW);
        nodeJ.setRight(node1);
        map.put(nodeJ.getValue(), nodeJ);

        node1.setParent(nodeJ);
        map.put(node1.getValue(), node1);

        nodeI.setParent(nodeE);
        nodeI.setRight(nodeU);
        nodeI.setLeft(nodeS);
        map.put(nodeI.getValue(), nodeI);

        nodeS.setParent(nodeI);
        nodeS.setRight(nodeV);
        nodeS.setLeft(nodeH);
        map.put(nodeS.getValue(), nodeS);

        nodeH.setParent(nodeS);
        nodeH.setRight(node4);
        nodeH.setLeft(node5);
        map.put(nodeH.getValue(), nodeH);

        node5.setParent(nodeH);
        map.put(node5.getValue(), node5);

        node4.setParent(nodeH);
        map.put(node4.getValue(), node4);

        nodeV.setParent(nodeS);
        nodeV.setRight(node3);
        map.put(nodeV.getValue(), nodeV);

        node3.setParent(nodeV);
        map.put(node3.getValue(), node3);

        nodeU.setParent(nodeI);
        nodeU.setLeft(nodeF);
        map.put(nodeU.getValue(), nodeU);

        nodeF.setParent(nodeU);
        map.put(nodeF.getValue(), nodeF);

        nodeGhost1.setParent(nodeU);
        nodeGhost1.setRight(node2);
        map.put(nodeGhost1.getValue(), nodeGhost1);

        node2.setParent(nodeGhost1);
        map.put(node2.getValue(), node2);

        nodeT.setParent(root);
        nodeT.setRight(nodeM);
        nodeT.setLeft(nodeN);
        map.put(nodeT.getValue(), nodeT);

        nodeN.setParent(nodeT);
        nodeN.setRight(nodeK);
        nodeN.setLeft(nodeD);
        map.put(nodeN.getValue(), nodeN);

        nodeD.setParent(nodeN);
        nodeD.setRight(nodeX);
        nodeD.setLeft(nodeB);
        map.put(nodeD.getValue(), nodeD);

        nodeB.setParent(nodeD);
        nodeB.setLeft(node6);
        map.put(nodeB.getValue(), nodeB);

        node6.setParent(nodeB);
        map.put(node6.getValue(), node6);

        nodeX.setParent(nodeD);
        map.put(nodeX.getValue(), nodeX);

        nodeK.setParent(nodeN);
        nodeK.setRight(nodeY);
        nodeK.setLeft(nodeC);
        map.put(nodeK.getValue(), nodeK);

        nodeC.setParent(nodeK);
        map.put(nodeC.getValue(), nodeC);

        nodeY.setParent(nodeK);
        map.put(nodeY.getValue(), nodeY);

        nodeM.setParent(nodeT);
        nodeM.setRight(nodeO);
        nodeM.setLeft(nodeG);
        map.put(nodeM.getValue(), nodeM);

        nodeG.setParent(nodeM);
        nodeG.setRight(nodeQ);
        nodeG.setLeft(nodeZ);
        map.put(nodeG.getValue(), nodeG);

        node7.setParent(nodeZ);
        map.put(node7.getValue(), node7);

        nodeQ.setParent(nodeG);
        map.put(nodeQ.getValue(), nodeQ);

        nodeGhost2.setParent(nodeO);
        nodeGhost2.setLeft(node8);
        map.put(nodeGhost2.getValue(), nodeGhost2);

        nodeGhost3.setParent(nodeO);
        nodeGhost3.setLeft(node9);
        nodeGhost3.setRight(node0);
        map.put(nodeGhost3.getValue(), nodeGhost3);

        node8.setParent(nodeGhost2);
        map.put(node8.getValue(), node8);

        node9.setParent(nodeGhost3);
        map.put(node9.getValue(), node9);

        node0.setParent(nodeGhost3);
        map.put(node0.getValue(), node0);

    }

    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public char morseToChar(String code) {
        Character place = '|';
        for (int i = 0; i <= code.length(); i++) {
            if (code.charAt(i) == '-') {
                if (map.get(place).getRight() != null){
                    place = map.get(place).getRight().getValue();
                }
            } else if (code.charAt(i) == '.') {
                place = map.get(place).getLeft().getValue();
            }
        }
        return map.get(place).getValue();
    }

    public String charToMorse(char c) {
        LinkedList<Character> morse = new LinkedList<>();
        while (map.get(c) != root) {
            if (map.get(c).getParent().getLeft().getValue() == map.get(c).getValue()) {
                morse.add('.');
            } else if (map.get(c).getParent().getRight().getValue() == map.get(c).getValue()) {
                morse.add('-');
            }
        }
        String retorno = "";
        for (int i = morse.size(); i >= 0; i--) {
            retorno += morse.get(i);
        }

        return retorno;
    }

    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public LinkedList<String> getCodes() {
        LinkedList<String> Codigos = new LinkedList<>();
        Character[] Alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        for (int y=0; y <= Alfabeto.length;y++){
            Codigos.add(charToMorse(Alfabeto[y]));
        }
        return Codigos;
    }

}
