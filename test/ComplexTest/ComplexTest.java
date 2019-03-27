/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexTest;

/**
 *
 * @author Milo
 */

import complexcalc.*;
import org.junit.*;
import static org.junit.Assert.*;


public class ComplexTest {
    
    @Before
    public void setup(){
        
    }
    
    @Test
    public void sumTest(){
        Complex num1 = new Complex (3, -2);
        Complex num2 = new Complex (1, 2);
        Complex sum = ComplexCalc.compSum(num1, num2);
        Complex res= new Complex(4,0);
        boolean bool =ComplexCalc.complexEquals(sum, res);
        org.junit.Assert.assertEquals(true, bool);
    }
    
    @Test
    public void restTest(){
        Complex num1 = new Complex (3, -2);
        Complex num2 = new Complex (1, 2);
        Complex rest = ComplexCalc.compRest(num1, num2);
        Complex res = new Complex(2,-4);
        boolean bool = ComplexCalc.complexEquals(rest, res);
        org.junit.Assert.assertEquals(true, bool);
    }
    
    @Test
    public void prodTest(){
        Complex num1 = new Complex (3, -2);
        Complex num2 = new Complex (1, 2);
        Complex prod = ComplexCalc.compProd(num1, num2);
        Complex res= new Complex(7,4);
        boolean bool =ComplexCalc.complexEquals(prod, res);
        org.junit.Assert.assertEquals(true, bool);
    }
    
    @Test
    public void divTest(){
        Complex num1 = new Complex (3, -2);
        Complex num2 = new Complex (1, 2);
        Complex div = ComplexCalc.compDiv(num1, num2);
        Complex res= new Complex(-0.2,-1.6);
        boolean bool =ComplexCalc.complexEquals(div, res);
        org.junit.Assert.assertEquals(true, bool);
    }
    
    @Test
    public void modulusTest(){
        Complex num1 = new Complex (3, -2);
        double mod = ComplexCalc.modulus(num1);
        double res = 3.61;
        org.junit.Assert.assertEquals(res, mod, 0.05);
        
    }
    
    @Test
    public void conjugateTest(){
        Complex num1 = new Complex (3, -2);
        Complex conj = ComplexCalc.conjugate(num1);
        Complex res = new Complex (3, 2);
        boolean bool =ComplexCalc.complexEquals(conj, res);
        org.junit.Assert.assertEquals(true, bool);
        
    }
    
    @Test
    public void cartToPolarTest(){
        Complex num1 = new Complex (3, -2);
        ComplexPolar polar = ComplexCalc.cartesianToPolar(num1);
        ComplexPolar res = new ComplexPolar(3.61,2.16);
        boolean bool =ComplexCalc.polarEquals(polar, res);
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void polarToCartTest(){
        Complex num1 = new Complex (3, -2);
        ComplexPolar polar = ComplexCalc.cartesianToPolar(num1);
        Complex cart = ComplexCalc.polarToCartesian(polar);
        Complex res = new Complex(3,-2.01);
        boolean bool =ComplexCalc.complexEquals(cart, res);
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void phaseTest(){
        Complex num2 = new Complex (1, 2);
        double phase = ComplexCalc.getPolarPhase(num2);
        double res = 0.46;
        org.junit.Assert.assertEquals(res, phase, 0.05);
        
    }
    
    @Test
    public void vectorSumTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexVector sum = ComplexCalc.vectorSum(vector, vector);
        Complex r1 = new Complex (2, 4);
        Complex r2 = new Complex (4, -6);
        Complex r3 = new Complex (8, 0);
        ComplexVector res = new ComplexVector();
        res.addElement(r1);
        res.addElement(r2);
        res.addElement(r3);
        try{
            bool = ComplexCalc.vectorEquals(sum, res);
        }
        catch(Exception e){
            fail();
        }
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void vectorInverseTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexVector inv = ComplexCalc.vectorInverse(vector);
        Complex r1 = new Complex (-1, -2);
        Complex r2 = new Complex (-2, 3);
        Complex r3 = new Complex (-4, 0);
        ComplexVector res = new ComplexVector();
        res.addElement(r1);
        res.addElement(r2);
        res.addElement(r3);
        try{
            bool = ComplexCalc.vectorEquals(inv, res);
        }
        catch(Exception e){
            fail();
        }
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void vectorScalarMultTest(){
        boolean bool = false;
        Complex num1 = new Complex (6, 3);
        Complex num2 = new Complex (5, 1);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        Complex scalar = new Complex(3,2);
        ComplexVector mult = ComplexCalc.vectorScalarMultiplication(vector, scalar);
        Complex r1 = new Complex (12, 21);
        Complex r2 = new Complex (13, 13);
        Complex r3 = new Complex (12, 8);
        ComplexVector res = new ComplexVector();
        res.addElement(r1);
        res.addElement(r2);
        res.addElement(r3);
        try{
            bool = ComplexCalc.vectorEquals(mult, res);
        }
        catch(Exception e){
            fail();
        }
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void matrixSumTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexMatrix matrix = new ComplexMatrix();
        try{
            matrix.addElement(vector);
            matrix.addElement(vector);
            
            ComplexMatrix sum = ComplexCalc.matrixSum(matrix, matrix);
            Complex r1 = new Complex (2, 4);
            Complex r2 = new Complex (4, -6);
            Complex r3 = new Complex (8, 0);
            ComplexVector vecres = new ComplexVector();
            vecres.addElement(r1);
            vecres.addElement(r2);
            vecres.addElement(r3);
            ComplexMatrix res = new ComplexMatrix();
            res.addElement(vecres);
            res.addElement(vecres);
            bool = ComplexCalc.matrixEquals(res, sum);
        }
        catch(Exception e){
            
            fail();
        }
                
        
        
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void matrixInverseTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexMatrix matrix = new ComplexMatrix();
        try{
            matrix.addElement(vector);
            matrix.addElement(vector);
            
            ComplexMatrix sum = ComplexCalc.matrixInverse(matrix);
            Complex r1 = new Complex (-1, -2);
            Complex r2 = new Complex (-2, 3);
            Complex r3 = new Complex (-4, 0);
            ComplexVector vecres = new ComplexVector();
            vecres.addElement(r1);
            vecres.addElement(r2);
            vecres.addElement(r3);
            ComplexMatrix res = new ComplexMatrix();
            res.addElement(vecres);
            res.addElement(vecres);
            bool = ComplexCalc.matrixEquals(res, sum);
        }
        catch(Exception e){
            
            fail();
        }
                
        
        
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void matrixScalarMultTest(){
        boolean bool = false;
        Complex num1 = new Complex (6, 3);
        Complex num2 = new Complex (5, 1);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexMatrix matrix = new ComplexMatrix();
        try{
            matrix.addElement(vector);
            matrix.addElement(vector);
            Complex scalar = new Complex(3,2);
            ComplexMatrix sum = ComplexCalc.matrixScalarMultiplication(matrix, scalar);
            Complex r1 = new Complex (12, 21);
            Complex r2 = new Complex (13, 13);
            Complex r3 = new Complex (12, 8);
            ComplexVector vecres = new ComplexVector();
            vecres.addElement(r1);
            vecres.addElement(r2);
            vecres.addElement(r3);
            ComplexMatrix res = new ComplexMatrix();
            res.addElement(vecres);
            res.addElement(vecres);
            bool = ComplexCalc.matrixEquals(res, sum);
        }
        catch(Exception e){
            
            fail();
        }
                
        
        
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void matrixMultiplicationTest(){
        boolean bool = false;
        Complex num1 = new Complex (3, 2);
        Complex num2 = new Complex (0, 0);
        Complex num3 = new Complex (5, -6);
        Complex num4 = new Complex (1, 0);
        Complex num5 = new Complex (4, 2);
        Complex num6 = new Complex (0, 1);
        Complex num7 = new Complex (4, -1);
        Complex num8 = new Complex (0, 0);
        Complex num9 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(num4);
        vector2.addElement(num5);
        vector2.addElement(num6);
        ComplexVector vector3 = new ComplexVector();
        vector3.addElement(num7);
        vector3.addElement(num8);
        vector3.addElement(num9);
        ComplexMatrix matrix1 = new ComplexMatrix();
        
        Complex num11 = new Complex (5, 0);
        Complex num12 = new Complex (2, -1);
        Complex num13 = new Complex (6, -4);
        Complex num14 = new Complex (0, 0);
        Complex num15 = new Complex (4, 5);
        Complex num16 = new Complex (2, 0);
        Complex num17 = new Complex (7, -4);
        Complex num18 = new Complex (2, 7);
        Complex num19 = new Complex (0, 0);
        ComplexVector vector11 = new ComplexVector();
        vector11.addElement(num11);
        vector11.addElement(num12);
        vector11.addElement(num13);
        ComplexVector vector12 = new ComplexVector();
        vector12.addElement(num14);
        vector12.addElement(num15);
        vector12.addElement(num16);
        ComplexVector vector13 = new ComplexVector();
        vector13.addElement(num17);
        vector13.addElement(num18);
        vector13.addElement(num19);
        ComplexMatrix matrix2 = new ComplexMatrix();
        try{
            matrix1.addElement(vector);
            matrix1.addElement(vector2);
            matrix1.addElement(vector3);
            matrix2.addElement(vector11);
            matrix2.addElement(vector12);
            matrix2.addElement(vector13);
            ComplexMatrix mult = ComplexCalc.matrixMultiplication(matrix1,matrix2);
            
            Complex r1 = new Complex (26, -52);
            Complex r2 = new Complex (60, 24);
            Complex r3 = new Complex (26, 0);
            Complex r4 = new Complex (9, 7);
            Complex r5 = new Complex (1, 29);
            Complex r6 = new Complex (14, 0);
            Complex r7 = new Complex (48, -21);
            Complex r8 = new Complex (15, 22);
            Complex r9 = new Complex (20, -22);
            ComplexVector vecres1 = new ComplexVector();
            vecres1.addElement(r1);
            vecres1.addElement(r2);
            vecres1.addElement(r3);
            ComplexVector vecres2 = new ComplexVector();
            vecres2.addElement(r4);
            vecres2.addElement(r5);
            vecres2.addElement(r6);
            ComplexVector vecres3 = new ComplexVector();
            vecres3.addElement(r7);
            vecres3.addElement(r8);
            vecres3.addElement(r9);
            ComplexMatrix res = new ComplexMatrix();
            res.addElement(vecres1);
            res.addElement(vecres2);
            res.addElement(vecres3);
            bool = ComplexCalc.matrixEquals(res, mult);
        }
        catch(Exception e){
            
            fail();
        }
                
        org.junit.Assert.assertEquals(true,bool);
    }
    
    @Test
    public void innerProductTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        Complex innProd = ComplexCalc.innerProduct(vector,vector);
        Complex res = new Complex(8,-8);
        try{
           bool = ComplexCalc.complexEquals(innProd, res);
        }
        catch(Exception e){
            fail();
        }
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void normTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 1);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        Complex innProd = ComplexCalc.norm(vector);
        Complex res = new Complex(2.6457513110645907,0);
        try{
           bool = ComplexCalc.complexEquals(innProd, res);
        }
        catch(Exception e){
            fail();
        }
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void distanceTest(){
        boolean bool = false;
        Complex num1 = new Complex (1, 2);
        Complex num2 = new Complex (2, -3);
        Complex num3 = new Complex (4, 1);
        ComplexVector vector1 = new ComplexVector();
        vector1.addElement(num1);
        vector1.addElement(num2);
        vector1.addElement(num3);
        Complex zero = new Complex(0,0);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(zero);
        vector2.addElement(num2);
        vector2.addElement(zero);
        Complex dist = ComplexCalc.distance(vector1, vector2);
        Complex res = new Complex(3.4641016151377544,3.4641016151377544);
        try{
           bool = ComplexCalc.complexEquals(dist, res);
        }
        catch(Exception e){
            fail();
        }
        org.junit.Assert.assertEquals(true,bool);
        
    }
    
    @Test
    public void hermitanTest(){
        boolean bool = false;
        ComplexMatrix matrix= new ComplexMatrix();
        Complex num1 = new Complex(5,0);
        Complex num2 = new Complex(4,5);
        Complex num3 = new Complex(6,-16);
        ComplexVector v1= new ComplexVector();
        v1.addElement(num1);
        v1.addElement(num2);
        v1.addElement(num3);
        Complex num4 = new Complex(4,-5);
        Complex num5 = new Complex(13,0);
        Complex num6 = new Complex(7,0);
        ComplexVector v2= new ComplexVector();
        v2.addElement(num4);
        v2.addElement(num6);
        v2.addElement(num6);
        Complex num7 = new Complex(6,+16);
        Complex num8 = new Complex(7,0);
        Complex num9 = new Complex(-2.1,0);
        ComplexVector v3= new ComplexVector();
        v3.addElement(num7);
        v3.addElement(num8);
        v3.addElement(num9);
        
        try{
            matrix.addElement(v1);
            matrix.addElement(v2);
            matrix.addElement(v3);
            bool = ComplexCalc.isHermitan(matrix);
            org.junit.Assert.assertEquals(true,bool);
        }
        catch(Exception e){
            fail();
        }
    }
    
    
    
    
    @Test
    public void unitaryTest(){
        boolean bool = false;
        ComplexMatrix matrix= new ComplexMatrix();
        Complex num1 = new Complex(1,0);
        Complex num2 = new Complex(1,-1);
        Complex num3 = new Complex(1,-1);
        Complex num4 = new Complex(1,1);
        ComplexVector v1= new ComplexVector();
        v1.addElement(num1);
        v1.addElement(num2);
        ComplexVector v2= new ComplexVector();
        v2.addElement(num3);
        v2.addElement(num4);
        
        try{
            matrix.addElement(v1);
            matrix.addElement(v2);
            bool = ComplexCalc.isUnitary(matrix);
            org.junit.Assert.assertEquals(false,bool);
        }
        catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void actionTest(){
        boolean bool = false;
        Complex num1 = new Complex (3, 2);
        Complex num2 = new Complex (0, 0);
        Complex num3 = new Complex (5, -6);
        Complex num4 = new Complex (1, 0);
        Complex num5 = new Complex (4, 2);
        Complex num6 = new Complex (0, 1);
        Complex num7 = new Complex (4, -1);
        Complex num8 = new Complex (0, 0);
        Complex num9 = new Complex (4, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        vector.addElement(num3);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(num4);
        vector2.addElement(num5);
        vector2.addElement(num6);
        ComplexVector vector3 = new ComplexVector();
        vector3.addElement(num7);
        vector3.addElement(num8);
        vector3.addElement(num9);
        ComplexMatrix matrix1 = new ComplexMatrix();
        
        Complex num11 = new Complex (5, 0);
        Complex num14 = new Complex (0, 0);
        Complex num17 = new Complex (7, -4);
        ComplexVector vector11 = new ComplexVector();
        vector11.addElement(num11);
        vector11.addElement(num14);
        vector11.addElement(num17);
        
        Complex r1 = new Complex (26, -52);
        Complex r2 = new Complex (9, 7);
        Complex r3 = new Complex (48, -21);
        ComplexVector vectorres = new ComplexVector();
        vectorres.addElement(r1);
        vectorres.addElement(r2);
        vectorres.addElement(r3);
        try{
            matrix1.addElement(vector);
            matrix1.addElement(vector2);
            matrix1.addElement(vector3);
            ComplexVector act = ComplexCalc.action(matrix1, vector11);
            bool = ComplexCalc.vectorEquals(act, vectorres);
            org.junit.Assert.assertEquals(true,bool);
            
        }
        catch(Exception e){
            fail();
        }

    }
    
    @Test
    public void prueba(){
        boolean bool = false;
        Complex num1 = new Complex (0.70710678118, 0);
        Complex num2 = new Complex (0, 0.70710678118);
        Complex num3 = new Complex (0, -1);
        Complex num4 = new Complex (0, 1);
        Complex num5 = new Complex (1, 0);
        Complex num6 = new Complex(2,0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(num5);
        vector2.addElement(num3);
        ComplexVector vector3 = new ComplexVector();
        vector3.addElement(num4);
        vector3.addElement(num6);
        ComplexMatrix matrix1 = new ComplexMatrix();
        
        try{
            matrix1.addElement(vector2);
            matrix1.addElement(vector3);
            ComplexVector act = ComplexCalc.action(matrix1, vector);
            Complex aa = ComplexCalc.innerProduct(act, vector);
            System.out.println(aa.toString());

            
            
        }
        catch(Exception e){
            fail();
        }

    }
    
    
    
}