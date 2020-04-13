/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ia;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author decom
 */
public class BuscaProfundidade {
    private Stack<No> fronteira = new Stack();
    private ArrayList<No> lista = new ArrayList();
    private int limite = 5;
    
    public BuscaProfundidade(){};

    public void busca(No noInicial){
        
        //Inserir no inicial na fronteira
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();
        
        
        //Enquanto a fronteira não estiver Vazia
        while(!fronteira.isEmpty()){
            //no = remover na fronteira
            no = fronteira.pop();
            //System.out.println("Este no esta sendo excluido:" + no);
            this.lista.add(no);
            int pai = lista.size()-1;
            
            //testar se no é objetivo
            if(no.getEstado().EhObjetivo()){
                System.out.println("Achei!");
                iCaminho(no);
                fronteira.clear();//Remenda
                return;
            }
            
            if(no.getProfundidade() < limite){
                //Gerar sucessores do no
                sucessores = no.geraSucessor(pai);
//                System.out.println("Pai na posição:" + pai + " da lista");
//                System.out.println("Lista: "+lista);
                System.out.println("");

                //Inserir sucessores na fronteira
                fronteira.addAll(sucessores);
//                System.out.println("Fronteira: "+ fronteira);
            }
      }  
    }
    
    public void iCaminho(No noObj){
        No aux = new No();
        aux = noObj;
        System.out.println("Estado: ");
        aux.printNo();
        
        while(aux.getPai() != -1){  
            aux = lista.get(aux.getPai());
            aux.printNo();
        }
    }   
}



