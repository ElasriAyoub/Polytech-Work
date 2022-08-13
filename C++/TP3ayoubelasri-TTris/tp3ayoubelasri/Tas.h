#pragma once
#include<string>
#include<vector>
#include "PieceT.h"

namespace tetris
{

class Tas
{
    public:
        Tas(unsigned H, unsigned L);
        int getHauteur() const;
        int getLargeur() const;
        std::string toString() const;
        void newPL();
        PieceT getPL() const;
        char getCharAt(unsigned li, unsigned co) const;
        void deplacerPL_D();
        void deplacerPL_G();
        void rotationPL();
        void empilerPL();
        void supprimerPiece(unsigned i);
        PieceT getPiece(unsigned i) const;
        PieceT operator[](unsigned i) const;
        unsigned getNbPieces() const;
        bool chevauche(PieceT p);
        void compacter();
        bool testLigneVide(unsigned li);


    protected:

    private:
        unsigned _hauteur;
        unsigned _largeur;
        PieceT _pieceLibre;
        std::vector<PieceT> _tas;
};


}
