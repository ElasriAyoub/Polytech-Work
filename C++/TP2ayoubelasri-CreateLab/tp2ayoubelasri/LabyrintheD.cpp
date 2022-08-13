#include "LabyrintheD.h"
#include "CelluleV.h"
#include "Labyrinthe.h"
#include "Cellule.h"
#include "Paire.h"
#include<vector>

namespace labyrinthe
{


        LabyrintheD::LabyrintheD(unsigned h, unsigned l): Labyrinthe(h,l)
        {
        }

        LabyrintheD::LabyrintheD(unsigned h, unsigned l, std::vector<Cellule> Cell): Labyrinthe(h,l,Cell)
        {
        }


        LabyrintheD::LabyrintheD(Labyrinthe Lab): Labyrinthe(Lab)
        {
        }


        void LabyrintheD::setDistancesFromCell(unsigned i,unsigned j)
        {
            /*vector<Paire> noMar;
            LabyrintheD A(i,j);
            A.getCell(i,j).setVal(1);
            while(noMar.size() != 0)
            {
            unsigned cpt=1:
            for(unsigned _i=0; _i<A.getHauteur() ; _i++)
                {
                for (unsigned _j=0; _j<A.getHauteur() ; _j++)
                    {
                          if(A.getVoisins(i,j)[i]==
                    }
                }
            }


            for(unsigned _i=0; _i<A.getHauteur() ; _i++)
                {
                for (unsigned _j=0; _j<A.getHauteur() ; _j++)
                    {
                      if(A.getCell(i,j).getVal() == 0)
                          noMar.push_back(Paire(i,j));
                    }
                }
            }

*/


        }


        LabyrintheD LabyrintheD::creer(unsigned h, unsigned l)
        {


        }


}
