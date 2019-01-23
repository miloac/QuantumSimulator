/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalc;
import java.lang.Math.*;

/**
 *
 * @author 2116177
 */
public class ComplexCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Complex num1 = new Complex (3, -2);
        Complex num2 = new Complex (1, 2);
        System.out.println("Complex Number Calculator");
        System.out.println("Number 1 is "+ num1.toString());
        System.out.println("Number 2 is "+ num2.toString());
        /* Complex sum = compSum(num1,num2);
        System.out.println("Sum is " + (compSum(num1,num2).toString())); */
    }
    
    public Complex compSum(Complex num1, Complex num2){
        return new Complex(num1.getRealP()+num2.getRealP(), num1.getImaginP() + num2.getImaginP());
    }
    
    public Complex compProd(Complex num1, Complex num2){
        double a1 = num1.getRealP();
        double a2 = num1.getImaginP();
        double b1 = num1.getRealP();
        double b2 = num1.getImaginP();
        return new Complex(a1*a2 - b1*b2, a1-b2 + a2*b1);
    }
    
    public Complex compRest(Complex num1, Complex num2){
        return new Complex(num1.getRealP()-num2.getRealP(), num1.getImaginP() - num2.getImaginP());
    }
    
    public Complex compDiv(Complex num1, Complex num2){
        double a1 = num1.getRealP();
        double a2 = num1.getImaginP();
        double b1 = num1.getRealP();
        double b2 = num1.getImaginP();
        double divisor = a2 * a2 + b2 * b2;
        double divid1 = a1 * a2 + b1 * b2;
        double divid2 = a2 * b1 - a1 * b2;
        return new Complex(divid1 / divisor , divid2/divisor);
    }
    
    public double modulus(Complex num){
        double res = Math.sqrt(num.getRealP() * num.getRealP() + num.getImaginP() * num.getImaginP());
        return res;
    }
    
    public Complex conjugate(Complex num){
        return new Complex(num.getRealP(), -(num.getImaginP()));
    }
    
    public ComplexPolar cartesianToPolar(Complex num){
        double mag = modulus(num);
        double phase = Math.atan2(num.getRealP(), num.getImaginP());
        return new ComplexPolar(mag, phase);
    }
    
    public Complex polarToCartesian(ComplexPolar polar){
        double real = polar.getMagnitude() * Math.cos(polar.getPhase());
        double img = polar.getMagnitude() * Math.sin(polar.getPhase());
        return new Complex(real,img);
    } 
    
    
    public double getPolarPhase(Complex num){
        ComplexPolar polar =(cartesianToPolar(num));
        return polar.getPhase();
    }
    
}
