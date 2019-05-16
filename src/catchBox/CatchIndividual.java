package catchBox;

import ga.IntVectorIndividual;

public class CatchIndividual extends IntVectorIndividual<CatchProblemForGA, CatchIndividual> {

    public CatchIndividual(CatchProblemForGA problem, int size) {
        super(problem, size);
    }

    public CatchIndividual(CatchIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
        Cell cell1;
        Cell cell2;
        int fitness=0;

        cell1 = problem.cellCatch(genome[0]);

        fitness=getPairDistance(problem.cellCatch, problem.cellsBoxes[0]-1);

        for (int i = 0; i < problem.cellsBoxes.size() ; i++) {
            cell2 = problem.cellCatch(genome[i+1]-1);

            fitness += getPairDistance(cell1,cell2);
        }


        return fitness;
    }

    public int[] getGenome() {
        return genome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fitness: ");
        sb.append(fitness);
        sb.append("\npath: ");
        for (int i = 0; i <genome.length ; i++) {
            sb.append(genome[i]).append(" ");
        }
        return sb.toString();
    }

    public int getPairDistance(Cell cell1, Cell cell2) {
        for (Pair pair : problem.getPairs()) {
            if (pair.getCell1() == cell1 && pair.getCell2() == cell2 || cell2 == pair.getCell1() && cell1 == pair.getCell2()) {
                return pair.getValue();
            }
        }
        return -1;
    }


    /**
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and
     * 0, otherwise.
     */
    @Override
    public int compareTo(CatchIndividual i) {
        return (this.fitness == i.getFitness()) ? 0 : (this.fitness < i.getFitness()) ? 1 : -1;
    }

    @Override
    public CatchIndividual clone() {
        return new CatchIndividual(this);

    }
}
