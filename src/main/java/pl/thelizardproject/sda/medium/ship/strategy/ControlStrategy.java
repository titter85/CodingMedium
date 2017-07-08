package pl.thelizardproject.sda.medium.ship.strategy;

/**
 * Created by Dominik on 06-07-2017.
 */
public abstract class ControlStrategy {
    String strategyDefinition;

    public void setStrategyDefinition(String strategyDefinition) {
        this.strategyDefinition = strategyDefinition;
    }

    public String getStrategyDefinition() {
        return strategyDefinition;
    }
}
