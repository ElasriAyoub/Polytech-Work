#pragma once
#include"Rmax.h"
#include"Matrice.h"
#include"Sequence.h"
#include"Job3M.h"
#include<string>
#include<vector>
#include<sstream>
#include<iostream>

using namespace std;
using namespace math;
namespace flowshop
{
        Sequence::Sequence()
        {
        }
        Sequence::Sequence(std::vector<Job3M> J)
        {
            _jobs = J;
        }
        string Sequence::toString() const
        {
            stringstream ss;
            for(unsigned i=0; i<_jobs.size(); i++)
            {
                ss << _jobs[i].toString();
            }
            return ss.str();
        }
        void Sequence::add(Job3M& jo)
        {
            _jobs.push_back(jo);
        }
        unsigned Sequence::getSize()const
        {
            return _jobs.size();
        }
        double Sequence::getChargeMachine(unsigned i) const
        {
            double seq;
            for(unsigned k=0 ; k<_jobs.size();k++)
                {
                    seq += _jobs[k].getDureeMachine(i);
                }
                return seq;
        }
        double Sequence::getMakespan() const
        {
         return getProfil()[2];
        }




        std::vector<double> Sequence::getProfil() const
        {
             vector<double> vec(3);
             Matrice<Rmax> s(1,3);
             s(0,0) = 0;
             s(0,1) = 0;
             s(0,2) = 0;

             for (int j=0; j<_jobs.size(); j++)
            {
                s = s* _jobs[j].getMatrice();
            }

            for(int i=0; i<3; i++)
            {
                    vec[i] = s(0,i).getVal();
            }
            return vec;
        }
        Job3M Sequence::getJob(unsigned i) const
        {
            return _jobs[i];
        }
        Job3M Sequence::operator[](unsigned i)
        {
            return _jobs[i];
        }
        Sequence& Sequence::operator<=(const Job3M& J)
        {
            this->_jobs.push_back(J);
            return *this;
        }



}
