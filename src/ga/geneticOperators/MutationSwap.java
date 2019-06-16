package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class MutationSwap<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public MutationSwap(double probability) {
        super(probability);
    }



    @Override
    public void mutate(I ind) {         //SWAP
        int l=ind.getNumGenes();

        //get 2 random integers between 0 and size of array
        int r1 = GeneticAlgorithm.random.nextInt(l);
        int r2 = GeneticAlgorithm.random.nextInt(l);
        //to make sure the 2 numbers are different
        while(r1 == r2){
            r2 = GeneticAlgorithm.random.nextInt(l);
        }

        //swap array elements at those indices
        int temp = ind.getGene(r1);
        ind.setGene(r1,ind.getGene(r2));
        ind.setGene(r2,temp);
    }

    @Override
    public String toString() {
        return "Mutation Swap";
    }
}