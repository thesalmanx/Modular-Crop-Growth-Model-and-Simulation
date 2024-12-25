# INTRODUCTION:
This OOP project, written in Java programming language, aims to simulate the growth of plants using a complex engineering model. The project's goal is to understand the various factors that influence plant growth and develop a simulation model.
# Flowchart:
<img width="535" alt="image" src="https://github.com/user-attachments/assets/1a83fffd-2f84-418f-86c0-31cad9b848b9" />

# DESCRIPTION:
We were given a modular crop growth model design program and main points were explained in depth. As it was an open-ended program so many formulas essential for growth model were given. But some of them which were used to calculate different parts were missing. So by some research on internet and discussion among group members, we write those formulas in our program.
We have used aggregation in our program to create link of simulation class with other classes therefore plant class, soil water class and weather class.

## 1.	Project login form:
At the start of our program, we have made login form which is playing role of a main class.

## 2.	Simulation class:
In simulation class we have created the objects of other three main classes and through those objects we called the methods of plant, soil water and weather class.

## 3.	 PlantInputUpdates:
In this class we are taking values from file and initializing them to their respective attributes so we can use them in Plant class via getters. We create this class for better OOP design and make maintenance of code much easier.

## 4.	SoilInputUpdates:
In this class we are taking values from file and initializing them to their respective attributes so we can use them in SoilWaterBalance class via getters. We create this class for better OOP design and make maintenance of code much easier.

## 5.	Plant Class:
In plant class, there are three major functions such as Rate calculations, integration, and output. There are also sub methods in it which calculate different factors. The input file is made in initialization through which values can be read from file. After calculations, the values get stored in output file. Plant class is inherited in other two classes i.e., reproductive phase and vegetative phase.

## 6.	Soil water Class:
Similarly, this class also has four main methods. The other functions are then called in Rate calculations function. Setters and getters are made so the return the value of variables whenever called. Again, input file is made in initialization which read values from that file and after calculation the values are written in output file created in output function.

## 7.	Weather Class:
In weather class, some attributes are made static because they can be accessible to plant and soil water class when called. Then there is input file which read the values of attributes and then closes.

## 8.	Report class:
At the end, we have made report class whose object is made in simulation class and it displays all the values of variables of plant, soil water and weather class from files when called.


# Mathematical Modeling

1.	PT = 1-0.0025*Math.pow((((0.25*TMIN)+(0.25*TMAX))-26),2);
2.	PG = (SRAD/PD)*(1-Math.exp(-Y1*Lai));
3.	dLAI = SWFAC1 * PT * PD * dN * EMP1 * (calcA(EMP2,n,nb)/(1+calcA(EMP2,n,nb)));
4.	dLAI = -PD * di * p1 * sla;
5.	S = 254 * ((100/CN) - 1);
6.	THE = WP + 0.75 * (FC - WP);
7.	ROF = ((POTINF-0.2*S)*2)/(POTINF+0.8*RUNOFF(CN));
8.	ALB = 0.1 * Math.exp(-0.7*LAI) + 0.2 * (1-Math.exp(-0.7*LAI));
9.	Tmed = 0.6 * TMAX + 0.4 * TMIN;
10.	EEQ = SRAD * (4.88-4.37*ALB)*(Tmed+29);
11.	ETp = f+ETp;
12.	ESp = ETp * Math.exp(-0.7*LAI);
13.	EPp = ETp * (1-Math.exp(-0.7*LAI));


# Output: 
<img width="356" alt="image" src="https://github.com/user-attachments/assets/0429a165-d39a-47ee-aa59-6a923a8cded8" />
<img width="425" alt="image" src="https://github.com/user-attachments/assets/108f7989-7d1c-446d-958b-d01ff432f976" />
<img width="468" alt="image" src="https://github.com/user-attachments/assets/f58a572c-c6e0-4dff-8880-b335dac05216" />

Conclusion:
In this project we have made six classes with their own functionality and classes are related to each other through composition. Our program takes input values in file through getters and after calculations write them in an output file.
By this project, we have got the idea that how a crop grows step by step and what are its factors that participate in its growing stage. We also have learned how to make a program of a model having different characteristics and how we can interlink with each other to generate accurate results and outputs as required.
