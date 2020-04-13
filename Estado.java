package ia;

public class Estado {
    private int[][] mat = new int [3][3];
        //posição (linha/coluna) da posição vazia{0}
        private int linhaVazia;
        private int colunaVazia;
       
    public Estado (int mat[][]){
            for(int i=0;i<3;i++){
            for(int j=0; j<3 ;j++){
            this.mat[i][j]=mat[i][j];
            if(this.mat[i][j]==0){
                linhaVazia=i;
                colunaVazia=j;
            }
          }
        }
    }
     
    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public void setLinhaVazia(int linhaVazia) {
        this.linhaVazia = linhaVazia;
    }

    public void setColunaVazia(int colunaVazia) {
        this.colunaVazia = colunaVazia;
    }

    public int[][] getMat() {
        return mat;
    }

    public int getLinhaVazia() {
        return linhaVazia;
    }

    public int getColunaVazia() {
        return colunaVazia;
    }    
 
    public boolean EhObjetivo(){
    int objetivo[][] = {{1,2,3},{4,5,6},{7,8,0}};
        for( int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(this.mat[i][j] != objetivo[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public Estado GeraSucessor (char movimento){
        Estado eSucessor = new Estado(this.getMat());
        int x,y;
        switch (movimento){
            case 'd':
                x = this.linhaVazia;
                y = this.colunaVazia+1;
                if (y>2) return null;
               
                eSucessor.mat[eSucessor.linhaVazia][eSucessor.colunaVazia]=
                eSucessor.mat[x][y];
                eSucessor.mat[x][y]=0;
                eSucessor.colunaVazia=y;
                return eSucessor;
               
            case 'e':
               x = this.linhaVazia;
               y = this.colunaVazia-1;
               if (y<0) return null;
               
               eSucessor.mat[eSucessor.linhaVazia][eSucessor.colunaVazia]=
               eSucessor.mat[x][y];
               eSucessor.mat[x][y]=0;
               eSucessor.colunaVazia=y;
               return eSucessor;
               
               
            case 'b':
               x = this.linhaVazia+1;
               y = this.colunaVazia;
               if (x>2) return null;
               
               eSucessor.mat[eSucessor.linhaVazia][eSucessor.colunaVazia]=
               eSucessor.mat[x][y];
               eSucessor.mat[x][y]=0;
               eSucessor.linhaVazia=x;
               return eSucessor;
               
            case 'c':
               x = this.linhaVazia-1;
               y = this.colunaVazia;
               if (x<0) return null;
               
               eSucessor.mat[eSucessor.linhaVazia][eSucessor.colunaVazia]=
               eSucessor.mat[x][y];
               eSucessor.mat[x][y]=0;
               eSucessor.linhaVazia=x;
               return eSucessor;

        }
    return null;
    }
   
   
    public void ImprimirEstado(){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
         System.out.print(this.mat[i][j]+" ");  
        }
        System.out.println();
    }
    System.out.println("Linha vazia " + this.getLinhaVazia());
    System.out.println("Coluna vazia " + this.getColunaVazia());
    }

   
}