#include "CelluleV.h"
#include "Cellule.h"



namespace labyrinthe
{

        CelluleV::CelluleV(unsigned char mur,unsigned val): Cellule(mur),_val(val)
        {

        }


        CelluleV::CelluleV(unsigned char mur) : Cellule(mur)
        {

        }

        CelluleV::CelluleV(Cellule R,unsigned val): Cellule(R),_val(val)
        {

        }


        unsigned CelluleV::getVal()
        {
            return _val;
        }

        void CelluleV::setVal(unsigned val)
        {
            val=_val;
        }



}

