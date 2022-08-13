Tas.o:Tas.cpp
	g++ -c Tas.cpp

PieceT.o:PieceT.cpp
	g++ -c PieceT.cpp

Piece.o: Piece.cpp
	g++ -c Piece.cpp
	
mainTas.o: mainTas.cpp
	g++ -c mainTas.cpp	
	
mainTas.exe: mainTas.o Tas.o PieceT.o Piece.o 
	g++ mainTas.o Tas.o PieceT.o Piece.o -o mainTas.exe
	

clean:
	del *.o
	del *.exe 
	
