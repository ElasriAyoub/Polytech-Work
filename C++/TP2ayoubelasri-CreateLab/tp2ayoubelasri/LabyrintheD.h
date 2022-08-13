#pragma once
#include "CelluleV.h"
#include "Cellule.h"
#include "Paire.h"
#include "Labyrinthe.h"

#include<vector>

namespace labyrinthe
{

class LabyrintheD : public Labyrinthe
{
    public:
        LabyrintheD(unsigned h, unsigned l);
        LabyrintheD(unsigned h, unsigned l, std::vector<Cellule> Cell);
        LabyrintheD(Labyrinthe Lab);
        void setDistancesFromCell(unsigned i,unsigned j);
        static LabyrintheD creer(unsigned h, unsigned l);

    private:
};

}
