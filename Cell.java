package myprograms.TicTacToe;

/**
 * Created by Hovhannes Asatryan on 12.03.16
 */
public class Cell {
    private String value;
    private boolean CELL_IS_EMPTY;

    public String getValue(){ return value; }
    public void setValue(String newValue) { this.value=newValue; }
    public boolean isEmpty(){return CELL_IS_EMPTY;}
    public void fillTheCell(){ this.CELL_IS_EMPTY = false; }

    public Cell() {
        this.value="";
        this.CELL_IS_EMPTY=true;
    }
}
