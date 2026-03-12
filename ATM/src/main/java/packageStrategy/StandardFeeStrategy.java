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
public class StandardFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(Continent continent) {
        return switch (continent) {
            case AMERICA -> 2.0;
            case EUROPE -> 3.0;
            case ASIA -> 3.5;
            case AFRICA -> 4.0;
            case OCEANIA -> 4.5;
            default -> 5.0;
        };
    }
    
}
