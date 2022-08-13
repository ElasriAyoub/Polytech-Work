#pragma once
#include<vector>
#include<string>
#include<sstream>

namespace math
{

template <class T>
class Matrice
{
  private :
        std::vector<std::vector<T> > _mat;
    public:

	Matrice(unsigned li,unsigned co):_mat(li,std::vector<T>(co))
    {
        if (li == 0 || co == 0){    _mat.resize(1, std::vector<T>(1));}
	}

    std::string toString() const
    {
	std::stringstream ss;
	ss << "[";
	for (unsigned i = 0; i < _mat.size(); i++)
	{
		for (unsigned j = 0; j < _mat[0].size(); j++)
		{
			ss << _mat[i][j];
			if(j!=_mat[0].size()-1) ss << " ";
		}
		if(i!=_mat.size()-1) ss << ";";
	}
	ss << "]";
	return ss.str();
    }
	T & operator()(unsigned li, unsigned co){	return _mat.at(li).at(co);}
	T  operator()(unsigned li, unsigned co) const{	return _mat.at(li).at(co);}

	Matrice operator+(const Matrice<T> & m) const
	{
        Matrice<T> res(*this);
        for (unsigned i = 0; i < getLignes(); i++)
        {
            for (unsigned j = 0; j < getColonnes(); j++)
            {
                res(i,j) =res(i, j) + m(i, j);
            }
        }
        return res;
    }

    Matrice<T> operator*(const Matrice<T> & m) const
    {
        Matrice<T> res(getLignes(),m.getColonnes());
        for (unsigned i = 0; i < res.getLignes(); i++)
        {
            for (unsigned j = 0; j < res.getColonnes(); j++)
            {
                for (unsigned k = 0; k < getColonnes(); k++)
                {
                    res(i, j) = res(i,j) + (*this)(i, k) * m(k, j);
                }
            }
        }
        return res;
    }

	unsigned getLignes() const { return _mat.size(); }
	unsigned getColonnes() const { return _mat[0].size(); }

};

}
