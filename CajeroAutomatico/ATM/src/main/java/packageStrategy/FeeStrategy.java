/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package packageStrategy;

import packageObserver.Continent;

/**
 *
 * @author diang
 */
public interface FeeStrategy {
    public double calculateFee(Continent continent);
}
