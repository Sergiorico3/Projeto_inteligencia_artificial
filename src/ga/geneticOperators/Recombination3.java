package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Recombination3<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination3(double probability) {
        super(probability);
    }

    private int[] a;
    private int[] b;

    @Override
    public void recombine(I ind1, I ind2) {         //uniform crossover

        a = new int[ind1.getNumGenes()];
        b = new int[ind2.getNumGenes()];

        for (int i = 0; i < a.length ; i++) {
            if(GeneticAlgorithm.random.nextInt() < probability){
                int tmp = a[i];
                a[i] = b[i];
                b[i] = tmp;
            }
        }
    }

    @Override
    public String toString(){
        return "Uniform Crossover";
    }    
}