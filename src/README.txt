CIS 6930: Network Data Streaming
Project-3: Implementation of Flow-Size Sketches
Author: Sanket Sadanand Nayak (UFID: 8895-9505)

All files are under Project-3.zip

Source Code Description:
The source code is under src folder in 'Project 2.zip' and  comprises of 6 .java file:
– 'Runner.java'
This contains the main() function from which the execution starts.
– 'Counter.java'
This is the parent class which contains functions for randomizing seed array, implementing hash functions, writing output to text file and handles standard inputs.
– 'CountMin.java'
Contains the implementation for CountMin Sketch i.e. functions for recording the flow sizes and computing the average error.
– 'CountSketch.java'
This file contains the implementation for Counting Bloom Filter i.e. functions for recording the flow sizes and computing the average error.
– 'CountActive.java'
This file contains the implementation for Active Counter Sketch i.e. functions for increasing the counter by 1 for 1,000,000 times.
– 'Flow.java'
This file contains the entities of a flow {flowID, flowSize, estimatedSize} and is extensively used by 'CountMin.java' and 'CountSketch.java'

The folder also contains the 3 output files for each type of Sketch in the following format: output_(type of Sketch). They are as follows:
– 'output_countmin.txt'
– 'output_countSketch.txt'
– 'output_active.txt'

These file contains output as per the project specification.