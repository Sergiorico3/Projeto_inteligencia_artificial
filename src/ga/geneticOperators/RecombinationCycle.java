package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecombinationCycle<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    private boolean randomStart;

    public RecombinationCycle(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {         //Cycle crossover

        final int length = ind1.getNumGenes();

        // and of the children: do a crossover copy to simplify the later processing
        int[] child1= new int[ind1.getNumGenes()];
        int[] child2= new int[ind2.getNumGenes()];

        for (int i = 0; i < ind1.getNumGenes(); i++) {
            child1[i]= ind1.getGene(i);
        }

        for (int i = 0; i < ind2.getNumGenes(); i++) {
            child2[i]= ind2.getGene(i);
        }

        // the set of all visited indices so far
        final Set<Integer> visitedIndices = new HashSet<>(length);
        // the indices of the current cycle
        final List<Integer> indices = new ArrayList<>(length);

        // determine the starting index
        int idx = randomStart ? GeneticAlgorithm.random.nextInt(length) : 0;
        int cycle = 1;

        while (visitedIndices.size() < length) {
            indices.add(idx);

            int item = ind2.getGene(idx);
            idx = ind1.getIndexof(item);

            while (idx != indices.get(0)) {
                // add that index to the cycle indices
                indices.add(idx);
                // get the item in the second parent at that index
                item = ind2.getGene(idx);
                // get the index of that item in the first parent
                idx = ind1.getIndexof(item);
            }

            // for even cycles: swap the child elements on the indices found in this cycle
            if (cycle++ % 2 != 0) {
                for (int i : indices) {
                    int tmp = child1[i];
                    child1[i] = child2[i];
                    child2[i] = tmp;
                }
            }

            visitedIndices.addAll(indices);
            // find next starting index: last one + 1 until we find an unvisited index
            idx = (indices.get(0) + 1) % length;
            while (visitedIndices.contains(idx) && visitedIndices.size() < length) {
                idx++;
                if (idx >= length) {
                    idx = 0;
                }
            }
            indices.clear();
        }
    }

    @Override
    public String toString(){
        return "Cycle";
    }    
}