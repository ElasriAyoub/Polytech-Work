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

int main(int nargs, char ** args)
{

		string s(args[1]);
		//cout << "arg"<<1<<"=" << s << endl;
		auto vect=Parser::parse(s);
		//cout << vect[0][0];
		Sequence Seq;
		for(int i=0; i<vect.size(); i++)
        {
            Job3M J(vect[i][0],vect[i][1],vect[i][2]);
            Seq <= J;
        }

        cout << Seq.toString()<<endl;

        for(int i=0; i<3; i++)
        {
        cout << "Charge sur M" << i+1<< "= "<< Seq.getChargeMachine(i) <<endl;
        }

        cout << "Cmax = " << Seq.getMakespan();

	return 0;
}
