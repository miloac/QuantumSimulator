/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalc;

/**
 *
 * @author Milo
 */
public class QuantumSimulator {
    
    /**
     * Simulates the marble excercisa with complex numbers
     * @param state The initial state vector of the system
     * @param adjacency the adjacency matrix of the system
     * @param clicks Number of clicks in time the system will move
     * @return The vector representing the final state after the numer of clicks
     * @throws java.lang.Exception 
     * 
     */
    public static ComplexVector marbleQuantumSimulation(ComplexVector state,ComplexMatrix adjacency, int clicks) throws Exception{
        ComplexVector init = state;
        for(int i=0; i<clicks; i++){
            ComplexVector res = ComplexCalc.action(adjacency, init);
            init = res;
        }
        
        return init;
    }
    
}
