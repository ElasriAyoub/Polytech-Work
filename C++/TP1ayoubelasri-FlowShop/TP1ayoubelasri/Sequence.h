#pragma once
#include"Rmax.h"
#include"Matrice.h"
#include"Job3M.h"
#include<string>
#include<vector>
#include<sstream>


using namespace math;
namespace flowshop
{
class Sequence
{
    public:
        Sequence();
        Sequence(std::vector<Job3M> J);
        std::string toString() const;
        void add(Job3M& jo);
        unsigned getSize()const;
        double getChargeMachine(unsigned i) const;
        double getMakespan() const;
        std::vector<double> getProfil() const;
        Job3M getJob(unsigned i) const;
        Job3M operator[](unsigned i);
        Sequence& operator<=(const Job3M& J);



    private:
        std::vector<Job3M> _jobs;
};

}
