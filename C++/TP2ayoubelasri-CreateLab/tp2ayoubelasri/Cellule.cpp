#include "Cellule.h"

using namespace std;
namespace labyrinthe
{


    Cellule::Cellule(unsigned char murs): _murs(murs)
    {

    }



    bool Cellule::getSud() const
    {
        if (_murs== 2 || _murs== 3)
            return true;
        else
            return false;
    }



    bool Cellule::getEst() const
    {
        if (_murs== 1)
            return true;
        else
            return false;
    }



    void Cellule::setSud(bool state)
    {

        if (state==true)
        {
            if(getMurs()== 1)
                _murs= 3;

            if(getMurs() == 0)
                _murs= 2;
        }
    }


    void Cellule::setEst(bool state)
    {
        if (state==true)
        {
            if(getMurs()== 2)
                _murs= 3;

            if(getMurs() == 0)
                _murs= 1;
        }
    }


    string Cellule::toString() const
    {
        if(_murs== 0)
            return "  ";
        if(_murs== 1)
            return " |";
        if(_murs== 2)
            return "_ ";
        if(_murs== 3)
            return "_|";
    }




    unsigned char Cellule::getMurs() const
    {
        return _murs;
    }




}
