# Alphabetizer: A program that can read in a series of strings and output the strings with the characters in alphabetical order. 
## Usage guide
### From the command Line:
- [ ] Navigate to the src folder:
    - [ ] To build: javac alphabetizer/alphabetizer.java 
    - [ ] To run: java alphabetizer.Alphabetizer <inputFileName.txt> <outputFileName.txt>
    
### Capitalization does not matter for a character, but characters are output in the same form that they were input.  e.g. P counts the same as p, but the output as P.  Non-alphabetic characters are ignored and are not included in the output string.
Examples: 
    “VirginiaTech” would be output as “aceghiiinrTV”
    “3 Blind Mice” would be output as “BcdeiilMn"

 
### N.B: This approach is assuming that the order of uppercase and lowercase doesn't matter. 
Example: Vv is the same as vV --> they both will be alphabetized to Vv
     
