package catchBox;

import ga.GeneticAlgorithm;
import ga.Problem;

import java.util.LinkedList;
import java.util.Random;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    //TODO this class might require the definition of additional methods and/or attributes
    protected CatchProblemForGA problem;
    protected int size;

    public CatchProblemForGA(
            LinkedList<Cell> cellsBoxes,
            LinkedList<Pair> pairs,
            Cell cellCatch,
            Cell door) {
        super();

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
