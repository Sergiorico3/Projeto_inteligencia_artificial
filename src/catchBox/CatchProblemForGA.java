package catchBox;

import ga.GeneticAlgorithm;
import ga.Problem;

import java.util.LinkedList;
import java.util.Random;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    //TODO this class might require the definition of additional methods and/or attributes
    public CatchProblemForGA problem;
    public int size;
    public LinkedList<Pair> pairs;
    public Cell cellCatch;
    public Cell door;
    public LinkedList<Cell> cellsBoxes;


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
        return new CatchIndividual(problem, size);
    }

    @Override
    public String toString() {
        //TODO
        return "Problema: " + problem + "\n";
    }
}
