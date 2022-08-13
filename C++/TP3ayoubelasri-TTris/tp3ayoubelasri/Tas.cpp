#include "Tas.h"
#include "PieceT.h"
#include<time.h>
#include<string>
#include<vector>
#include<sstream>
using namespace std;

namespace tetris
{
        Tas::Tas(unsigned H, unsigned L): _hauteur(H), _largeur(L), _pieceLibre(PieceT(Piece::pieceTetris(3,'x'),0,0))
        {
            newPL();
        }





        int Tas::getHauteur() const
        {
            return _hauteur;
        }





        int Tas::getLargeur() const
        {
            return _largeur;
        }




      std::string Tas::toString() const
        {


            stringstream ss;
            for(int i=0; i < getHauteur(); i++)
            {
                for(int j=0; j < getLargeur(); j++)
                {
                    if(i<3)
                    {
                        if(_pieceLibre.getCharAt(i,j) == 0)
                            ss<<' ';
                        else
                            ss<<_pieceLibre.getCharAt(i,j);
                   }
                    if(i>=3)
                    {

                       for(int k=0; k<_tas.size(); k++)
                         {
                         if(_tas[k].getCharAt(i,j) == 0)
                            ss<<'.';
                         else
                            ss<<_tas[k].getCharAt(i,j);
                         }
                    }
                }
                ss<<endl;
            }
            return ss.str();

 }







        void Tas::newPL()
        {
        srand(time(NULL));
        int num = rand()%6;
        int character = rand()%6;
        char ranked;

        switch(character)
            {
            case 0 : ranked ='+';
                    break;
            case 1 : ranked ='x';
                     break;
            case 2 : ranked ='X';
                    break;
            case 3 : ranked ='O';
                    break;
            case 4 : ranked ='o';
                     break;
            case 5 : ranked ='#';
                     break;
            }
        _pieceLibre=PieceT(Piece::pieceTetris(num,ranked),0,0);
        }






        PieceT Tas::getPL() const
        {
            return _pieceLibre;
        }






        char Tas::getCharAt(unsigned li, unsigned co) const
        {
            if(li <= 3)
                if(_pieceLibre.getCharAt(li,co) == '0')
                    return 0;
                else
                    return _pieceLibre.getCharAt(li,co);
            if(li>3)
                for(int i=0; i< _tas.size(); i++)
                {
                    if(_tas[i].getCharAt(li,co) == '0')
                        return 0;
                    else
                        return _tas[i].getCharAt(li,co);
                }
        }





        void Tas::deplacerPL_D()
        {
            _pieceLibre.setPosition(_pieceLibre.getPosLi(),_pieceLibre.getPosCo() + 1);
            if(chevauche(_pieceLibre))
            {
            _pieceLibre.setPosition(_pieceLibre.getPosLi(),_pieceLibre.getPosCo()-1);
            }
        }




        void Tas::deplacerPL_G()
        {
            _pieceLibre.setPosition(_pieceLibre.getPosLi(),_pieceLibre.getPosCo() - 1);
            if(chevauche(_pieceLibre))
            {
            _pieceLibre.setPosition(_pieceLibre.getPosLi(),_pieceLibre.getPosCo()+1);
            }
        }






        void Tas::rotationPL()
        {
            _pieceLibre.rotation();
            _pieceLibre.rotation();
            _pieceLibre.rotation();

        }





        void Tas::empilerPL()
        {
            while(!chevauche(_pieceLibre))
            {
                _pieceLibre.setPosition(_pieceLibre.getPosLi()+1,_pieceLibre.getPosCo());
            }
            _pieceLibre.setPosition(_pieceLibre.getPosLi()-2,_pieceLibre.getPosCo());
            _tas.push_back(_pieceLibre);
            newPL();
        }







        void Tas::supprimerPiece(unsigned i)
        {

        }










        PieceT Tas::getPiece(unsigned i) const
        {
            return _tas[i];
        }









        PieceT Tas::operator[](unsigned i) const
        {
            return _tas[i];
        }









        unsigned Tas::getNbPieces() const
        {
            return _tas.size();
        }






        bool Tas::chevauche(PieceT p)
        {
            for(int i=0; i< _tas.size();i++)
            {
                if(p.chevauche(_tas[i]))
                {
                    return true;
                }
            }
                for(int x=p.getPosLi(); x <p.getPosLi() + p.getHauteur(); x++)
                {
                    for(int y=p.getPosCo(); y <p.getPosCo() + p.getLargeur();y++)
                    {
                        if(x > getHauteur() || y > getLargeur() || x < 0 || y < 0 )
                            return true;
                    }
                }
            return false;
        }





        void Tas::compacter()
        {

        }





        bool Tas::testLigneVide(unsigned li)
        {
            for(int j=0; j<getLargeur();j++)
            {
                if(getCharAt(li, j)!='0')
                    return false;
            }
        return true;
        }
}
