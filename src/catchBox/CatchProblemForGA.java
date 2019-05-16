package catchBox;

import ga.GeneticAlgorithm;
import ga.Problem;

import java.util.LinkedList;
import java.util.Random;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    //TODO this class might require the definition of additional methods and/or attributes
    protected CatchProblemForGA problem;
    protected int size;
    protected LinkedList<Pair> pairs;
    protected Cell cellCatch;
    protected Cell door;
    protected LinkedList<Cell> cellsBoxes;


    public CatchProblemForGA(LinkedList<Pair> pairs, Cell cellCatch, Cell door, LinkedList<Cell> cellsBoxes) {
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
        return new CatchIndividual(problem, size);
    }

    @Override
    public String toString() {
        //TODO
        return "Problema: " + problem + "\n";
    }
}
