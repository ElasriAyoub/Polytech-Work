#pragma once
#include "Tab2DChar.h"
#include<iostream>

namespace tetris
{

class Piece
{
public:	
	Piece(const Tab2DChar & t);
	virtual ~Piece();
	void rotation();
	unsigned getLargeur() const;
	unsigned getHauteur() const;
	char operator()(int iL,int iC) const;
	static Piece pieceTetris(unsigned num,char c);
protected:
	Tab2DChar _T;

};
}
