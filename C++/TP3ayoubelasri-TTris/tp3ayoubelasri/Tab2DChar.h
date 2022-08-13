#pragma once
#include<vector>
namespace tetris
{

class Tab2DChar
{
public:
	Tab2DChar  (int li,int co);
	Tab2DChar  (int li,int co,const std::vector<char> & v);
	virtual ~Tab2DChar  ();
	char & operator()(int iL,int iC);
	char operator()(int iL,int iC) const;
	unsigned getLignes() const;
	unsigned getColonnes() const;
private:
	std::vector< std::vector<char> > _m;

};

}
