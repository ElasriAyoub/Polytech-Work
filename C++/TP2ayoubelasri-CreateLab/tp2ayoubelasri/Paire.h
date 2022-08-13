#pragma once
#include <string>  // header
namespace labyrinthe
{
class Paire
{
    public:
        Paire(int first,int second);
        unsigned int getFirst() const;
        unsigned int getSecond() const;
        std::string toString() const;
        bool operator==(const Paire & p) const;
        unsigned int operator[](unsigned i) const;
    private:
        unsigned  _first,_second;
};
}

