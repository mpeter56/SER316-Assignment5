# SER316-Assignment5

## Screencast

## Repository
https://github.com/mpeter56/SER316-Assignment5

## Pattern 1
I used the factory pattern to generate random attacks, evolutions, types, CodeAMon and different 
levels of trainers.

## Pattern 2
I used the decorator pattern to evolve code-a-mon by having the decorator add the evolution to
the original code-a-mon. code-a-mon can have an unlimited number of evolutions, but usually only
get 1, by the end of the automated play. this will appear as an adjective in front of the 
code-a-mon's name.

##Pattern 3
I used the mediator pattern to haddle object communication for battles which will be on a turn
based system. The GameMediator implements mediator and all of the trainers, the shop, the bed, and 
the world interact by sending requests to the game mediator.

##Pattern 4
I used the observer pattern to update the cycles and the difficulty. The Time class is implements
the observer interface and "watches" the time variable in GameMediator, which also implements the
subject interface. the time then creates a new cycle and updates the world, bed, and shop.
The difficulty class basically does the same thing but updates the level of the npc's and only
updates the world.

##Pattern 5
the game class is a facade pattern and holds the ai for playing the automated game. all main has to 
do is call game.playAutomated(); and the game class will do the rest.