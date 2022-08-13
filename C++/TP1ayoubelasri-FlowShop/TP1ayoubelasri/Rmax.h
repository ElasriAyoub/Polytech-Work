#pragma once
#include<ostream>

namespace math{
class Rmax
{
    public:
        Rmax();
        Rmax(double x);
        double getVal() const;
        void setVal(double x);
        Rmax operator+(const Rmax &R);
        Rmax operator*(const Rmax &R);
        static double epsilon();
    private:
        double _val;
};

std::ostream & operator<<(std::ostream & flot,const Rmax & R);

}
