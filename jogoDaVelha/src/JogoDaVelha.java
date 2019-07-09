
public class JogoDaVelha {

    public char[][] matriz = new char[3][3];

    int terminado() {
        if (matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X') { //horizontal
            return 1;
        } else if (matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X') { //horizontal
            return 1;
        } else if (matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X') { //horizontal
            return 1;
        } else if (matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') { //vertical
            return 1;
        } else if (matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X') { //vertical
            return 1;
        } else if (matriz[0][2] == 'X' && matriz[1][2] == 'X' && matriz[2][2] == 'X') { //vertical
            return 1;
        } else if (matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') { //diagonal 
            return 1;
        } else if (matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[2][0] == 'X') { //diagonal 
            return 1;
        }//////////////////////////
        //condições de verificação se o jogador ganhou(obsoletas)
        else if (matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') { //horizontal
            return 3;
        } else if (matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') { //horizontal
            return 3;
        } else if (matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') { //horizontal
            return 3;
        } else if (matriz[0][0] == 'O' && matriz[1][0] == 'O' && matriz[2][0] == 'O') { //vertical
            return 3;
        } else if (matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') { //vertical
            return 3;
        } else if (matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') { //vertical
            return 3;
        } else if (matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') { //diagonal 
            return 3;
        } else if (matriz[0][2] == 'O' && matriz[1][1] == 'O' && matriz[2][0] == 'O') { //diagonal 
            return 3;
        } else { /*verificação de empate, percorre toda matriz verificando se todas posições estão ocupadas, tendo em mente que ninguém
            venceu. Retorna 0 caso o jogo ainda não tenha terminado
            */
            for (int i = 0;
                    i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matriz[i][j] == '#') {
                        return 0;
                    }
                }
            }
            //retorna 2 em caso de empate
            return 2;
        }
    }

    void iniciar() { //preenche a matriz com "#", que significa posição vazia
        for (int i = 0;
                i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '#';

            }

        }
    }

}
