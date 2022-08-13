#include "Labyrinthe.h"
#include "CelluleV.h"
#include "Cellule.h"
#include "Paire.h"
#include<vector>
#include<sstream>

using namespace std;
namespace labyrinthe
{

        Labyrinthe::Labyrinthe(unsigned h,unsigned l): _h(h), _l(l)
        {
            for(unsigned i=0; i<h*l; i++)
            {
                _v.push_back(CelluleV(3,0));
            }
        }

        Labyrinthe::Labyrinthe(unsigned h,unsigned l, vector<Cellule> v): _h(h), _l(l)
        {
            for(unsigned i=0; i<h*l; i++)
            {
                _v.push_back(CelluleV(v[i],0));
            }
        }

        void Labyrinthe::set(vector<Cellule> v)
        {
            if(_h*_l > v.size())
            {
                for(unsigned i=0; i<v.size(); i++)
                {
                    _v.push_back(CelluleV(v[i],0));
                }
                for(unsigned i=v.size(); i<_v.size(); i++)
                {
                    _v.push_back(CelluleV(3,0));
                }
            }

            }

        unsigned Labyrinthe::getHauteur() const
        {
            return _h;
        }

        unsigned Labyrinthe::getLargeur() const
        {
            return _l;
        }


        CelluleV Labyrinthe::getCell(unsigned i, unsigned j) const
        {
         unsigned kj=-1;
         for(unsigned _i=0; _i<_h ; _i++)
         {
           for (unsigned _j=0; _j<_l ; _j++)
            {
                kj=kj+1;
                if(_j== j && _i==i)
                    return _v[kj];
            }
         }
          }

        void Labyrinthe::setCell(unsigned i, unsigned j, CelluleV cell)
        {
         unsigned kj=-1;
         for(unsigned _i=0; _i<_h ; _i++)
         {
           for (unsigned _j=0; _j<_l ; _j++)
            {
                kj=kj+1;
                if(_j== j && _i==i)
                     _v[kj]=cell;
            }
         }
        }

        vector<Paire> Labyrinthe::getVoisins(unsigned i, unsigned j) const
        {

         /*unsigned kj=-1;
         vector<Paire> index;
         vector<CelluleV> var;
         bool stateGauche=false;
         bool stateDroite=false;
         bool stateHaut=false;
         bool stateBas=false;

         for(unsigned _i=0; _i<_h ; _i++)
         {
           for (unsigned _j=0; _j<_l ; _j++)
            {
                kj=kj+1;

                if(_j== j-1 && _i==i)
                     var.push_back(_v[kj]);
                if(_j== j+1 && _i==i)
                     var.push_back(_v[kj]);
                if(_j== j && _i==i)
                     var.push_back(_v[kj]);
                if(_j== j && _i==i-1)
                     var.push_back(_v[kj]);
                if(_j== j && _i==i+1)
                     var.push_back(_v[kj]);

            }
         }
         if(var[0].getMurs()==3 ||var[0].getMurs()==1)
            stateGauche=false;
         if(var[0].getMurs()==2 ||var[0].getMurs()==0)
            stateGauche=true;

         if(var[3].getMurs()==3 ||var[3].getMurs()==2)
            stateHaut=false;
         if(var[3].getMurs()==1 ||var[3].getMurs()==0)
            stateHaut=true;

         if(var[2].getMurs()==3)
            stateDroite=false;
            stateBas=false;

         if(var[2].getMurs()==2)
            stateDroite=true;
            stateBas=false;

         if(var[2].getMurs()==1)
            stateDroite=false;
            stateBas=true;

         if(var[2].getMurs()==0)
            stateDroite=true;
            stateBas=true;

        if(stateGauche==true)
        {
        index.push_back(Paire(i,j-1));
        }

        if(stateDroite==true)
        {
        index.push_back(Paire(i,j+1));
        }

        if(stateHaut==true)
        {
         index.push_back(Paire(i-1,j));
        }

        if(stateBas==true)
        {
        index.push_back(Paire(i+1,j));
        }

        return index;
        }
            */
    std::vector<Paire> Index;

    if (this->getCell(i,j).getMurs()==0)
    {
        if (i!=0 && i!=_h-1 && j!=0 && j!=_l-1)
        {
            if (this->getCell(i-1,j).getMurs()==0 || this->getCell(i+1,j).getMurs()==1)
                Index.push_back(Paire(i-1,j));
                Index.push_back(Paire(i+1,j));
                Index.push_back(Paire(i,j+1));
            if (this->getCell(i,j-1).getMurs()==0 || this->getCell(i,j-1).getMurs()==2)
                Index.push_back(Paire(i,j-1));
        }

        if(i==0)
        {
            if(j==0)
                {
                    Index.push_back(Paire(i,j+1));
                    Index.push_back(Paire(i+1,j));
                }
            else
            {
               Index.push_back(Paire(i+1,j));
               Index.push_back(Paire(i,j+1));
               if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
                    Index.push_back(Paire(i,j-1));
            }
        }

        if(j==0 && i!=0)
        {
           if (this->getCell(i-1,j).getMurs()==0||this->getCell(i+1,j).getMurs()==1)
                Index.push_back(Paire(i-1,j));
           Index.push_back(Paire(i+1,j));
           Index.push_back(Paire(i,j+1));
        }
    }

    if (this->getCell(i,j).getMurs()==2)
    {
        if (i!=0 && i!=_h-1 && j!=0 && j!=_l-1)
        {
            if (this->getCell(i-1,j).getMurs()==0||this->getCell(i-1,j).getMurs()==1)
                Index.push_back(Paire(i-1,j));
            if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
                Index.push_back(Paire(i,j-1));
            Index.push_back(Paire(i,j+1));
        }

        if(i==0)
        {
            if(j==0)
                {
                    Index.push_back(Paire(i,j+1));
                }
            else
            {
                Index.push_back(Paire(i,j+1));
                if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
                    Index.push_back(Paire(i,j-1));
            }
        }

       if(j==0 && i!=0)
        {
            Index.push_back(Paire(i,j+1));
            if (this->getCell(i-1,j).getMurs()==0||this->getCell(i-1,j).getMurs()==1)
                Index.push_back(Paire(i-1,j));
        }
        }
    if (this->getCell(i,j).getMurs()==1)
    {
        if (i!=0&&i!=_h-1&&j!=0&&j!=_l-1)
        {
        if (this->getCell(i-1,j).getMurs()==0||this->getCell(i-1,j).getMurs()==1)
           Index.push_back(Paire(i-1,j));
        if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
           Index.push_back(Paire(i,j-1));
        Index.push_back(Paire(i+1,j));
        }
        if(i==0)
        {
            if(j==0)
            {
                 Index.push_back(Paire(i+1,j));
            }
            else
            {
                if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
                    Index.push_back(Paire(i,j-1));
                Index.push_back(Paire(i+1,j));
            }
        }
        if (j==0&&i!=0)
        {
            if (this->getCell(i-1,j).getMurs()==0||this->getCell(i-1,j).getMurs()==1)
                Index.push_back(Paire(i-1,j));
            Index.push_back(Paire(i+1,j));
        }

    }
    if (this->getCell(i,j).getMurs()==3)
    {
         if (i!=0&&i!=_h-1&&j!=0&&j!=_l-1)
         {
         if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
           Index.push_back(Paire(i,j-1));
        if (this->getCell(i-1,j).getMurs()==0||this->getCell(i-1,j).getMurs()==1)
           Index.push_back(Paire(i-1,j));
           }
        if(i==0)
        {
            if(j==0)
            {

            }
            else
            {
                if (this->getCell(i,j-1).getMurs()==0||this->getCell(i,j-1).getMurs()==2)
                    Index.push_back(Paire(i,j-1));
            }
        }
        if (j==0&&i!=0)
        {
            if (this->getCell(i-1,j).getMurs()==0||this->getCell(i-1,j).getMurs()==1)
                    Index.push_back(Paire(i-1,j));
        }
    }
    return Index;
}






        std::string Labyrinthe::toString() const
        {
        std::stringstream ss;
        for(unsigned i=0; i<_h ; i++)
            {for (unsigned j=0; j<_l ; j++)
                {
                ss << this->getCell(i,j).toString();

                }
                ss <<endl;
                }

        return ss.str();
        }



        void Labyrinthe::resetVal()
        {
            for(unsigned i=0; i<_h ; i++)
            {for (unsigned j=0; j<_l ; j++)
                {    setCell(i, j, CelluleV(0));
                }
            }
             }

        std::string Labyrinthe::getCellsAsString() const
        {
        std::stringstream ss;
        for(unsigned i=0; i<_h ; i++)
            {for (unsigned j=0; j<_l ; j++)
                {
                ss << (int) this->getCell(i,j).getMurs();

                }
            }
                return ss.str();
        }

        CelluleV Labyrinthe::operator()(unsigned i,unsigned j)
        {

        return this->getCell(i,j);
        }


}
