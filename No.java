package ia;

import java.util.ArrayList;

public class No implements Comparable<No> {

    private Estado estado;
    private int pai;
    private int profundidade; //custo acumulado, que é igual à profundiade
    protected int h; // heurística: a* custo estimado para o proximo nó
    private int funcaoAvaliacao;//função heuristica int f; //g+h


    public No(Estado estado, int pai, int profundidade) {
        this.estado = estado;
        this.pai = pai;
        this.profundidade = profundidade;
        this.h = this.distanciaDeManhantan(); //Tem q mudar a função Heuristica aqui ;;
        this.funcaoAvaliacao = this.profundidade + this.h;
    }

    public No() {
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getfuncaoAvaliacao() {
        return funcaoAvaliacao;
    }

    public void setfuncaoAvaliacao(int funcaoAvaliacao) {
        this.funcaoAvaliacao = funcaoAvaliacao;
    }

    public ArrayList<No> geraSucessor(int pai) {
        ArrayList<No> sucessores = new ArrayList();
        Estado e;
        No noSuc;

        //Esquerda
        e = this.estado.GeraSucessor('e');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }
        //Cima
        e = this.estado.GeraSucessor('c');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }
        //baixo
        e = this.estado.GeraSucessor('b');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }

        //Direita
        e = this.estado.GeraSucessor('d');
        if (e != null) {
            noSuc = new No(e, pai, this.profundidade + 1);
            sucessores.add(noSuc);
        }

        return sucessores;
    }

    public void printNo() {
        System.out.println("\n\n\n Estado: ");
        this.estado.ImprimirEstado();
        System.out.println("Indice do pai: " + this.pai);
        System.out.println("Profundidade: " + this.profundidade);
        System.out.println("h(): " + this.h);
        System.out.println("f(): " + this.funcaoAvaliacao);
    }

    @Override
    public int compareTo(No no) {
        if (this.getfuncaoAvaliacao() > no.getfuncaoAvaliacao()) {
            return 1;
        } else if (this.getfuncaoAvaliacao() < no.getfuncaoAvaliacao()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    
    
private int[] getCoordenadas(int valor) {
    int objetivo[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[] coord = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (valor == objetivo[i][j]) {
                    coord[0] = i;
                    coord[1] = j;
                    return coord;
                }
            }
        }
        return null;
    }

    public int distanciaDeManhantan() {
        int distancia = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] coord = getCoordenadas(this.getEstado().getMat()[i][j]);
                distancia += Math.abs(i - coord[0]) + Math.abs(j - coord[1]);
            }
        }
        return distancia;
    }

// Calculo de função heuristica, peças fora do lugar.
    public int h_pecasFora(Estado state) {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int heu = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state.getMat()[i][j] != mat[i][j]) {
                    heu++;
                }
            }
        }
        return heu;
    }

}




/*

A estrela: primeiro definir a função de avaliação do A estrela, que é 

f = g+h

custo = g
função heurística = h

Nesse problema, o custo acumulado é igual à profundiade do nó, visto que 
o número de movimentações é a profundidade do nó na árvore.

Nesse caso, falta inserir o atributo h de cada nó, ou seja criar na classe nó
um atributo h, e também um atributo f.

*/
