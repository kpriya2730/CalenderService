package factory;

import model.CreateEventStrategyType;
import strategy.createeventstrategy.CreateEventConflictsUncheckedStrategy;
import strategy.createeventstrategy.CreateEventStrategy;
import strategy.createeventstrategy.CreateEventConflictsCheckedStrategy;

public class CreateEventStrategyFactory {

    public static CreateEventStrategy getCreateEventStrategy(CreateEventStrategyType type){

        switch (type){
            case CONFLICTS_UNCHECKED -> new CreateEventConflictsUncheckedStrategy();
            case CONFLICTS_CHECKED -> new CreateEventConflictsCheckedStrategy();
        }
        return new CreateEventConflictsUncheckedStrategy();
    }
}
