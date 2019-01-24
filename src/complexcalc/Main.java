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
public class Main {
    public static void main(String[] args) {
        ComplexCalc calculadora = new ComplexCalc();
        //Set the values of the numbers you wish to operate here
        Complex num1 = new Complex (3, -2);
        Complex num2 = new Complex (1, 2);
        System.out.println("Complex Number Calculator");
        System.out.println("Number 1 is "+ num1.toString());
        System.out.println("Number 2 is "+ num2.toString());
        Complex sum = calculadora.compSum(num1,num2);
        System.out.println("Sum is " + (sum.toString()));
        Complex prod = calculadora.compProd(num1,num2);
        System.out.println("Product is " + (prod.toString()));
        Complex rest = calculadora.compRest(num1,num2);
        System.out.println("Rest is " + (rest.toString()));
        Complex divi = calculadora.compDiv(num1,num2);
        System.out.println("Division is " + (divi.toString()));
        double mod1 = calculadora.modulus(num1);
        System.out.println("The modulus of number 1 is " + mod1);
        Complex conj = calculadora.conjugate(num1);
        System.out.println("The conjugate of number 1 is " + (conj.toString()));
        ComplexPolar polar = calculadora.cartesianToPolar(num1);
        System.out.println("Number 1 in polar coordinates is " + (polar.toString()));
        Complex cart = calculadora.polarToCartesian(polar);
        System.out.println("Converting back to cartesian we get " + (cart.toString()));
        double phase = calculadora.getPolarPhase(num2);
        System.out.println("The phase of number 2 is " + phase);
    }
}
