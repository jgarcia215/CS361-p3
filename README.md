# Project 3: Turing machine simulator

* Author: Jack Garcia, Josh Miller
* Class: CS361 Section #2
* Semester: Spring 2024

## Overview

This program is a Turing machine simulator designed to interpret and execute a variety of Turing machine configurations.

## Reflection

The lectures provided us with a robust theoretical foundation which was crucial for understanding Turing machines. 
Implementing the tape manipulation and transition functions was particularly challenging. 
We encountered issues with the transition logic that resulted in unexpected behavior, but these were resolved after
continuous debugging. The biggest challenges was knowing where to start. With zero starter code and a complex
topic, it seemed extremely challenging. Using object-oriented design patterns did help in breaking down
the complexity and gave us insight into the behind the scenes of how to simulate a Turing Machine.

We maintained excellent communication throughout the project, clearly dividing tasks to avoid any overlap and 
avoided any merge conflicts. Overall, it was a challenging project but enjoyable.

## Compiling and Using

To compile TMSimulator.java, use this command: javac -cp .:/usr/share/java/junit.jar ./p3Files/TM/TMSimulator.java
To run TMSimulator.java use this command: java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/core.jar org.junit.runner.JUnitCore ./p3Files/TM/TMSimulator.java

## Sources used

Class sources only

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).
