#include <iostream>
#include<conio.h>
#include "Tas.h"
#include<time.h>

using namespace std;
using namespace tetris;

int main()
{
    srand(time(NULL));
    int num1 = rand()%4;
    int num2 = rand()%4;
    int hautGrille = 10+num1;
    int largGrille = 8+num2;
    Tas grille(hautGrille, largGrille);
    char touche;
    do{
        cout << grille.toString();
        while(!_kbhit());
        cout << "Entrer (Z pour Rotation , S pour Empiler, D pour Deplacer a Droite, Q Deplacer a Gauche)"<< endl;
        touche=_getch();
        switch(touche)
        {
            case 'Z': grille.rotationPL();
                break;
            case 'S': grille.empilerPL();
                break;
            case 'D': grille.deplacerPL_D();
                break;
            case 'Q': grille.deplacerPL_G();
                break;
        }
        system("cls");

    }while(touche!='q');
}
