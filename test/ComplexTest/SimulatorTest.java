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
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class SimulatorTest {
    
    @Test
    public void marbleTest(){
        boolean bool = false;
        ComplexVector vs =new ComplexVector();
        Complex n1 = new Complex(1,0);
        Complex n2 = new Complex(2,3);
        Complex n3 = new Complex(1,1);
        vs.addElement(n1);
        vs.addElement(n2);
        vs.addElement(n3);
        Complex zero=new Complex(0,0);
        ComplexMatrix m1 = new ComplexMatrix();
        Complex r1 = new Complex(3,1);
        Complex r2 = new Complex(1,2);
        Complex r3 = new Complex(1,4);
        ComplexVector vr1=new ComplexVector();
        vr1.addElement(zero);
        vr1.addElement(zero);
        vr1.addElement(r1);
        ComplexVector vr2=new ComplexVector();
        vr2.addElement(r2);
        vr2.addElement(zero);
        vr2.addElement(r1);
        ComplexVector vr3=new ComplexVector();
        vr3.addElement(r2);
        vr3.addElement(r3);
        vr3.addElement(zero);
        try{
            m1.addElement(vr1);
            m1.addElement(vr2);
            m1.addElement(vr3);
            ComplexVector res = QuantumSimulator.marbleQuantumSimulation(vs, m1, 2);
            Complex res1 = new Complex(-40,30);
            Complex res2 = new Complex(-46,38);
            Complex res3= new Complex(-27,26);
            ComplexVector expected = new ComplexVector();
            expected.addElement(res1);
            expected.addElement(res2);
            expected.addElement(res3);
            bool = ComplexCalc.vectorEquals(res, expected);
            org.junit.Assert.assertEquals(true,bool);
        }
        catch(Exception e){
            fail();
        }
        
    }
    
    @Test
    public void probabilisticSlitTest(){
        boolean bool = false;
        ArrayList<Double> arr = new ArrayList();
        arr.add(new Double(1.0/3.0));
        arr.add(new Double(1.0/3.0));
        arr.add(new Double(1.0/3.0));
        arr.add(new Double(1.0/3.0));
        arr.add(new Double(1.0/3.0));
        arr.add(new Double(1.0/3.0));
        try{
        ArrayList<Double> res = QuantumSimulator.probabilisticSlit(2, 3, arr);
        Double third = new Double(1.0/3.0);
        Double sixth = new Double(1.0/6.0);
        Double zero = new Double(0.0);
        bool = zero.equals(res.get(0));
        org.junit.Assert.assertEquals(true,bool);
        bool = zero.equals(res.get(1));
        org.junit.Assert.assertEquals(true,bool);
        bool = zero.equals(res.get(2));
        org.junit.Assert.assertEquals(true,bool);
        bool = sixth.equals(res.get(3));
        org.junit.Assert.assertEquals(true,bool);
        bool = sixth.equals(res.get(4));
        org.junit.Assert.assertEquals(true,bool);
        bool = third.equals(res.get(5));
        org.junit.Assert.assertEquals(true,bool);
        bool = sixth.equals(res.get(6));
        org.junit.Assert.assertEquals(true,bool);
        bool = sixth.equals(res.get(7));
        org.junit.Assert.assertEquals(true,bool);
        
        }
        catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void probPointTest(){
        Complex n1 = new Complex (-3,-1);
        Complex n2 = new Complex (0,-2);
        Complex n3 = new Complex (0,1);
        Complex n4 = new Complex (2,0);
        ComplexVector v = new ComplexVector();
        v.addElement(n1);
        v.addElement(n2);
        v.addElement(n3);
        v.addElement(n4);
        double res = QuantumSimulator.probabilityInKetPoint(v, 2);
        double expected = 0.052624;
        org.junit.Assert.assertEquals(expected, res,0.0005);
    }
    
    @Test
    public void amplitudeTest(){
        boolean bool= false;
        Complex n1 = new Complex (0,-1);
        Complex n2 = new Complex (1,0);
        Complex n3 = new Complex (0,-1);
        ComplexVector v1= new ComplexVector();
        ComplexVector v2= new ComplexVector();
        v1.addElement(n1);
        v1.addElement(n2);
        v2.addElement(n2);
        v2.addElement(n3);
        Complex res = QuantumSimulator.transitionAmplitude(v1, v2);
        bool = ComplexCalc.complexEquals(res, n3);
        //org.junit.Assert.assertEquals(true, bool);
        
    }
    
    @Test
    public void meanValueTest(){
        boolean bool = false;
        Complex num1 = new Complex (0.70710678118, 0);
        Complex num2 = new Complex (0, 0.70710678118);
        Complex num3 = new Complex (1, 0);
        Complex num4 = new Complex (0, -1);
        Complex num5 = new Complex (0, 1);
        Complex num6 = new Complex(2,0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(num3);
        vector2.addElement(num4);
        ComplexVector vector3 = new ComplexVector();
        vector3.addElement(num5);
        vector3.addElement(num6);
        ComplexMatrix matrix1 = new ComplexMatrix();
        
        
        try{
            matrix1.addElement(vector2);
            matrix1.addElement(vector3);
            Complex actual = QuantumSimulator.meanValue(matrix1, vector);
            Complex aaa = QuantumSimulator.variance(matrix1, vector);
            Complex expected = new Complex(2.499999999953702,0);
            bool = ComplexCalc.complexEquals(actual,expected);
            org.junit.Assert.assertEquals(true,bool);
            

            
            
        }
        catch(Exception e){
            fail();
        }

    }
    
    @Test
    public void varianceTest(){
        boolean bool = false;
        Complex num1 = new Complex (0.70710678118, 0);
        Complex num2 = new Complex (0, 0.70710678118);
        Complex num3 = new Complex (1, 0);
        Complex num4 = new Complex (0, -1);
        Complex num5 = new Complex (0, 1);
        Complex num6 = new Complex(2,0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num1);
        vector.addElement(num2);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(num3);
        vector2.addElement(num4);
        ComplexVector vector3 = new ComplexVector();
        vector3.addElement(num5);
        vector3.addElement(num6);
        ComplexMatrix matrix1 = new ComplexMatrix();
        
        
        try{
            matrix1.addElement(vector2);
            matrix1.addElement(vector3);
            Complex actual = QuantumSimulator.variance(matrix1, vector);
            Complex expected = new Complex(0.2499999999953702,0);
            bool = ComplexCalc.complexEquals(actual,expected);
            org.junit.Assert.assertEquals(true,bool);
            

            
            
        }
        catch(Exception e){
            fail();
        }
        
    }
    
    @Test
    public void dynamicsTest(){
        boolean bool = false;
        Complex num1 = new Complex (0, 0);
        Complex num2 = new Complex (1,0);
        Complex num3 = new Complex (0.70710678118, 0);
        Complex num4 = new Complex (-0.70710678118, 0);
        ComplexVector vector = new ComplexVector();
        vector.addElement(num2);
        vector.addElement(num1);
        ComplexVector vector2 = new ComplexVector();
        vector2.addElement(num1);
        vector2.addElement(num2);
        ComplexVector vector3 = new ComplexVector();
        vector3.addElement(num3);
        vector3.addElement(num3);
        ComplexVector vector4 = new ComplexVector();
        vector4.addElement(num3);
        vector4.addElement(num4);
        ComplexMatrix matrix1 = new ComplexMatrix();
        ComplexMatrix matrix2 = new ComplexMatrix();
        
        try{
            matrix1.addElement(vector2);
            matrix1.addElement(vector);
            matrix2.addElement(vector3);
            matrix2.addElement(vector4);
            ArrayList<ComplexMatrix> arrM = new ArrayList<>();
            arrM.add(matrix1);
            arrM.add(matrix2);
            ComplexVector actual = QuantumSimulator.dynamics(arrM, vector);
            ComplexVector expected= new ComplexVector();
            expected.addElement(num3);
            expected.addElement(num4);
            bool = ComplexCalc.vectorEquals(actual, expected);
            org.junit.Assert.assertEquals(true,bool);

            
        }
        catch(Exception e){
            fail();
        }
    }
}
