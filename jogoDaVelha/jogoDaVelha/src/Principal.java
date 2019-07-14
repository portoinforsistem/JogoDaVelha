/*Descrição: implementar, em Java, um Jogo da Velha (modo console/texto) em que o usuário deverá 
jogar contra o computador. Sempre o usuário iniciará a jogada, porém o computador jamais 
deverá sofrer uma derrota. Utilize todos os conceitos disponíveis 
da orientação objetos para atingir tal objetivo.
Alguns mecanismos de controle do sistema são necessários, tais como: 1) não permitir 
que o usuário realize uma jogada que já tenha sido realizada, ou seja, não escolher 
uma posição já preenchida; 
2) verificar se houve vitória ou empate e sinalizar o vencedor; 
3) etc.*/

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        //indica a posição onde se deseja jogar pelo numpad do teclado,
        //os numeros de 1 a 9 representam a respectiva posição
        int jogada;
        
        //instancia da classe jogodavelha
        JogoDaVelha jogo = new JogoDaVelha();
        
        //função que preenche o tabuleiro com caracteres que indicam vazio
        jogo.iniciar();
        
        //instancia de jogador
        Jogador jogador = new Jogador();
        
        //instancia de adversario(computador)
        Computador computador = new Computador();
        
        //variavel contadora de jogadas do jogador par referencia
        int qtJogada = 0;
        
         //primeira exibição do tabuleiro
            exibir(jogo.matriz);            
            System.out.println("------");
        
        //loop de repetição para jogadas, o jogador sempre começa jogando
        //variavel status do jogo, não
        //é bool pois teoricamente há três possibilidades
        while (jogo.terminado() == 0) { 
            while (true) { //loop de repetição para jogadas do jogador
                //escolha da posição no tabuleiro
                jogada = Integer.parseInt(JOptionPane.showInputDialog
                         ("Digite um número de 1 a 9 para sua jogada:"));
                //try catch para o valor inserido
                try {
                    //retorna 1 se for uma posição não ocupada
                    if (jogador.testeJogada(jogada, jogo.matriz) == 1) {
                        //executa a jogada na posição em questão
                        jogo.matriz = jogador.jogar(jogada, jogo.matriz);
                        //quebra o loop e segue com o jogo
                        break;                        
                    } else {//caso a posição já esteja ocupada
                        JOptionPane.showMessageDialog
                        (null, "Opção inválida, tente novamente");
                    }
                //caso o valor inserido não for um
                //numero inteiro, positivo ou entre 1 e 9, etc
                } catch (Exception e) { 
                    JOptionPane.showMessageDialog
                    (null, "Opção inválida, tente novamente");
                }
            }
            //incrementa a quantidade de jogadas
            qtJogada++;
            
            //realiza o teste se o jogador não concluiu o jogo ou
            //preencheu a última posição possível no tabuleiro            
            //quebra o ciclo caso o jogo tenha terminado
            if(jogo.terminado() != 0){ 
                break;
            }
            //exibe a matriz do tabuleiro
            exibir(jogo.matriz);            
            System.out.println("------");
            
            //jogada do computador
            jogo.matriz = computador.jogar(jogo.matriz, qtJogada);
            //exibe a matriz do tabuleiro
            exibir(jogo.matriz);
            System.out.println("------");
        }
        //exibe o rsultado do jogo
        System.out.println("------");
        exibir(jogo.matriz);
        
        //resultado do jogo
        switch (jogo.terminado()) {
            case 1:
                System.out.println("\nO computador venceu.");
                break;
            case 3:
                System.out.println("\nO jogador venceu");
                break;
            case 2:
                System.out.println("\nEmpate");
                break;
            default:
                break;
        }
    }

    //função de exibição da matriz do tabuleiro
    static void exibir(char[][] mat) {
       //percorre todos os indices da matriz com um loop dentro de outro
        for (int linhas = 0; linhas < 3; linhas++) {
            for (int colunas = 0; colunas < 3; colunas++) {
                //espaçamento entre campos do tabuleiro
                System.out.print(mat[linhas][colunas] + " "); 
            }
            //nova linha para linha seguinte da matriz
            System.out.println("\n");
        }
    }

}
