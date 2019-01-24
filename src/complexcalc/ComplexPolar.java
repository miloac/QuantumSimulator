/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalc;

/**
 *
 * @author 2116177
 */
public class ComplexPolar {

    
    double magnitude;
    double phase;
    
    public ComplexPolar(double mag, double ph){
        this.magnitude = mag;
        this.phase = ph;
    }
    
    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getPhase() {
        return phase;
    }

    public void setPhase(double phase) {
        this.phase = phase;
    }
    
    public String toString(){
        return("ρ: " + this.magnitude + " θ: " + this.phase);
    }
}
