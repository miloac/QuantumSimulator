/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalc;

import java.util.ArrayList;

/**
 *
 * @author 2116177
 */
public class ComplexVector {

    private ArrayList<Complex> elementos;
    private int size;
    
    public ComplexVector(){
        this.size =0;
        elementos = new ArrayList<Complex>();
    }
    
    public ArrayList<Complex> getElementos() {
        return elementos;
    }


    public int getSize() {
        this.size = elementos.size();
        return size;
    }

    
    public void addElement(Complex num){
        this.elementos.add(num);
        this.size= size + 1;
    }    
    
}
