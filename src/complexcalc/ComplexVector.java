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

    private ArrayList elementos;
    private int size;
    
    public ComplexVector(){
        this.size =0;
    }
    
    public ArrayList getElementos() {
        return elementos;
    }


    public int getSize() {
        return size;
    }

    
    public void addElement(Complex num){
        this.elementos.add(num);
        size++;
    }    
    
}
