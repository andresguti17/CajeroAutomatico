/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageStrategy;

import packageObserver.Continent;

/**
 *
 * @author diang
 */
public class PremiumFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(Continent continent) {
        return switch (continent) {
            case AMERICA -> 1.0;
            case EUROPE -> 1.5;
            case ASIA -> 2.0;
            case AFRICA -> 2.5;
            case OCEANIA -> 3.0;
            default -> 3.5;
        };
    }
    
}
