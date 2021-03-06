package catchBox;

import agentSearch.Action;
import agentSearch.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {

    protected int[][] matrix;
    protected int lineCatch;
    protected int columnCatch;
    private int steps;
    private int lineDoor;
    private int columnDoor;

    public CatchState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];

                if(matrix[i][j] == Properties.CATCH){
                    lineCatch=i;
                    columnCatch=j;
                }

                if (matrix[i][j] == Properties.DOOR){
                    lineDoor=i;
                    columnDoor=j;
                }
            }
        }
    }

    public void executeAction(Action action) {
        action.execute(this);
        steps++;
        fireUpdatedEnvironment();

    }

    public boolean canMoveUp(){
        if(lineCatch==0){
            return false;
        }

        if(matrix[lineCatch-1][columnCatch] == Properties.WALL){
            return false;
        }

        return true;
    }
    public boolean canMoveLeft() {
        if(columnCatch==0){
            return false;
        }

        if(matrix[lineCatch][columnCatch-1] == Properties.WALL){
            return false;
        }

        return true;
    }

    public boolean canMoveRight() {
        if(columnCatch== matrix.length-1){
            return false;
        }

        if(matrix[lineCatch][columnCatch+1] == Properties.WALL){
            return false;
        }

        return true;
    }


    public boolean canMoveDown(){
        if(lineCatch==matrix.length-1){
            return false;
        }

        if(matrix[lineCatch+1][columnCatch] == Properties.WALL){
            return false;
        }

        return true;
    }

    public void moveUp() {
        matrix[lineCatch][columnCatch]= Properties.EMPTY;
        matrix[--lineCatch][columnCatch]= Properties.CATCH;
    }

    public void moveRight() {
        matrix[lineCatch][columnCatch]= Properties.EMPTY;
        matrix[lineCatch][++columnCatch]= Properties.CATCH;
    }

    public void moveDown() {
        matrix[lineCatch][columnCatch]= Properties.EMPTY;
        matrix[++lineCatch][columnCatch]= Properties.CATCH;
    }

    public void moveLeft() {
        matrix[lineCatch][columnCatch]= Properties.EMPTY;
        matrix[lineCatch][--columnCatch]= Properties.CATCH;
    }

    public int getNumBox() {
        int numBoxes=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == Properties.BOX){
                    numBoxes++;
                }
            }
        }
        return numBoxes;
    }

    public void setCellCatch(int line, int column) {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;

        this.lineCatch = line;
        this.columnCatch = column;

        matrix[line][column] = Properties.CATCH;


    }

    public int[][] getMatrix() {
        return matrix;
    }



    public int getSteps(){
        return steps;
    }

    public int getSize() {
        return matrix.length;
    }

    public Color getCellColor(int line, int column) {
        switch (matrix[line][column]) {
            case Properties.BOX:
                return Properties.COLORBOX;
            case Properties.CATCH:
                return Properties.COLORCATCH;
            case Properties.DOOR:
                return Properties.COLORDOOR;
            case Properties.WALL:
                return Properties.COLORWALL;
            default:
                return Properties.COLOREMPTY;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatchState)) {
            return false;
        }

        CatchState o = (CatchState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public CatchState clone() {
        return new CatchState(matrix);
    }

    //Listeners
    private final ArrayList<EnvironmentListener> listeners = new ArrayList<>();

    public synchronized void addEnvironmentListener(EnvironmentListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public synchronized void removeEnvironmentListener(EnvironmentListener l) {
        listeners.remove(l);
    }

    public void fireUpdatedEnvironment() {
        for (EnvironmentListener listener : listeners) {
            listener.environmentUpdated();
        }
    }

    public double computeDistance(Cell goalPosition) {
        return Math.abs(goalPosition.getLine() - lineCatch) + Math.abs(goalPosition.getColumn()- columnCatch);
    }
}
