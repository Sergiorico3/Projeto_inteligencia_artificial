package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class RecombinationOneOrder<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {


    public RecombinationOneOrder(double probability) {
        super(probability);
    }


    @Override
    public void recombine(I ind1, I ind2) {         //One order crossover
        int cut = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        for (int i = 0; i < cut; i++) {
            ind1.swapGenes(ind2, i);
        }
    }

    @Override
    public String toString(){
        return "OneOrder";
    }    
}
