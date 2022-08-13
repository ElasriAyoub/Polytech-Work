#include "Job3M.h"
#include"Rmax.h"
#include"Matrice.h"
#include<sstream>

using namespace std;

using namespace math;
namespace flowshop
{

Job3M::Job3M()
{
    //ctor
}


Job3M::Job3M(double a, double b, double c)
{
    _durees.push_back(a);
    _durees.push_back(b);
    _durees.push_back(c);
}

double Job3M::getDureeMachine(unsigned i) const
{
    return _durees[i];
}

double Job3M::operator[](unsigned i) const
{
    return _durees[i];
}

string Job3M::toString() const
{
    stringstream ss;
    ss << "[" << getDureeMachine(0)<< "," << getDureeMachine(1)<< ',' << getDureeMachine(2)<< ']';
    return ss.str();
}

 Matrice<Rmax> Job3M::getMatrice() const
 {
     Matrice<Rmax> Ro(3,3);

     double D1=this->getDureeMachine(0);
     double D2=this->getDureeMachine(1);
     double D3=this->getDureeMachine(2);

     Ro(0,0) = D1;
     Ro(0,1) = D1+D2;
     Ro(0,2) = D1+D2+D3;
     Ro(1,0) = 0;
     Ro(1,1) = D2;
     Ro(1,2) = D2+D3;
     Ro(2,0) = -D2;
     Ro(2,1) = 0;
     Ro(2,2) = D3;

     return Ro;

 }

}


