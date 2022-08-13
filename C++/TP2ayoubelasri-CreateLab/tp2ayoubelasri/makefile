main.o: main.cpp
	g++ -c main.cpp

Cellule.o:Cellule.cpp
	g++ -c Cellule.cpp

CelluleV.o:CelluleV.cpp
	g++ -c CelluleV.cpp

Labyrinthe.o: Labyrinthe.cpp
	g++ -c Labyrinthe.cpp
	
LabyrintheD.o: LabyrintheD.cpp
	g++ -c LabyrintheD.cpp
	
Paire.o: Paire.cpp
	g++ -c Paire.cpp	
	
Parser.o: Parser.cpp
	g++ -c Parser.cpp
	
main: main.o Parser.o Cellule.o CelluleV.o Labyrinthe.o LabyrintheD.o Paire.o
	g++ main.o Parser.o Cellule.o CelluleV.o Labyrinthe.o LabyrintheD.o Paire.o -o main.exe	


clean:
	del *.o
	del *.exe 
	
