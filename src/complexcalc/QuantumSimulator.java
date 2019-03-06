/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalc;

import java.util.ArrayList;

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
     * @throws java.lang.Exception The matrix must be square and the vector must have the same size as the matrix
     * 
     */
    public static ComplexVector marbleQuantumSimulation(ComplexVector state,ComplexMatrix adjacency, int clicks) throws Exception{
        ComplexVector init = state;
        if(adjacency.getColumns() != adjacency.getRows()){
            throw new Exception("Not a square matrix");
        }
        if(adjacency.getColumns() != state.getSize()){
            throw new Exception("State and matrix don't match");
        }
        for(int i=0; i<clicks; i++){
            ComplexVector res = ComplexCalc.action(adjacency, init);
            init = res;
        }
        
        return init;
    }
    
    /**
     * Simulates the double slit experiment with probabilistic values
     * @param slits Number of slits
     * @param targets number of targets that each bullet can go through in each slit
     * @param probabilities the probabilities of the bullet reaching each slit
     * @return The answer vector of the system after 2 clicks
     * @throws java.lang.Exception There must be the same number of probabilities as paths for the bullet
     */
    public static ArrayList<Double> probabilisticSlit(int slits, int targets, ArrayList<Double> probabilities) throws Exception{
        
        
       if(probabilities.size() != (slits*targets) ){
           throw new Exception("Number of targets doesn't match");
       }
       
       
       ArrayList<Double> probs =new ArrayList<>();
       ArrayList<Double> repeat= new ArrayList<>();
       int cont=0;
       for(int i=0; i<probabilities.size(); i++){
           if(cont < targets){
               probs.add(probabilities.get(i));
               cont++;
           }
           else{
               cont=1;
               repeat.add(probabilities.get(i));
           }
       }
       
       for(int i=0; i<probabilities.size();i++){
       }
       
       
       //Matrix is initialized with 0 for all values
       ArrayList<ArrayList<Double>> matrix = new ArrayList();
       int sizeM = (targets) + (targets-1) * (slits-1) + slits +1;
       for(int i=0; i<sizeM; i++){
            ArrayList<Double> temp = new ArrayList();
            for(int j=0; j<sizeM; j++){
                temp.add(new Double(0.0));
            }
            matrix.add(temp);
       }
       
       //Initializes de probabilities of each slit from the base node
       for(int i=1; i<slits+1; i++){
           matrix.get(i).set(0, new Double(1.0/slits));
       }
       
       //Fills the remaining rows with their probability values going form each slit to
       //each target, each target has value 1 going to itself.
       int currentSlit = 1;
       int currentCount = 0;
       for(int i=slits+1; i<sizeM; i++){
           matrix.get(i).set(i, new Double(1.0));
           if(currentCount<targets-1){
                matrix.get(i).set(currentSlit, probs.get(i-(slits+1)));
                currentCount++;
           }
           else{
               if(currentSlit < slits){
                   matrix.get(i).set(currentSlit, probs.get(i-(slits+1)));
                   currentCount=1;
                   currentSlit++;
                   matrix.get(i).set(currentSlit, repeat.remove(0));
               }
               else{
                   matrix.get(i).set(currentSlit, probs.get(i-(slits+1)));
               }
           }
           
       }
       
       for(int i=0; i<sizeM;i++){
           for(int j=0; j<sizeM; j++){
              // System.out.println(matrix.get(i).get(j));
           }
       }
       
       //The matrix gets multiplied by itself and then by the vector to find the final state
       ArrayList<ArrayList<Double>> res = doubleMatrixMultiplication(matrix,matrix);
       
       ArrayList<Double> vector = new ArrayList();
       for(int i=0; i< sizeM; i++){
           vector.add(res.get(i).get(0));
           //System.out.println(res.get(i).get(0));
       }
       
       return vector;
       
    }
    
    /**
     * Multiplies 2 matrices with Double values
     * @param m1 matrix 1
     * @param m2 matrix 2
     * @return The result of the product
     */
    public static ArrayList<ArrayList<Double>> doubleMatrixMultiplication(ArrayList<ArrayList<Double>> m1, ArrayList<ArrayList<Double>> m2){
        ArrayList<ArrayList<Double>> res = new ArrayList();

         for(int k=0;  k<m1.size(); k++){
             ArrayList<Double> vector = new ArrayList();
             for(int i =0; i<m2.size(); i++){
                 Double temp = new Double(0.0);
                for(int j =0 ; j<m1.size();j++){
                    temp = temp + (m1.get(k).get(j) * m2.get(j).get(i));
                }
                //System.out.println(temp);
                vector.add(temp);
                
            }
            res.add(vector);
        }
        return res; 
    }
    
}
