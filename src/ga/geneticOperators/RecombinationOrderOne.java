package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

import java.util.Arrays;

public class RecombinationOrderOne<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {


    public RecombinationOrderOne(double probability) {
        super(probability);
    }


    @Override
    public void recombine(I ind1, I ind2) {         //Order one crossover
        int l = ind1.getNumGenes();

        int r1 = GeneticAlgorithm.random.nextInt(l);
        int r2 = GeneticAlgorithm.random.nextInt(l);

        while(r1 >= r2)
        {
            r1 = GeneticAlgorithm.random.nextInt(l);
            r2 = GeneticAlgorithm.random.nextInt(l);
        }

        int[] child1= new int[ind1.getNumGenes()];
        int[] child2= new int[ind2.getNumGenes()];

        for (int i = 0; i < ind1.getNumGenes(); i++) {
            child1[i]= ind1.getGene(i);
        }

        for (int i = 0; i < ind2.getNumGenes(); i++) {
            child2[i]= ind2.getGene(i);
        }

        int[] y = new int[child1.length-(r2-r1)+1];
        int j = 0;
        for(int i = 0; i < l; i++){
            if(!arrayContains(child1,ind2.getGene(i))){
                y[j] = ind2.getGene(i);
                j++;
            }
        }


        int[] y1 = new int[child2.length-(r2-r1)+1];
        j = 0;
        for(int i = 0; i < l; i++){
            if(!arrayContains(child2 ,ind1.getGene(i))){
                y1[j] = ind1.getGene(i);
                j++;
            }
        }

        j = 0;
        for(int i = 0; i < child1.length; i++){
            if (child1[i]==0)
            {
                child1[i]=y[i];
            }
            if (child2[i]==0)
            {
                child2[i]=y1[i];
            }
        }

        for (int i = 0; i < ind1.getNumGenes(); i++) {
            ind1.setGene(i, child1[i]);
            ind2.setGene(i, child2[i]);
        }

    }

    public static boolean arrayContains(int[] arr, int e){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == e)
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "OrderOne";
    }    
}
