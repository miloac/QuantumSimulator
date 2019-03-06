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
import java.math.BigDecimal;
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
    
}
