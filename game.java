package myprograms.TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This is a classic TicTacToe game
 *
 * Created by Hovhannes Asatryan on 12.03.16
 */

public class game
{
    private static Cell[][] board = initializeBoard();
    private static String player = "2";
    private static byte count = 0;
    private static byte isOver = 0;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(isOver!=1 && count<9){
            player = changePlayer();
            board = makeStep();
            count++;
            isOver = isGameOver();
        }
        endTheGame();
    }

    private static Cell[][] initializeBoard(){
        Cell[][] current = new Cell[3][3];
        for(byte i=0; i<3; i++)
            for(byte j=0; j<3; j++){
                current[i][j] = new Cell();
                current[i][j].setValue(((i + 1) * 10 + j + 1)+"");
            }
        return current;
    }

    private static String changePlayer(){ return (player=="1")? "2":"1"; }

    private static Cell[][] makeStep() {
        System.out.println("Player " + player + ", please choose a cell.");
        drawTable(board);
        boolean b = false;
        while(!b){
            try{
                byte intCell = (byte) (Byte.parseByte(reader.readLine()) - 11);
                if (board[intCell / 10][intCell % 10].isEmpty()){
                    String character = (player == "1") ? "X" : "O";
                    board[intCell / 10][intCell % 10].fillTheCell();
                    board[intCell / 10][intCell % 10].setValue(character);
                    b = true;
                }
                else{
                    System.out.println("The cell was used! Player "+player+"! Choose correct cell!");
                    drawTable(board);
                }
            } catch(Exception e){
                System.out.println("Player "+player+", please choose correct cell!");
                drawTable(board);
            }
        }
        return board;
    }

    private static void drawTable(Cell[][] cells){
        System.out.println(" ");
        for(byte i=0;i<3;i++){
            System.out.println(" "+cells[i][0].getValue()+" | " +cells[i][1].getValue()+ " | " +cells[i][2].getValue()+" ");
            System.out.println("-------------");
        }
        System.out.println(" ");
    }

    private static byte isGameOver(){
        for (byte j = 0; j < 3; j++){
            if (board[j][0].getValue() == board[j][1].getValue() && board[j][1].getValue() == board[j][2].getValue())
                isOver = 1;
            else if (board[0][j].getValue() == board[1][j].getValue() && board[1][j].getValue() == board[2][j].getValue())
                isOver = 1;
        }
        if( (board[0][0].getValue()==board[1][1].getValue() && board[1][1].getValue()==board[2][2].getValue())
                || (board[2][0].getValue()==board[1][1].getValue() && board[1][1].getValue()==board[0][2].getValue()))
            isOver = 1;
        return isOver;
    }

    private static void endTheGame() throws IOException {
        if (isOver==0 && count==9)
            System.out.println("Game is over! Draw");
        else
            System.out.println("Player " + player + " win!");
        drawTable(board);
        reader.close();
    }
}
