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
    
     /** Sums 2 complex numbers
      * @param num1 The first number
      * @param num2 the second number
      * @return the sum of the two numbers
      **/
    public static Complex compSum(Complex num1, Complex num2){
        return new Complex(num1.getRealP()+num2.getRealP(), num1.getImaginP() + num2.getImaginP());
    }
    
    /**
     * Multiplies two complex numbers
     * @param num1 first number
     * @param num2 second number
     * @return the result of the multiplication
     */
     public static Complex compProd(Complex num1, Complex num2){
        double a1 = num1.getRealP();
        double b1 = num1.getImaginP();
        double a2 = num2.getRealP();
        double b2 = num2.getImaginP();
        return new Complex((a1*a2) - (b1*b2), (a1*b2) + (a2*b1));
    }
    
     /**
      * Rests 2 comples numbers
      * @param num1 first number
      * @param num2 second number
      * @return the rest of the numbers
      */
     public static Complex compRest(Complex num1, Complex num2){
        return new Complex(num1.getRealP()-num2.getRealP(), num1.getImaginP() - num2.getImaginP());
    }
    /**
     * Divides two complex numbers
     * @param num1 first number, the dividend
     * @param num2 second number, the divisor
     * @return 
     */
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
    
     /**
      * Find the modulus of a complex number
      * @param num the number
      * @return the double value of the modulus
      */
     public static double modulus(Complex num){
        double res = Math.sqrt( (num.getRealP() * num.getRealP()) + (num.getImaginP() * num.getImaginP()) );
        return res;
    }
    
     /**
      * Find the conjugate of a complex number
      * @param num the number
      * @return the conjugate complex number
      */
     public static Complex conjugate(Complex num){
        return new Complex(num.getRealP(), -(num.getImaginP()));
    }
    
     /**
      * Transform a complex number from cartesian to polar coordinates
      * @param num the number
      * @return the complex number in polar coordinates
      */
     public static ComplexPolar cartesianToPolar(Complex num){
        double mag = modulus(num);
        mag = Math.round(mag*100.0)/100.0;
        double phase = Math.atan2(num.getRealP(), num.getImaginP());
        phase = Math.round(phase*100.0)/100.0;
        return new ComplexPolar(mag, phase);
    }
    
     /**
      * transforms a polar complex number to cartesian form
      * @param polar the number
      * @return the cartesian number
      */
     public static Complex polarToCartesian(ComplexPolar polar){
        double img = polar.getMagnitude() * Math.cos(polar.getPhase());
        img = Math.round(img*100.0)/100.0;
        double real = polar.getMagnitude() * Math.sin(polar.getPhase());
        real = Math.round(real*100.0)/100.0;
        return new Complex(real,img);
    } 
    
    /**
     * Finds the phase of a cartesian complex number
     * @param num the number
     * @return the angle of the number
     */
     public static double getPolarPhase(Complex num){
        ComplexPolar polar =(cartesianToPolar(num));
        return polar.getPhase();
    }
    
    /**
     * Sums two complex vectors, the vector should have the same size
     * @param vector1 first victor
     * @param vector2 second vector
     * @return the sum of the two vectors
     */
     public static ComplexVector vectorSum(ComplexVector vector1, ComplexVector vector2){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <vector1.getSize(); i++){
            res.addElement(compSum(vector1.getElementos().get(i),vector2.getElementos().get(i)));
        }
        return res;
    }
     
     /**
     * Rests two complex vectors, the vector should have the same size
     * @param vector1 first victor
     * @param vector2 second vector
     * @return the rest of the two vectors
     */
     public static ComplexVector vectorRest(ComplexVector vector1, ComplexVector vector2){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <vector1.getSize(); i++){
            res.addElement(compRest(vector1.getElementos().get(i),vector2.getElementos().get(i)));
        }
        return res;
    }
    
     /**
      * Finds the inverse of a complex vector
      * @param v the vector
      * @return the inverse vector
      */
     public static ComplexVector vectorInverse(ComplexVector v){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <v.getSize(); i++){
            res.addElement(new Complex(-(v.getElementos().get(i).getRealP()),-(v.getElementos().get(i).getImaginP())));
        }
        return res;
    }
    
     /**
      * Multiplies a complex vector by a complex scalar
      * @param v the vector
      * @param num the scalar
      * @return the multiplied vector
      */
     public static ComplexVector vectorScalarMultiplication(ComplexVector v, Complex num){
        ComplexVector res = new ComplexVector();
        for(int i=0; i <v.getSize(); i++){
            res.addElement(compProd(v.getElementos().get(i),num));
        }
        return res;
    }
     
     /**
      * Sums 2 complex matrices, they should have the same size
      * @param m1 first matrix
      * @param m2 second matrix
      * @return The sum of the matrices
      * @throws Exception Matrices should have the same size
      */
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
     
     /**
      * Find the inverse of a matrix
      * @param m the matrix
      * @return the inverse matrix
      * @throws Exception 
      */
     public static ComplexMatrix matrixInverse(ComplexMatrix m) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getRows(); i++){
             res.addElement(vectorInverse(m.getElementos().get(i)));
         }
         return res;
     }
     
     /**
      * Multiplies a matrix by a scalar comples number
      * @param m the matrix
      * @param num the number
      * @return the multiplied matrix
      * @throws Exception 
      */
     public static ComplexMatrix matrixScalarMultiplication(ComplexMatrix m, Complex num) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getRows(); i++){
             res.addElement(vectorScalarMultiplication(m.getElementos().get(i),num));
         }
         return res;
     }
     
     /**
      * Multiplies two matrices
      * @param m1 first matrix
      * @param m2 second matrix
      * @return the multiplied matrix
      * @throws Exception Matrix 1 and matrix 2 must have the same number of columns and rows respectively
      */
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
     
     /**
      * Finds the inner product of two vectors
      * @param v1 first vector
      * @param v2 second vector
      * @return the complex inner product
      */
     public static Complex innerProduct(ComplexVector v1, ComplexVector v2){
         Complex res = new Complex(0,0);
         for(int i=0; i<v1.getSize(); i++){
             Complex num = compProd(v1.getElementos().get(i) , v2.getElementos().get(i));
             res = compSum(res,num);  
         }
        return res;
     }
     
     /**
      * Finds the norm of a vector
      * @param v the vector
      * @return The norm of the vector
      */
     public static Complex norm(ComplexVector v){
         Complex inn = innerProduct(v,v);
         Complex res = new Complex(Math.sqrt( inn.getRealP()),Math.sqrt( inn.getImaginP()));
         return res;
     }
     
     public static double vectorNorm(ComplexVector v){
         double res =0;
         for(int i =0; i< v.getSize(); i++){
             res = res + (v.getElementos().get(i).getRealP() * v.getElementos().get(i).getRealP()) + v.getElementos().get(i).getImaginP() * v.getElementos().get(i).getImaginP();
         }
         double sqr = Math.sqrt(res);
         return sqr;
     }
     
     /**
      * Finds the distance between two vectors
      * @param v1 first vector
      * @param v2 second vector
      * @return the complex distance between the vectors
      */
     public static Complex distance(ComplexVector v1, ComplexVector v2){
         ComplexVector v3 = vectorRest(v1,v2);
         Complex inn = innerProduct(v3,v3);
         Complex res = new Complex(Math.sqrt( inn.getRealP()),Math.sqrt( inn.getImaginP()));
         return res;
     }
     
     
     /**
      * Finds the conjugate of a vector
      * @param v the vector
      * @return the conjugate
      */
     public static ComplexVector vectorConjugate(ComplexVector v){
         ComplexVector res = new ComplexVector();
         for(int i =0; i<v.getSize(); i++){
             res.addElement(conjugate(v.getElementos().get(i)));
         }
         return res;
     }
     
     /**
      * Finds the conjugate of a matrix
      * @param m the matrix
      * @return the conjugate
      * @throws Exception 
      */
     public static ComplexMatrix matrixConjugate(ComplexMatrix m) throws Exception{
         ComplexMatrix res = new ComplexMatrix();
         for(int i =0; i<m.getRows(); i++){
             res.addElement(vectorConjugate(m.getElementos().get(i)));
         }
         
         return res;
     }
     
     /**
      * Finds the transpose of a matrix
      * @param m the matrix
      * @return the transpose matrix
      * @throws Exception 
      */
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
     
     /**
      * Determines wether two complex numbers are equal 
      * @param num1 first number
      * @param num2 second number
      * @return the boolean answer of the equalty
      */
     
     public static boolean complexEquals(Complex num1, Complex num2){
         if(num1.getRealP() == num2.getRealP() && num1.getImaginP() == num2.getImaginP()){
             return true;
         }
         else{
             return false;
         }
             
     }
     
     /**
      * Determines wether two complex polar numbers are equal 
      * @param num1 first number
      * @param num2 second number
      * @return the boolean answer of the equalty
      */
     public static boolean polarEquals(ComplexPolar num1, ComplexPolar num2){
         if(num1.getMagnitude() == num2.getMagnitude() && num1.getPhase() == num2.getPhase()){
             return true;
         }
         else{
             return false;
         }
             
     }
     
     /**
      * Determines whether two complex vectors are equal 
      * @param v1 first vector
      * @param v2 second vector
      * @return the boolean answer of the equality
      * @throws Exception Vectors must have the same size
      */
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
     
     /**
      * Determines whether two complex matrices are equal 
      * @param m1 first matrix
      * @param m2 second matrix
      * @return the boolean answer of the equality
      * @throws Exception Matrices should have the same size
      */
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
     
     /**
      * Finds the adjoint of a matrix
      * @param m the matrix
      * @return the adjoint matrix
      * @throws Exception 
      */
     public static ComplexMatrix adjointMatrix(ComplexMatrix m) throws Exception{
         ComplexMatrix res1 = transpose(m);
         ComplexMatrix res2 = matrixConjugate(res1);
         return res2;
     }
     
     /**
      * Returns whether or not a matrix is hermitan
      * @param m the matrix
      * @return the boolean answer telling if the matrix is hermitan
      * @throws Exception 
      */
     public static boolean isHermitan(ComplexMatrix m) throws Exception{
         ComplexMatrix res = adjointMatrix(m);
         return matrixEquals(m,res);
     }
     
     /**
      * Determines whether or not a matrix is unitary
      * @param m the matrix
      * @return the boolean answer that tells if the matrix is unitary
      * @throws Exception the matrix must be square
      */
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
     
     /**
      * Finds the action between a matrix and a vector
      * @param m the matrix
      * @param v the vector
      * @return The vector resulting on the action
      * @throws Exception Matrix columns have to be the same size of the vector
      */
     public static ComplexVector action(ComplexMatrix m, ComplexVector v) throws Exception{
         ComplexVector res = new ComplexVector();
         if(m.getColumns() == v.getSize()){
             for(int i =0; i<m.getRows(); i++){
                     Complex temp = new Complex(0,0);
                    for(int j =0 ; j<v.getSize();j++){
                        temp = compSum(temp,compProd(m.getElementos().get(i).getElementos().get(j),v.getElementos().get(j)));
                    }
                    res.addElement(temp);
                }
         }
         else{
             throw new Exception ("Can't get the action when sizes dont match");
         }
         return res;
     }
     
    
}
