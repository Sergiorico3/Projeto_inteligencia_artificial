package catchBox;

import agentSearch.Action;
import agentSearch.Problem;
import agentSearch.State;

import java.util.LinkedList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes

    private List<Action> actions;
    private Cell goalPosition;

    public Cell getGoalPosition() {
        return goalPosition;
    }

    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        this.goalPosition = goalPosition;

        actions = new LinkedList<Action>() {{
            add(new ActionDown());
            add(new ActionUp());
            add(new ActionRight());
            add(new ActionLeft());
        }};

    }

    @Override
    public List<S> executeActions(S state) {
        //TODO
        List<S> successors = new LinkedList<>();
        for (Action action : actions) {
            if (action.isValid(state)) {
                S sucessor = (S) state.clone();
                action.execute(sucessor);
                successors.add(sucessor);
            }
        }
        return successors;
    }

    public boolean isGoal(S state) {
        return state.lineCatch == goalPosition.getLine() && state.columnCatch == goalPosition.getColumn();
    }
}
