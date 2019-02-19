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
public class ComplexMatrix {

    private ArrayList<ComplexVector> elementos;
    private int columns;
    private int rows;
    
    public ComplexMatrix(){
        this.columns = 0;
        this.rows = 0;
        elementos = new ArrayList<ComplexVector>();
    }
    
    public ArrayList<ComplexVector> getElementos() {
        return elementos;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
    
    public void addElement (ComplexVector vector) throws Exception{
        if (this.elementos.size()>0){
            if(elementos.get(0).getSize() == vector.getSize()){
                this.elementos.add(vector);
            }
            else{
                throw new Exception("Column size doesn't match");
            }
        }
        else{
            this.elementos.add(vector);
            this.columns = vector.getSize();
        }
        rows++;
    }
    
    
    
}
