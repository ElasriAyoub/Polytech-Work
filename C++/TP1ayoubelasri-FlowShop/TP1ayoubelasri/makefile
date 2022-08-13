main.o: main.cpp
	g++ -c main.cpp

Job3M.o:Job3M.cpp
	g++ -c Job3M.cpp

Rmax.o:Rmax.cpp
	g++ -c Rmax.cpp

Sequence.o: Sequence.cpp
	g++ -c Sequence.cpp

parser.o: parser.cpp
	g++ -c parser.cpp

CmaxFlowShop.o:  CmaxFlowShop.cpp
	g++ -c CmaxFlowShop.cpp

main: main.o parser.o Job3M.o Rmax.o Sequence.o
	g++ main.o parser.o Job3M.o Rmax.o Sequence.o -o main.exe

Cmax: CmaxFlowShop.o parser.o Job3M.o Rmax.o Sequence.o
	g++ CmaxFlowShop.o parser.o Job3M.o Rmax.o Sequence.o -o Cmax.exe

clean:
	del *.o
	del *.exe 
	
