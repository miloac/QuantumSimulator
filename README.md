# Complex Number Calculator
## Juan Camilo Mantilla
This Java Library implements the complex number calculator to make simulations on complex numer experiments, such as:

* Multi Slit Experiment
* Marble Experiment
* Average valueo of a system
* Variance of a system

To run the simulations you only need to clone or download the repository and import the QuantumSimulator class onto your program, you can invoke the static methods for their use.
The library runs on base Java so it doesn't require any other components.

### Slit Experiment

[(img/01.PNG)]

This experiment consists of an origin point firing towards n slits, which at the same time can lead into m targets from each slit. The last target of any slit excepting the last one is the first target of the following slit. For example this is how a 2 slit, 3 target set up would look like.

[(img/02.png)]

The program takes as inputs the numer of slits, targets, and a list with the probabilities that each slit will lead into a specific target, in descending order. This experiment can be done with probabilistic or quantum values.

### Marble Experiment

This experiment takes an adjacency matrix for a system similar to the one pictured bellow, an initial state vector and the number of clicks the system will go through. On each click the system will move with the specified initial state using the adjacency matrix, the final answer is the state vector of the system after all of the clicks have been executed.

[(img/03.PNG)]

### Average and variance
The program allows to calculate the average value of a hermitian observable and a ket vector, with the average it can also calculate the variance of the system. 