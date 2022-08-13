#pragma once
#include"Rmax.h"
#include"Matrice.h"
#include<string>
#include<vector>
#include<sstream>

using namespace math;
namespace flowshop
{

class Job3M
{
    public:
        Job3M();
        Job3M(double a,double b,double c);
        double getDureeMachine(unsigned i) const;
        double operator[](unsigned i) const;
        std::string toString() const;
        Matrice<Rmax> getMatrice() const;


    private:
        std::vector<double> _durees;
};


}
