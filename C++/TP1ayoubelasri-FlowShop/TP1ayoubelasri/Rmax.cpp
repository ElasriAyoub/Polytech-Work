#include "Rmax.h"
#include <ostream>
#include <limits>


using namespace std;

namespace math{
Rmax::Rmax():_val(epsilon())
{
    //ctor
}

Rmax::Rmax(double x): _val(x)
{

}

double Rmax::getVal() const
{
    return _val;
}

double Rmax::epsilon()
{
    double eps = numeric_limits<double>::lowest();
    return eps;
}

void Rmax::setVal(double x)
{
    _val=x;
}



Rmax Rmax::operator+(const Rmax & R)
{
    if(_val > R._val)
        return *this;
    else return R;
}


Rmax Rmax::operator*(const Rmax & R)
{
    Rmax L;
    L._val =_val+R._val;
    return L;
}

ostream & operator<<(ostream & flot,const Rmax & R)
{
    flot << R.getVal();
    return flot;
}
}

