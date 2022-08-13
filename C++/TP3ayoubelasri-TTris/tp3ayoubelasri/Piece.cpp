#include "Piece.h"

using namespace std;

namespace tetris
{

Piece::Piece(const Tab2DChar & t):_T(t)
{}

Piece::~Piece(){ }

void Piece::rotation()
{
	int li=_T.getLignes();
	int co=_T.getColonnes();
	Tab2DChar T(co,li);

	for(int i=co-1;i>=0;i--){
		for(int j=0;j<li;j++)
		{
			T(co-i-1,j) = _T(j,i);
		}
	}
	_T=T;
}

unsigned Piece::getHauteur() const
{
	return _T.getLignes();
}

unsigned Piece::getLargeur() const
{
	return _T.getColonnes();
}

char Piece::operator()(int iL,int iC) const
{
		return _T(iL,iC);
}

Piece Piece::pieceTetris(unsigned num,char c)
{
    Piece pT(Tab2DChar(1,1,vector<char>(1,'X')));
    switch(num)
    {
    case 0:
      // piece T
      pT = Piece(Tab2DChar(2,3,{c,c,c,0,c,0}));
      break;
    case 1:
      // piece L
       pT= Piece(Tab2DChar(2,3,{c,c,c,c,0,0}));
      break;
    case 2:
       // piece J
      pT = Piece(Tab2DChar(2,3,{c,c,c,0,0,c}));
      break;
    case 3:
       // piece O
      pT = Piece(Tab2DChar(2,2,{c,c,c,c}));
      break;
    case 4:
       // piece Z
      pT = Piece(Tab2DChar(2,3,{c,c,0,0,c,c}));
      break;
    case 5:
       // piece S
      pT = Piece(Tab2DChar(2,3,{0,c,c,c,c,0}));
      break;
    default:
        // piece I (sur 3 cases)
      pT = Piece(Tab2DChar(1,3,{c,c,c}));
      break;
    }
	return pT;
}

}

