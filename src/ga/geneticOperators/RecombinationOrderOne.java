package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class RecombinationOrderOne<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public RecombinationOrderOne(double probability) {
        super(probability);
    }

    private int[] parent1;
    private int[] parent2;

    @Override
    public void recombine(I ind1, I ind2) {

        parent1 = new int[ind1.getNumGenes()];
        parent2 = new int[ind2.getNumGenes()];

        int l = parent1.length;

        //get 2 random ints between 0 and size of array
        int r1 = GeneticAlgorithm.random.nextInt(l-parent1[0])-parent1[0];
        int r2 = GeneticAlgorithm.random.nextInt(l-parent1[0])-parent1[0];
        //to make sure the r1 < r2
        while(r1 >= r2)
        {
            r1 = GeneticAlgorithm.random.nextInt(l-parent1[0])-parent1[0];
            r2 = GeneticAlgorithm.random.nextInt(l-parent1[0])-parent1[0];
        }
        //create the child .. initial elements are -1
        int[] child = new int[l];
        for(int i = 0; i < l; i++){
            child[i] = -1;
        }

        //copy elements between r1, r2 from parent1 into child
        for(int i = r1; i <= r2; i++){
            child[i] = parent1[i];
        }

        //array to hold elements of parent1 which are not in child yet
        int[] y = new int[l-(r2-r1)-1];
        int j = 0;
        for(int i = 0; i < l; i++){
            if(!arrayContains(child,parent1[i])){
                y[j] = parent1[i];
                j++;
            }
        }
        //rotate parent2
        //number of places is the same as the number of elements after r2
        int[] copy = parent2.clone();
        rotate(copy, l-r2-1);

        //now order the elements in y according to their order in parent2
        int[] y1 = new int[l-(r2-r1)-1];
        j = 0;
        for(int i = 0; i < l; i++){
            if(arrayContains(y,copy[i])){
                y1[j] = copy[i];
                j++;
            }
        }
        //now copy the remaining elements (i.e. remaining in parent1) into child
        //according to their order in parent2 .. starting after r2!
        j = 0;
        for(int i = 0; i < y1.length; i++){
            int ci = (r2 + i + 1) % l;// current index
            child[ci]=y1[i];
        }
    }

    public static boolean arrayContains(int[] arr, int e){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == e)
                return true;
        }
        return false;
    }

    public static void rotate(int[] arr, int order) {
        int offset = arr.length - order % arr.length;
        if (offset > 0) {
            int[] copy = arr.clone();
            for (int i = 0; i < arr.length; ++i) {
                int j = (i + offset) % arr.length;
                arr[i] = copy[j];
            }
        }
    }

    @Override
    public String toString(){
        return "OrderOne crossover";
    }    
}
