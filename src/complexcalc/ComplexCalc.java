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

    public static Complex compSum(Complex num1, Complex num2){
        return new Complex(num1.getRealP()+num2.getRealP(), num1.getImaginP() + num2.getImaginP());
    }
    
     public static Complex compProd(Complex num1, Complex num2){
        double a1 = num1.getRealP();
        double b1 = num1.getImaginP();
        double a2 = num2.getRealP();
        double b2 = num2.getImaginP();
        return new Complex((a1*a2) - (b1*b2), (a1*b2) + (a2*b1));
    }
    
     public static Complex compRest(Complex num1, Complex num2){
        return new Complex(num1.getRealP()-num2.getRealP(), num1.getImaginP() - num2.getImaginP());
    }
    
     public static Complex compDiv(Complex num1, Complex num2){
        double a1 = num1.getRealP();
        double b1 = num1.getImaginP();
        double a2 = num2.getRealP();
        double b2 = num2.getImaginP();
        double divisor = a2 * a2 + b2 * b2;
        double divid1 = a1 * a2 + b1 * b2;
        double divid2 = a2 * b1 - a1 * b2;
        return new Complex(divid1 / divisor , divid2/divisor);
    }
    
     public static double modulus(Complex num){
        double res = Math.sqrt( (num.getRealP() * num.getRealP()) + (num.getImaginP() * num.getImaginP()) );
        return res;
    }
    
     public static Complex conjugate(Complex num){
        return new Complex(num.getRealP(), -(num.getImaginP()));
    }
    
     public static ComplexPolar cartesianToPolar(Complex num){
        double mag = modulus(num);
        mag = Math.round(mag*100.0)/100.0;
        double phase = Math.atan2(num.getRealP(), num.getImaginP());
        phase = Math.round(phase*100.0)/100.0;
        return new ComplexPolar(mag, phase);
    }
    
     public static Complex polarToCartesian(ComplexPolar polar){
        double img = polar.getMagnitude() * Math.cos(polar.getPhase());
        img = Math.round(img*100.0)/100.0;
        double real = polar.getMagnitude() * Math.sin(polar.getPhase());
        real = Math.round(real*100.0)/100.0;
        return new Complex(real,img);
    } 
    
    
     public static double getPolarPhase(Complex num){
        ComplexPolar polar =(cartesianToPolar(num));
        return polar.getPhase();
    }
    
    
     public static ComplexVector vectorSum(ComplexVector vector1, ComplexVector vector2){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <vector1.getSize(); i++){
            res.addElement(compSum(vector1.getElementos().get(i),vector2.getElementos().get(i)));
        }
        return res;
    }
     
     public static ComplexVector vectorRest(ComplexVector vector1, ComplexVector vector2){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <vector1.getSize(); i++){
            res.addElement(compRest(vector1.getElementos().get(i),vector2.getElementos().get(i)));
        }
        return res;
    }
    
     public static ComplexVector vectorInverse(ComplexVector v){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <v.getSize(); i++){
            res.addElement(new Complex(-(v.getElementos().get(i).getRealP()),-(v.getElementos().get(i).getImaginP())));
        }
        return res;
    }
    
     public static ComplexVector vectorScalarMultiplication(ComplexVector v, Complex num){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <v.getSize(); i++){
            res.addElement(compProd(v.getElementos().get(i),num));
        }
        return res;
    }
     
     public static ComplexMatrix matrixSum(ComplexMatrix m1, ComplexMatrix m2) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         if((m1.getColumns() == m2.getColumns()) && (m1.getRows() == m2.getRows())){
             for(int i =0; i<m1.getRows(); i++){
                 res.addElement(vectorSum(m1.getElementos().get(i),m2.getElementos().get(i)));
             }
         }
         else{
             throw new Exception("Matrices dont match in size");
         }
         return res;
     }
     
     public static ComplexMatrix matrixInverse(ComplexMatrix m) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getRows(); i++){
             res.addElement(vectorInverse(m.getElementos().get(i)));
         }
         return res;
     }
     
     public static ComplexMatrix matrixScalarMultiplication(ComplexMatrix m, Complex num) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getRows(); i++){
             res.addElement(vectorScalarMultiplication(m.getElementos().get(i),num));
         }
         return res;
     }
     
     public static ComplexMatrix matrixMultiplication(ComplexMatrix m1, ComplexMatrix m2) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         if((m1.getColumns() == m2.getRows())){
             for(int k=0;  k<m1.getRows(); k++){
                 ComplexVector vector = new ComplexVector();
                 for(int i =0; i<m2.getRows(); i++){
                     Complex temp = new Complex(0,0);
                    for(int j =0 ; j<m1.getColumns();j++){
                        temp = compSum(temp,compProd(m1.getElementos().get(k).getElementos().get(j),m2.getElementos().get(j).getElementos().get(i)));
                    }
                    vector.addElement(temp);
                }
                res.addElement(vector);
         }
         }
         else{
             throw new Exception("Cannot multiply these matrices");
         }
         return res;
     }
     
     
     public static Complex innerProduct(ComplexVector v1, ComplexVector v2){
         Complex res = new Complex(0,0);
         for(int i=0; i<v1.getSize(); i++){
             Complex num = compProd(v1.getElementos().get(i) , v2.getElementos().get(i));
             res = compSum(res,num);  
         }
        return res;
     }
     
     public static Complex norm(ComplexVector v){
         Complex inn = innerProduct(v,v);
         Complex res = new Complex(Math.sqrt( inn.getRealP()),Math.sqrt( inn.getImaginP()));
         return res;
     }
     
     public static Complex distance(ComplexVector v1, ComplexVector v2){
         ComplexVector v3 = vectorRest(v1,v2);
         Complex inn = innerProduct(v3,v3);
         Complex res = new Complex(Math.sqrt( inn.getRealP()),Math.sqrt( inn.getImaginP()));
         return res;
     }
     
     
     
     public static ComplexVector vectorConjugate(ComplexVector v){
         ComplexVector res = new ComplexVector();
         for(int i =0; i<v.getSize(); i++){
             res.addElement(conjugate(v.getElementos().get(i)));
         }
         return res;
     }
     
     public static ComplexMatrix matrixConjugate(ComplexMatrix m) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getRows(); i++){
             res.addElement(vectorConjugate(m.getElementos().get(i)));
         }
         
         return res;
     }
     
     public static ComplexMatrix transpose(ComplexMatrix m) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getColumns(); i++){
             ComplexVector vector = new ComplexVector();
             for(int j=0; j<m.getRows(); j++){
                 vector.addElement(m.getElementos().get(j).getElementos().get(i));
             }
             res.addElement(vector);
         }
         
         return res;
     }
     
     public static boolean complexEquals(Complex num1, Complex num2){
         if(num1.getRealP() == num2.getRealP() && num1.getImaginP() == num2.getImaginP()){
             return true;
         }
         else{
             return false;
         }
             
     }
     
     public static boolean polarEquals(ComplexPolar num1, ComplexPolar num2){
         if(num1.getMagnitude() == num2.getMagnitude() && num1.getPhase() == num2.getPhase()){
             return true;
         }
         else{
             return false;
         }
             
     }
     
     public static boolean vectorEquals(ComplexVector v1, ComplexVector v2) throws Exception{
         boolean flag = true;
         if(v1.getSize() == v2.getSize()){
             for(int i=0; i<v1.getSize() && flag; i++){
                 if(! (complexEquals(v1.getElementos().get(i), v2.getElementos().get(i)))){
                     flag = false;
                 }
             }
         }
         else{
             throw new Exception("Vectors dont match in size");
         }
         return flag;
     }
     
     public static boolean matrixEquals(ComplexMatrix m1, ComplexMatrix m2) throws Exception{
         boolean flag = true;
         if((m1.getColumns() == m2.getColumns()) && (m1.getRows() == m2.getRows())){
             for(int i =0; i<m1.getRows() && flag ; i++){
                 for(int j =0; j<m2.getColumns() && flag; j++){
                     if(!complexEquals(m1.getElementos().get(i).getElementos().get(j),m2.getElementos().get(i).getElementos().get(j))){
                         flag= false;
                     }
                 }
             }
         }
         else{
             throw new Exception("Matrices dont match in size");
         }
         return flag;
     }
     
     public static ComplexMatrix adjointMatrix(ComplexMatrix m) throws Exception{
         ComplexMatrix res1 = transpose(m);
         ComplexMatrix res2 = matrixConjugate(res1);
         return res2;
     }
     
     public static boolean isHermitan(ComplexMatrix m) throws Exception{
         ComplexMatrix res = adjointMatrix(m);
         return matrixEquals(m,res);
     }
     
     public static boolean isUnitary(ComplexMatrix m) throws Exception{
         boolean flag = true;
         if((m.getColumns() == m.getRows())){
            ComplexMatrix adj = adjointMatrix(m);
            ComplexMatrix res = matrixMultiplication(m,adj);
            
            for(int i = 0; i<m.getRows() && flag; i++){
                if(!(res.getElementos().get(i).getElementos().get(i).getRealP() == 1 && res.getElementos().get(i).getElementos().get(i).getImaginP() == 0)){
                    flag = false;
                } 
            }
         }
         else{
             throw new Exception("Not a square matrix");
         }
         return flag;
     }
     
     
    
}
