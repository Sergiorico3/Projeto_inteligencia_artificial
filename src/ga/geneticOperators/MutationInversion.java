package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class MutationInversion<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public MutationInversion(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) { //Inversion mutation
        int l=ind.getNumGenes();
        int startPos = 0;
        int endPos = 0;

        // Loop forever until we have suitable cut point numbers
        while (true){
            startPos = GeneticAlgorithm.random.nextInt(l);
            endPos = GeneticAlgorithm.random.nextInt(l);
            if(startPos < endPos){
                break;
            }
        }
        // Reverse the numbers between cut off points
        int reverse = endPos;
        int temp = 0;
        for(int i = startPos; i < reverse; i++){
            temp = ind.getGene(i+1);
            ind.setGene(i+1, ind.getGene(reverse));
            ind.setGene(reverse,temp);
            reverse--;
        }
    }

    @Override
    public String toString() {
        return "MutationInversion";
    }
}