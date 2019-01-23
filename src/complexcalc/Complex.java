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
public class Complex {

    double realP;
    double imaginP;
    
    public Complex(double real, double imag){
        this.realP = real;
        this.imaginP = imag;
    }
    
    public double getRealP() {
        return realP;
    }

    public void setRealP(double realP) {
        this.realP = realP;
    }

    public double getImaginP() {
        return imaginP;
    }

    public void setImaginP(double imaginP) {
        this.imaginP = imaginP;
    }
    
    public String toString(){
        String resp = Double.toString(realP);
        resp = resp + " ";
        if(this.imaginP > 0){
            resp = resp + "+ ";
        }
        resp = resp + Double.toString(imaginP) + " i";
        return resp;
    }
    
}
