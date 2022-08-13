#pragma once
#include<string>
namespace labyrinthe
{


class Cellule
{
    public:
        Cellule(unsigned char murs);
        bool getSud() const;
        bool getEst() const;
        void setSud(bool state);
        void setEst(bool state);
        std::string toString() const;
        unsigned char getMurs() const;

    private:
       unsigned char _murs;
};



}
