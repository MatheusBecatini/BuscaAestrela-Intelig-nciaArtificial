package ia;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Aestrela {
    private PriorityQueue<No> fronteira = new PriorityQueue();
    private ArrayList<No> lista = new ArrayList();
    
    
    public void busca(No noInicial){
        
        //Inserir no inicial na fronteira
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();
        int indice;
        
        //Enquanto a fronteira não estiver Vazia
        while(!fronteira.isEmpty()){
            //no = remover na fronteira
            no = fronteira.poll();
            //System.out.println("Este no esta sendo excluido:" + no);
            this.lista.add(no);
             indice = lista.size()-1;
            
            //testar se no é objetivo
            if(no.getEstado().EhObjetivo()){
                System.out.println("Achei!");
                imprimeCaminho(no);
                return;
            }
            
                //Gerar sucessores do no
                sucessores = no.geraSucessor(indice);
//                System.out.println("Pai na posição:" + pai + " da lista");
//                System.out.println("Lista: "+lista);
                System.out.println("");

                //Inserir sucessores na fronteira
                fronteira.addAll(sucessores);
//                System.out.println("Fronteira: "+ fronteira);
            
      }  
    }
    
    
    public void imprimeCaminho(No no){
        No aux = new No();
        aux = no;
        aux.printNo();
        
        while(aux.getPai() != -1){  
            aux = lista.get(aux.getPai());
            aux.printNo();
        }
        
    }
    
    
    
    
    
}
