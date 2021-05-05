# Simple-Search-Engine
## About the project
A simple fast search engine written in java with the help of the Collection API which takes in multiple queries and outputs results accordingly.
## How it works
This search engine implements inverted index by mapping each words to their respective locations in the database. Upon running the program a user menu will prompt asking the user
"1. Find a person", "2. Print all people" and "0. Exit". The first option helps users find a person (or any specific object based on the type of database being used) based on 3 search 
stratigies "ALL", "ANY" and "NONE" respectively. The second option prints all the content of the database. Lastly the third option, you guessed it, exits the program.
## Search stratigies
As mentioned before there are three search stratigies "ALL", "ANY" and "NONE". "ALL" takes certain words as input and searches the database for a line which contains all the contents 
from the input, for instance: if the input is "ERICK HARRINGTON" then it will serach for content which contains both "ERICK" && "HARRINGTON" (case insensitive). "ANY" searched for a 
line which contains any of the contents from the input, for instance: if the input is "Erick Harrington" then it will serach for content which contains either "Erick" || "Harrington". 
"NONE" makes sure it returns all the contents of the database excluding the contents of the input.
### Note
The program takes command line argument for the location of the file/database used (at index 1 -> args[1]), if required the program can be modified to take files directly from the main
class by uncommenting the line of code directly below the line "Scanner sc = new Scanner(new File(args[1]))" and mentioning the file path. 
