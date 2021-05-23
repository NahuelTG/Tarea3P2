
/**
 * Write a description of class Caracol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caracol
{
    private int [][] numeros;
    private int Filas;
    private int Columnas;
    public Caracol(int f, int c){
        Filas = f;
        Columnas = c;
        numeros = new int [f][c];
    }
    
    
    public String Espiral(){
        String Espiral = "";
        int num = 1;
        int f = 0;
        int c = 0;
        int t = 0;
        boolean Derecha = true;
        boolean Abajo = false;
        boolean Izq = false;
        boolean Arriba = false;
        
        while(Derecha == true || Izq == true || Abajo == true || Arriba == true){
            if(Abajo == true){
                numeros[f][c] = num++;
                if(f == c){
                    Abajo = false;
                    Izq = true;
                    f--;
                    c--;
                    t++;
                }
                f++;
                if(num > Filas*Columnas){
                    Derecha = Abajo = Izq = Arriba = false;
                }
            }
            if(Izq == true){
                numeros[f][c] = num++;
                if(f+c == Filas - 1 && f > c ){
                    Izq = false;
                    Arriba = true;
                    c++;
                    f--;
                    t++;
                }
                c--;
                if(num > Filas*Columnas){
                    Derecha = Abajo = Izq = Arriba = false;
                }
            }
            if(Arriba == true){
                numeros[f][c] = num++;
                f--;
                if(numeros[f][c] > 0){
                    Arriba = false;
                    Derecha = true;
                    f++;
                    c++;
                    t++;
                }
                if(num > Filas*Columnas){
                    Derecha = Abajo = Izq = Arriba = false;
                }
            }
            if(Derecha == true){
                numeros[f][c] = num++;
                c++;
                if(f+c == Filas && f <= c ){
                    Derecha = false;
                    Abajo = true;
                    c--;
                    f++;
                    t++;
                }
                if(num > Filas*Columnas){
                    Derecha = Abajo = Izq = Arriba = false;
                }
            }
        }
        
        for(f = 0;f < Filas;f++){
            for(c = 0;c < Columnas;c++){
                Espiral = Espiral + numeros[f][c] + "   ";
            }
        }  
        return Espiral;
    }
    
    
    public String Diagonales(){
        Espiral();
        String Diagonal = "";
        /*
         * Diagonal Secundaria
         */
        int j = 0;
        String DiagonalPrincipal = "";
        for(int i = 0; i < Filas;i++){
            DiagonalPrincipal = DiagonalPrincipal + numeros[i][j] + "   ";
            j++;
        }
        /*
         * Diagonal Principal
         */
        int p = 0;
        int a = 0;
        int b = Columnas - 1;
        String DiagonalSecundaria = "";
        while(p < Filas){
            DiagonalSecundaria = DiagonalSecundaria + numeros[a][b] + "   ";
            a++;
            b--;
            p++;
        }
        Diagonal = "La Diagonal Principal son los numeros  " + DiagonalPrincipal 
        + "La Diagonal Secundaria son los numeros  " + DiagonalSecundaria;
        return Diagonal;
    }
    
    public void Mostrar(){
        Espiral();
        /*
         * Diagonal Secundaria
         */
        int j = 0;
        String DiagonalPrincipal = "";
        for(int i = 0; i < Filas;i++){
            DiagonalPrincipal = DiagonalPrincipal + numeros[i][j] + "\t";
            j++;
        }
        /*
         * Diagonal Principal
         */
        int p = 0;
        int a = 0;
        int b = Columnas - 1;
        String DiagonalSecundaria = "";
        while(p < Filas){
            DiagonalSecundaria = DiagonalSecundaria + numeros[a][b] + "\t";
            a++;
            b--;
            p++;
        }
        
        for(int f = 0;f < Filas;f++){
            for(int c = 0;c < Columnas;c++){
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }
        System.out.print("\n" + "Diagonal Principal"+ "\n" 
        + DiagonalPrincipal + "\n" + "Diagonal Secundaria" + "\n" + DiagonalSecundaria);
    }
}
