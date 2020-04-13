package ia;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int estadoInicial[][] = {{4, 1, 3}, {7, 2, 5}, {8, 6, 0}};

        Estado e = new Estado(estadoInicial);
        System.out.println("Estado Inicial:");
        e.ImprimirEstado();
        
        No no = new No(e,-1,0);

        Aestrela a = new Aestrela();
        
        a.busca(no);
        
    }
}
