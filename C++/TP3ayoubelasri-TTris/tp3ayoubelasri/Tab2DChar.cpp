#include "Tab2DChar.h"
#include<iostream>
using namespace std;

namespace tetris
{

Tab2DChar::Tab2DChar(int li,int co):_m(li,std::vector<char>(co)){ }


Tab2DChar::Tab2DChar(int li,int co,const std::vector<char> & v):_m(li,std::vector<char>(co))
{
	int k=0;
	for(int i=0;i<li;i++)
	{
		for(int j=0;j<co;j++)
		{
			if(k<v.size()) _m[i][j]=v[k];
			else _m[i][j]=0;
			k++;
		}
	}
}

Tab2DChar::~Tab2DChar()
{

}

char & Tab2DChar::operator ()(int iL,int iC)
{
	return _m[iL][iC];
}
char Tab2DChar::operator ()(int iL,int iC) const
{
	return _m[iL][iC];
}
unsigned Tab2DChar::getLignes() const
{
	return _m.size();
}

unsigned Tab2DChar::getColonnes() const
{
	if(getLignes())
	{
		return _m[0].size();
	}
	else return 0;
}
}

