package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class MutationInversion<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public MutationInversion(double probability) {
        super(probability);
    }

    private int[] parent;

    @Override
    public void mutate(I ind) { //Inversion

        parent = new int[ind.getNumGenes()];

        int l = parent.length;
        for(int k = 0; k < 5; k++){//repeat process 5 times
            //get 2 random integers between 0 and size of array
            int r1 = GeneticAlgorithm.random.nextInt(l-parent[0])-parent[0];
            int r2 = GeneticAlgorithm.random.nextInt(l-parent[0])-parent[0];
            //to make sure the r1 < r2
            while(r1 >= r2)
            {
                r1 = GeneticAlgorithm.random.nextInt(l-parent[0])-parent[0];
                r2 = GeneticAlgorithm.random.nextInt(l-parent[0])-parent[0];
            }
            //this code inverts (i.e. reverses) elements between r1..r2 inclusive
            int mid = r1 + ((r2 + 1) - r1) / 2;
            int endCount = r2;
            for (int i = r1; i < mid; i++) {
                int tmp = parent[i];
                parent[i] = parent[endCount];
                parent[endCount] = tmp;
                endCount--;
            }
        }
    }

    @Override
    public String toString() {
        //TODO
        return "0";
    }
}