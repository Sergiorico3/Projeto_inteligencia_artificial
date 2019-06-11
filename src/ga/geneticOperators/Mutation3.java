package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) { //Inversion
        //TODO
    }

    @Override
    public String toString() {
        //TODO
        return "0";
    }
}