# Sort-Manager
Tony Parsons First Graded Project in IntelliJ

To run the program go into the "App" class and run "main" 

User Story
- User is asked if they want to order numbers. If they enter "N" the application finishes. Any other character will continue the program
- User is asked how many numbers they wish to input. An uninitialised array is created with length equal to the number given. Hopefully that number isn't  2 power 31.
- User is told to input numbers, pressing enter for each number. Hopefully they dont input +/- (2 power 31)
- User is presented with their numbers and asked which sorting algorithm they would like to use: Bubble, Merge, Tree. The program will wait not do anything unless specifically 1,2,or 3 is selected
- User is presented with the algorithm they selected, their ordered numbers and the time in nano seconds it took to complete the algorithm
- User is asked if they would like to sort again with a different algorithm. Inputs other than "N" will re-run the program from the point they are asked what algorithm they would like to use
- If user inputs "N" the program re-runs from when they first started the program.

This project will be updated once grade is received

Current known Issues -
Program crashes if user inputs an array size of less than 1

Unknown Issues - 
What happens if user inputs an int exceeding +/-(2 power 31) bounds


Notes for Collaborators:

This project is messy behind the scenes and will be updated as stated earlier. I currently do not regard it as professional quality.
If you wish to create your own tests please do so through controller -> SorterManagerTests. 
