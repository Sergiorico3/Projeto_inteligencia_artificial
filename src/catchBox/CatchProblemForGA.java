package catchBox;

import ga.Problem;

import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    protected LinkedList<Pair> pairs;
    protected Cell cellCatch;
    protected Cell door;
    protected LinkedList<Cell> cellsBoxes;


    public CatchProblemForGA(LinkedList<Cell> cellsBoxes, LinkedList<Pair> pairs, Cell cellCatch, Cell door) {
        this.pairs = pairs;
        this.cellCatch = cellCatch;
        this.door = door;
        this.cellsBoxes = cellsBoxes;
    }

    public LinkedList<Pair> getPairs() {
        return pairs;
    }

    @Override
    public CatchIndividual getNewIndividual() {
        return new CatchIndividual(this, cellsBoxes.size());

    }

    @Override
    public String toString() {
        return "Problema: " + this + "\n";
    }

    public Cell getCellCatch() {
    return this.cellCatch;
    }

    public LinkedList getCellBoxes() {
        return this.cellsBoxes;
    }

    public Cell getCellDoor() {
        return this.door;
    }
}
