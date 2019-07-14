
import java.util.Random;

public class Computador extends Jogador {
//função de jogada principal

    //@Override
    //override da função de jogada do jogador
    public char[][] jogar(char[][] mat, int qtJogada) {
        Random random = new Random(); //valor randomico a cada jogada,
                                      //quando não há condição específica
        int linha; //variavel que representa a linha na matriz do tabuleiro
        int coluna; //variavel que representa a coluna na matriz do tabuleiro
        while (true) {
            //sempre testado primeiro,
            //pois caso o compuador possa vencer, ele vai
            if (testeJogadaOfensiva(mat) == 1) { 
                mat = jogadaOfensiva(mat); //executa a jogada ofensiva
                return mat;
            //impede o jogador de completar uma sequência de três no tabuleiro
            } else if (testeJogadaDefensiva(mat) == 1) { 
                mat = jogadaDefensiva(mat); //executa a jogada defensiva
                return mat;
            //momento decisivo, se o jogador joga na borda,
            //o computador TEM que jogar no meio
            } else if (qtJogada == 1) { 
                //teste se a jogada foi no centro
                if (priJogCentro(mat) == 1) { 
                    //joga na borda
                    mat[0][0] = 'X';
                    return mat;
                } else {
                    mat[1][1] = 'X';
                    return mat;
                }
            } else if (qtJogada == 2 && testeJogadaEstrategica(mat) == 1) {
                /*jogada estrategica para impedir futura derrota 
                é o segundo momento decisivo do resultado do jogo*/
                mat = jogadaEstrategica(mat);
                return mat;
            } else {
            //jogada aleatoria caso nenhuma das situações anteriores tenha sido atendida
                linha = random.nextInt(3);
                coluna = random.nextInt(3);
                if (mat[linha][coluna] == '#') {
                    mat[linha][coluna] = 'X';
                    return mat;
                }
            }
        }
    }

    //método que informa se a jogada foi feita no centro
    public int priJogCentro(char[][] mat) {
        if (mat[1][1] == 'O') {
            return 1;
        } else {
            return 0;
        }
    }

    //teste se a situação pede a jogada finalizadora
    public int testeJogadaOfensiva(char[][] mat) {
        //horizontais ofensivas
        if (mat[0][0] == 'X' && mat[0][1] == 'X' && mat[0][2] == '#') {
            return 1;
        } else if (mat[1][0] == 'X' && mat[1][1] == 'X' && mat[1][2] == '#') {
            return 1;
        } else if (mat[2][0] == 'X' && mat[2][1] == 'X' && mat[2][2] == '#') {
            return 1;
        } else if (mat[0][0] == 'X' && mat[0][1] == '#' && mat[0][2] == 'X') {
            return 1;
        } else if (mat[1][0] == 'X' && mat[1][1] == '#' && mat[1][2] == 'X') {
            return 1;
        } else if (mat[2][0] == 'X' && mat[2][1] == '#' && mat[2][2] == 'X') {

            return 1;
        } else if (mat[0][0] == '#' && mat[0][1] == 'X' && mat[0][2] == 'X') {

            return 1;
        } else if (mat[1][0] == '#' && mat[1][1] == 'X' && mat[1][2] == 'X') {

            return 1;
        } else if (mat[2][0] == '#' && mat[2][1] == 'X' && mat[2][2] == 'X') {

            return 1;
        }//fim horizontais ofensivas
        //verticais ofensivas
        else if (mat[0][0] == 'X' && mat[1][0] == 'X' && mat[2][0] == '#') { //vertical

            return 1;
        } else if (mat[0][1] == 'X' && mat[1][1] == 'X' && mat[2][1] == '#') { //vertical

            return 1;
        } else if (mat[0][2] == 'X' && mat[1][2] == 'X' && mat[2][2] == '#') { //vertical

            return 1;
        } else if (mat[0][0] == 'X' && mat[1][0] == '#' && mat[2][0] == 'X') { //vertical

            return 1;
        } else if (mat[0][1] == 'X' && mat[1][1] == '#' && mat[2][1] == 'X') { //vertical

            return 1;
        } else if (mat[0][2] == 'X' && mat[1][2] == '#' && mat[2][2] == 'X') { //vertical

            return 1;
        } else if (mat[0][0] == '#' && mat[1][0] == 'X' && mat[2][0] == 'X') { //vertical

            return 1;
        } else if (mat[0][1] == '#' && mat[1][1] == 'X' && mat[2][1] == 'X') { //vertical

            return 1;
        } else if (mat[0][2] == '#' && mat[1][2] == 'X' && mat[2][2] == 'X') { //vertical

            return 1;
            //fim verticais ofensivas
            //diagonais ofensivas
        } else if (mat[0][0] == 'X' && mat[1][1] == 'X' && mat[2][2] == '#') { //diagonal 

            return 1;
        } else if (mat[0][2] == 'X' && mat[1][1] == 'X' && mat[2][0] == '#') { //diagonal 

            return 1;
        } else if (mat[0][0] == 'X' && mat[1][1] == '#' && mat[2][2] == 'X') { //diagonal 

            return 1;
        } else if (mat[0][2] == 'X' && mat[1][1] == '#' && mat[2][0] == 'X') { //diagonal 

            return 1;
        } else if (mat[0][0] == '#' && mat[1][1] == 'X' && mat[2][2] == 'X') { //diagonal 

            return 1;
        } else if (mat[0][2] == '#' && mat[1][1] == 'X' && mat[2][0] == 'X') { //diagonal 

            return 1;
        } //fim diagonais ofensivas
        else {
            return 0;
        }
    }

    //execução da jogada ofensiva
    public char[][] jogadaOfensiva(char[][] mat) {
        //horizontais ofensivas
        if (mat[0][0] == 'X' && mat[0][1] == 'X' && mat[0][2] == '#') {
            mat[0][2] = 'X';
            return mat;
        } else if (mat[1][0] == 'X' && mat[1][1] == 'X' && mat[1][2] == '#') {
            mat[1][2] = 'X';
            return mat;
        } else if (mat[2][0] == 'X' && mat[2][1] == 'X' && mat[2][2] == '#') {
            mat[2][2] = 'X';
            return mat;
        } else if (mat[0][0] == 'X' && mat[0][1] == '#' && mat[0][2] == 'X') {
            mat[0][1] = 'X';
            return mat;
        } else if (mat[1][0] == 'X' && mat[1][1] == '#' && mat[1][2] == 'X') {
            mat[1][1] = 'X';
            return mat;
        } else if (mat[2][0] == 'X' && mat[2][1] == '#' && mat[2][2] == 'X') {
            mat[2][1] = 'X';
            return mat;
        } else if (mat[0][0] == '#' && mat[0][1] == 'X' && mat[0][2] == 'X') {
            mat[0][0] = 'X';
            return mat;
        } else if (mat[1][0] == '#' && mat[1][1] == 'X' && mat[1][2] == 'X') {
            mat[1][0] = 'X';
            return mat;
        } else if (mat[2][0] == '#' && mat[2][1] == 'X' && mat[2][2] == 'X') {
            mat[2][0] = 'X';
            return mat;
        }//fim horizontais ofensivas
        //verticais ofensivas
        else if (mat[0][0] == 'X' && mat[1][0] == 'X' && mat[2][0] == '#') { //vertical
            mat[2][0] = 'X';
            return mat;
        } else if (mat[0][1] == 'X' && mat[1][1] == 'X' && mat[2][1] == '#') { //vertical
            mat[2][1] = 'X';
            return mat;
        } else if (mat[0][2] == 'X' && mat[1][2] == 'X' && mat[2][2] == '#') { //vertical
            mat[2][2] = 'X';
            return mat;
        } else if (mat[0][0] == 'X' && mat[1][0] == '#' && mat[2][0] == 'X') { //vertical
            mat[1][0] = 'X';
            return mat;
        } else if (mat[0][1] == 'X' && mat[1][1] == '#' && mat[2][1] == 'X') { //vertical
            mat[1][1] = 'X';
            return mat;
        } else if (mat[0][2] == 'X' && mat[1][2] == '#' && mat[2][2] == 'X') { //vertical
            mat[1][2] = 'X';
            return mat;
        } else if (mat[0][0] == '#' && mat[1][0] == 'X' && mat[2][0] == 'X') { //vertical
            mat[0][0] = 'X';
            return mat;
        } else if (mat[0][1] == '#' && mat[1][1] == 'X' && mat[2][1] == 'X') { //vertical
            mat[0][1] = 'X';
            return mat;
        } else if (mat[0][2] == '#' && mat[1][2] == 'X' && mat[2][2] == 'X') { //vertical
            mat[0][2] = 'X';
            return mat;
            //fim verticais ofensivas
            //diagonais ofensivas
        } else if (mat[0][0] == 'X' && mat[1][1] == 'X' && mat[2][2] == '#') { //diagonal 
            mat[2][2] = 'X';
            return mat;
        } else if (mat[0][2] == 'X' && mat[1][1] == 'X' && mat[2][0] == '#') { //diagonal 
            mat[2][0] = 'X';
            return mat;
        } else if (mat[0][0] == 'X' && mat[1][1] == '#' && mat[2][2] == 'X') { //diagonal 
            mat[1][1] = 'X';
            return mat;
        } else if (mat[0][2] == 'X' && mat[1][1] == '#' && mat[2][0] == 'X') { //diagonal 
            mat[1][1] = 'X';
            return mat;
        } else if (mat[0][0] == '#' && mat[1][1] == 'X' && mat[2][2] == 'X') { //diagonal 
            mat[0][0] = 'X';
            return mat;
        } else if (mat[0][2] == '#' && mat[1][1] == 'X' && mat[2][0] == 'X') { //diagonal 
            mat[0][2] = 'X';
            return mat;
        } //fim diagonais ofensivas
        else {
            return mat;
        }
    }

    //teste se a situação pede a jogada defensiva
    public int testeJogadaDefensiva(char[][] mat) {
        //horizontais ofensivas
        if (mat[0][0] == 'O' && mat[0][1] == 'O' && mat[0][2] == '#') {
            return 1;
        } else if (mat[1][0] == 'O' && mat[1][1] == 'O' && mat[1][2] == '#') {
            return 1;
        } else if (mat[2][0] == 'O' && mat[2][1] == 'O' && mat[2][2] == '#') {
            return 1;
        } else if (mat[0][0] == 'O' && mat[0][1] == '#' && mat[0][2] == 'O') {
            return 1;
        } else if (mat[1][0] == 'O' && mat[1][1] == '#' && mat[1][2] == 'O') {
            return 1;
        } else if (mat[2][0] == 'O' && mat[2][1] == '#' && mat[2][2] == 'O') {
            return 1;
        } else if (mat[0][0] == '#' && mat[0][1] == 'O' && mat[0][2] == 'O') {
            return 1;
        } else if (mat[1][0] == '#' && mat[1][1] == 'O' && mat[1][2] == 'O') {
            return 1;
        } else if (mat[2][0] == '#' && mat[2][1] == 'O' && mat[2][2] == 'O') {
            return 1;
        }//fim horizontais ofensivas
        //verticais ofensivas
        else if (mat[0][0] == 'O' && mat[1][0] == 'O' && mat[2][0] == '#') { //vertical
            return 1;
        } else if (mat[0][1] == 'O' && mat[1][1] == 'O' && mat[2][1] == '#') { //vertical
            return 1;
        } else if (mat[0][2] == 'O' && mat[1][2] == 'O' && mat[2][2] == '#') { //vertical
            return 1;
        } else if (mat[0][0] == 'O' && mat[1][0] == '#' && mat[2][0] == 'O') { //vertical
            return 1;
        } else if (mat[0][1] == 'O' && mat[1][1] == '#' && mat[2][1] == 'O') { //vertical
            return 1;
        } else if (mat[0][2] == 'O' && mat[1][2] == '#' && mat[2][2] == 'O') { //vertical
            return 1;
        } else if (mat[0][0] == '#' && mat[1][0] == 'O' && mat[2][0] == 'O') { //vertical
            return 1;
        } else if (mat[0][1] == '#' && mat[1][1] == 'O' && mat[2][1] == 'O') { //vertical
            return 1;
        } else if (mat[0][2] == '#' && mat[1][2] == 'O' && mat[2][2] == 'O') { //vertical
            return 1;
            //fim verticais ofensivas
            //diagonais ofensivas
        } else if (mat[0][0] == 'O' && mat[1][1] == 'O' && mat[2][2] == '#') { //diagonal 
            return 1;
        } else if (mat[0][2] == 'O' && mat[1][1] == 'O' && mat[2][0] == '#') { //diagonal 
            return 1;
        } else if (mat[0][0] == 'O' && mat[1][1] == '#' && mat[2][2] == 'O') { //diagonal 
            return 1;
        } else if (mat[0][2] == 'O' && mat[1][1] == '#' && mat[2][0] == 'O') { //diagonal 
            return 1;
        } else if (mat[0][0] == '#' && mat[1][1] == 'O' && mat[2][2] == 'O') { //diagonal 
            return 1;
        } else if (mat[0][2] == '#' && mat[1][1] == 'O' && mat[2][0] == 'O') { //diagonal 
            return 1;
        } //fim diagonais ofensivas
        //inicio jogadas estrategicas
        else {
            return 0;
        }
    }

    //execução da jogada defensiva
    public char[][] jogadaDefensiva(char[][] mat) {
        //horizontais ofensivas
        if (mat[0][0] == 'O' && mat[0][1] == 'O' && mat[0][2] == '#') {
            mat[0][2] = 'X';
            return mat;
        } else if (mat[1][0] == 'O' && mat[1][1] == 'O' && mat[1][2] == '#') {
            mat[1][2] = 'X';
            return mat;
        } else if (mat[2][0] == 'O' && mat[2][1] == 'O' && mat[2][2] == '#') {
            mat[2][2] = 'X';
            return mat;
        } else if (mat[0][0] == 'O' && mat[0][1] == '#' && mat[0][2] == 'O') {
            mat[0][1] = 'X';
            return mat;
        } else if (mat[1][0] == 'O' && mat[1][1] == '#' && mat[1][2] == 'O') {
            mat[1][1] = 'X';
            return mat;
        } else if (mat[2][0] == 'O' && mat[2][1] == '#' && mat[2][2] == 'O') {
            mat[2][1] = 'X';
            return mat;
        } else if (mat[0][0] == '#' && mat[0][1] == 'O' && mat[0][2] == 'O') {
            mat[0][0] = 'X';
            return mat;
        } else if (mat[1][0] == '#' && mat[1][1] == 'O' && mat[1][2] == 'O') {
            mat[1][0] = 'X';
            return mat;
        } else if (mat[2][0] == '#' && mat[2][1] == 'O' && mat[2][2] == 'O') {
            mat[2][0] = 'X';
            return mat;
        }//fim horizontais ofensivas
        //verticais ofensivas
        else if (mat[0][0] == 'O' && mat[1][0] == 'O' && mat[2][0] == '#') { //vertical
            mat[2][0] = 'X';
            return mat;
        } else if (mat[0][1] == 'O' && mat[1][1] == 'O' && mat[2][1] == '#') { //vertical
            mat[2][1] = 'X';
            return mat;
        } else if (mat[0][2] == 'O' && mat[1][2] == 'O' && mat[2][2] == '#') { //vertical
            mat[2][2] = 'X';
            return mat;
        } else if (mat[0][0] == 'O' && mat[1][0] == '#' && mat[2][0] == 'O') { //vertical
            mat[1][0] = 'X';
            return mat;
        } else if (mat[0][1] == 'O' && mat[1][1] == '#' && mat[2][1] == 'O') { //vertical
            mat[1][1] = 'X';
            return mat;
        } else if (mat[0][2] == 'O' && mat[1][2] == '#' && mat[2][2] == 'O') { //vertical
            mat[1][2] = 'X';
            return mat;
        } else if (mat[0][0] == '#' && mat[1][0] == 'O' && mat[2][0] == 'O') { //vertical
            mat[0][0] = 'X';
            return mat;
        } else if (mat[0][1] == '#' && mat[1][1] == 'O' && mat[2][1] == 'O') { //vertical
            mat[0][1] = 'X';
            return mat;
        } else if (mat[0][2] == '#' && mat[1][2] == 'O' && mat[2][2] == 'O') { //vertical
            mat[0][2] = 'X';
            return mat;
            //fim verticais ofensivas
            //diagonais ofensivas
        } else if (mat[0][0] == 'O' && mat[1][1] == 'O' && mat[2][2] == '#') { //diagonal 
            mat[2][2] = 'X';
            return mat;
        } else if (mat[0][2] == 'O' && mat[1][1] == 'O' && mat[2][0] == '#') { //diagonal 
            mat[2][0] = 'X';
            return mat;
        } else if (mat[0][0] == 'O' && mat[1][1] == '#' && mat[2][2] == 'O') { //diagonal 
            mat[1][1] = 'X';
            return mat;
        } else if (mat[0][2] == 'O' && mat[1][1] == '#' && mat[2][0] == 'O') { //diagonal 
            mat[1][1] = 'X';
            return mat;
        } else if (mat[0][0] == '#' && mat[1][1] == 'O' && mat[2][2] == 'O') { //diagonal 
            mat[0][0] = 'X';
            return mat;
        } else if (mat[0][2] == '#' && mat[1][1] == 'O' && mat[2][0] == 'O') { //diagonal 
            mat[0][2] = 'X';
            return mat;
        } //fim diagonais ofensivas
        else {
            return mat;
        }
    }

    //teste se a situação pede a jogada estrategica para impedir futura derrota
    /*aqui o jogador esta prestes a usar a tatica de marcação de posições em V ou L, 
    tendo 2/3 de sua estrategia já formada, ou seja, 
    após a sua segunda jogada. Isso gera a chance de duas jogadas vitoriosas 
    possiveis posteriormente. 
    Jogando previamente numa dessas posições, ao invés de prosseguir ofensivamente 
    ou aleatoriamente, elimina as chances dele.*/
    public int testeJogadaEstrategica(char[][] mat) {
        //impedir tatica V
        if (mat[1][1] == 'O' && mat[0][0] == 'O' && mat[2][2] == 'X') {
            //mat[0][2]= 'X';
            return 1;
        } else if (mat[1][1] == 'O' && mat[0][2] == 'O' && mat[2][0] == 'X') {
            //mat[2][2]= 'X';
            return 1;
        } else if (mat[1][1] == 'O' && mat[2][2] == 'O' && mat[0][0] == 'X') {
            //mat[2][0]= 'X';
            return 1;
        } else if (mat[1][1] == 'O' && mat[2][0] == 'O' && mat[0][2] == 'X') {
            //mat[0][2]= 'X';
            return 1;
        }
        //impedir tatica L
        if (mat[1][1] == 'X' && mat[0][1] == 'O' && mat[2][2] == 'O') {
            //mat[0][2]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[0][1] == 'O' && mat[2][0] == 'O') {
            //mat[0][0]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[1][2] == 'O' && mat[0][0] == 'O') {
            //mat[0][2]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[1][2] == 'O' && mat[2][0] == 'O') {
            //mat[2][2]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[2][1] == 'O' && mat[0][0] == 'O') {
            //mat[2][0]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[2][1] == 'O' && mat[0][2] == 'O') {
            //mat[2][2]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[1][0] == 'O' && mat[0][2] == 'O') {
            //mat[0][0]= 'X';
            return 1;
        } else if (mat[1][1] == 'X' && mat[1][0] == 'O' && mat[2][2] == 'O') {
            //mat[2][0]= 'X';
            return 1;
        } else {
            return 0;
        }
    }

    //execução da jogada estrategica
    public char[][] jogadaEstrategica(char[][] mat) {
        //impedir tatica V
        if (mat[1][1] == 'O' && mat[0][0] == 'O' && mat[2][2] == 'X') {
            mat[0][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'O' && mat[0][2] == 'O' && mat[2][0] == 'X') {
            mat[2][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'O' && mat[2][2] == 'O' && mat[0][0] == 'X') {
            mat[2][0] = 'X';
            return mat;
        } else if (mat[1][1] == 'O' && mat[2][0] == 'O' && mat[0][2] == 'X') {
            mat[0][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[0][1] == 'O' && mat[2][2] == 'O') { //impedir tatica L
            mat[0][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[0][1] == 'O' && mat[2][0] == 'O') {
            mat[0][0] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[1][2] == 'O' && mat[0][0] == 'O') {
            mat[0][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[1][2] == 'O' && mat[2][0] == 'O') {
            mat[2][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[2][1] == 'O' && mat[0][0] == 'O') {
            mat[2][0] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[2][1] == 'O' && mat[0][2] == 'O') {
            mat[2][2] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[1][0] == 'O' && mat[0][2] == 'O') {
            mat[0][0] = 'X';
            return mat;
        } else if (mat[1][1] == 'X' && mat[1][0] == 'O' && mat[2][2] == 'O') {
            mat[2][0] = 'X';
            return mat;
        } else {
            return mat;
        }
    }
}
