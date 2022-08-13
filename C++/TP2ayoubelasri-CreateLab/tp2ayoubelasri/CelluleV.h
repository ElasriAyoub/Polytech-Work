#pragma once
#include "Cellule.h"

namespace labyrinthe
{


class CelluleV : public Cellule
{
    public:
        CelluleV(unsigned char mur,unsigned val);
        CelluleV(unsigned char mur);
        CelluleV(Cellule R,unsigned val);
        unsigned getVal();
        void setVal(unsigned val);
  private:
      unsigned _val;
};


}

