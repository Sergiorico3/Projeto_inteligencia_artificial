package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class RecombinationUniform<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {


    public RecombinationUniform(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {         //uniform crossover

        for (int i = 0; i < ind1.getNumGenes() ; i++) {
            if(GeneticAlgorithm.random.nextInt() < probability) {
                int temp = ind1.getGene(i);

                ind1.setGene(ind1.getGene(i), ind2.getGene(i));

                ind1.setGene(ind2.getGene(i), temp);
            }
        }
    }

    @Override
    public String toString(){
        return "Uniform";
    }    
}