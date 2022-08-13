#pragma once
#include "CelluleV.h"
#include "Cellule.h"
#include "Paire.h"
#include<vector>

namespace labyrinthe
{

class Labyrinthe
{
    public:
        Labyrinthe(unsigned h,unsigned l);
        Labyrinthe(unsigned h,unsigned l, std::vector<Cellule> v);
        void set(std::vector<Cellule> v);
        unsigned getHauteur() const;
        unsigned getLargeur() const;
        CelluleV getCell(unsigned i, unsigned j) const;
        void setCell(unsigned i, unsigned j, CelluleV cell);
        std::vector<Paire> getVoisins(unsigned li, unsigned co) const;
        std::string toString() const;
        void resetVal();
        std::string getCellsAsString() const;
        CelluleV operator()(unsigned i,unsigned j);

    private:
        unsigned _h;
        unsigned _l;
        std::vector<CelluleV> _v;
};


}
