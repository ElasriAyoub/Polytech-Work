#include "PieceT.h"
#include<iostream>
using namespace std;

namespace tetris
{

PieceT::PieceT(const Tab2DChar & Tab,unsigned pL,unsigned pC):Piece(Tab),_posLi(pL),_posCo(pC)
{
}

PieceT::PieceT(const Piece & P,unsigned pL,unsigned pC):Piece(P),_posLi(pL),_posCo(pC)
{
}

PieceT::~PieceT()
{
}

void PieceT::setPosition(unsigned pL,unsigned pC)
{
	_posLi=pL; _posCo=pC;
}

void PieceT::getPosition(unsigned & pL,unsigned & pC) const
{
	pL=_posLi; pC=_posCo;
}

unsigned PieceT::getPosLi() const
{
	return _posLi;
}

unsigned PieceT::getPosCo()const
{
	return _posCo;
}
 char PieceT::getCharAt(unsigned li,unsigned co) const
 {
     if(li>= _posLi && li<_posLi+this->getHauteur())
     {
        if(co>= _posCo && co<_posCo+this->getLargeur())
        {
            return (*this)(li-_posLi,co-_posCo);
        }
        else return 0;
     }
     else return 0;
 }

 bool PieceT::chevauche(const PieceT & p) const
 {
     if(this!=&p)
     {
        for(unsigned li=_posLi;li<_posLi+getHauteur();li++)
        {
            for(unsigned co=_posCo;co<_posCo+getLargeur();co++)
            {
                if(getCharAt(li,co)!=0 && p.getCharAt(li,co)!=0) return true;
            }
        }
        return false;
     }
     else return false;
 }

}
