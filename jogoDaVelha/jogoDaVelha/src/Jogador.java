
import javax.swing.JOptionPane;

public class Jogador {
//executa a jogada pós teste na main

    //efetua a jogada na posição determinada. os numeros 
    //do numpad representam as respectivas posições no tabuleiro
    public char[][] jogar(int jogada, char[][] mat) {
        switch (jogada) {
            case 7:
                mat[0][0] = 'O';
                return mat;
            case 8:
                mat[0][1] = 'O';
                return mat;
            case 9:
                mat[0][2] = 'O';
                return mat;
            case 4:
                mat[1][0] = 'O';
                return mat;
            case 5:
                mat[1][1] = 'O';
                return mat;
            case 6:
                mat[1][2] = 'O';
                return mat;
            case 1:
                mat[2][0] = 'O';
                return mat;
            case 2:
                mat[2][1] = 'O';
                return mat;
            case 3:
                mat[2][2] = 'O';
                return mat;
            default:
                return mat;
        }
    }

    public int testeJogada(int jogada, char[][] mat) { //teste se a jogada é valida
        switch (jogada) {
            case 7://posição ocupada?
                if (mat[0][0] == '#') {
                    return 1;
                }
                break;
            case 8://posição ocupada?
                if (mat[0][1] == '#') {
                    return 1;
                }
                break;

            case 9://posição ocupada?
                if (mat[0][2] == '#') {
                    return 1;
                }
                break;
            case 4://posição ocupada?
                if (mat[1][0] == '#') {
                    return 1;
                }
                break;
            case 5://posição ocupada?
                if (mat[1][1] == '#') {
                    return 1;
                }
                break;
            case 6://posição ocupada?
                if (mat[1][2] == '#') {
                    return 1;
                }
                break;
            case 1://posição ocupada?
                if (mat[2][0] == '#') {
                    return 1;
                }
                break;
            case 2:
                if (mat[2][1] == '#') {
                    return 1;
                }
                break;
            case 3:
                if (mat[2][2] == '#') {
                    return 1;
                }
                break;
            default:
                return 0;
        }
        return 0;
    }
}
