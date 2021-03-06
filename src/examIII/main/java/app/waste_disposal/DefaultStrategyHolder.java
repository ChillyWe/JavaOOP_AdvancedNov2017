package exam_preparations.examIII.main.java.app.waste_disposal;



import exam_preparations.examIII.main.java.app.waste_disposal.contracts.GarbageDisposalStrategy;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {
    private LinkedHashMap<Class,GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder(){
        this.strategies = new LinkedHashMap<>();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if (this.strategies.containsKey(annotationClass)) {
            return false;
        }

        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if (!this.strategies.containsKey(annotationClass)) {
            return false;
        }
        this.strategies.remove(annotationClass);
        return true;
    }
}
