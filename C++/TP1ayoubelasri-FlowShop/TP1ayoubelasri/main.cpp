#include <iostream>
#include "Rmax.h"
#include "Matrice.h"
#include "Job3M.h"
#include "Sequence.h"
#include <sstream>
#include<ctime>
#include"Parser.h"

using namespace std;
using namespace math;
using namespace flowshop;

int main(int argc, char *argv[]){
srand(time(NULL));
auto v=Parser::parse("[1,2.4,3][3,4,7.5]"); // extraction des durées
Job3M J1(2,4.5,5);
Job3M J2(3,1,7);
cout << J1.toString() << endl; //[2,4.5,5]
cout << J2.toString() << endl; //[3,1,7]
cout << J1.getDureeMachine(0) << endl; // durée sur M1=2
cout << J1[1] << endl; //durée sur M2=4
Matrice<Rmax> mJ1=J1.getMatrice(); // matrice (max,+)
cout << mJ1.toString() << endl; //[2 6.5 11.5;0 4.5 9.5;-4.5 0 5]
Sequence S1,S2; //séquences vides
S1.add(J1); // ajoute J1 en fin
S1.add(J2);
cout << S1.toString() << endl; //[2,4.5,5][3,1,7]
cout << S1.getChargeMachine(1) << endl; //5.5=4.5+1
S2<=J2<=J1;
cout << S2.toString() << endl; //[3,1,7][2,4.5,5]
cout << S1.getMakespan() << endl; //18.5
cout << S2.getMakespan() << endl; //16
}
