#pragma once
#include "Piece.h"

namespace tetris
{

class PieceT : public Piece
{
public:
	PieceT(const Tab2DChar & tab,unsigned posLi,unsigned posCo);
	PieceT(const Piece & P,unsigned pL,unsigned pC);
	virtual ~PieceT();
	void getPosition(unsigned & posL,unsigned &posCo) const;
	void setPosition(unsigned posL,unsigned posC);
	unsigned getPosLi() const;
	unsigned getPosCo() const;
	char getCharAt(unsigned li,unsigned co) const;
	bool chevauche(const PieceT & p) const;
private:
	unsigned _posLi;
	unsigned _posCo;
};

}
