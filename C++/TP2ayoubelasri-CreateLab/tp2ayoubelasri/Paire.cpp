//Paire.cpp
#include "Paire.h"
#include <sstream>  //inclusion pour stringstream

namespace labyrinthe
{
Paire::Paire(int first,int second):_first(first),_second(second)
{    //ctor
}

unsigned int Paire::getFirst() const
{
    return _first;
}

unsigned int Paire::getSecond() const
{
    return _second;
}

std::string Paire::toString() const
{
    std::stringstream ss;
    ss<< "<" << _first << "," << _second << ">";
    return ss.str();
}
unsigned int Paire::operator[](unsigned i) const
{
    if(i==0) return getFirst();
    else return getSecond();
}
bool Paire::operator==(const Paire & p) const
{
    return (_first==p._first && _second==p._second);
}
}
