#include <iostream>
#include"Cellule.h"
#include"CelluleV.h"
#include"Labyrinthe.h"
#include<vector>

using namespace std;
using namespace labyrinthe;


int main()
{
    /*
    unsigned char x=97;
    cout << x << endl;
    cout << (int) x << endl; //a
    */
/*
     //main 1:
    Cellule R(0);
    cout << R.toString() << endl;
    R.setEst(true);
    cout << R.toString() << endl;
    R.setSud(false);
    cout << R.toString() << endl;
    cout << R.getEst() << endl;
    cout << R.getSud() << endl;
    cout << R.getMurs() << endl;

*/

/*     //main 2:
    Cellule R(1);
    CelluleV A(R, 5);
    cout << A.getVal() << endl;
*/


vector<Cellule> v =  {Cellule(1),Cellule(0),Cellule(3),Cellule(1),
                            Cellule(1),Cellule(0),Cellule(2),Cellule(1),
                            Cellule(1),Cellule(1),Cellule(0),Cellule(3),
                            Cellule(2),Cellule(3),Cellule(2),Cellule(3)};
    Labyrinthe L(4,4,v);
  /*  for(unsigned _i=0; _i<4 ; _i++)
         {
           for (unsigned _j=0; _j<4 ; _j++)
            {
            cout << (int)(L.getCell(_i,_j).getMurs())<< endl;
            }
        }
*/
/*
    for(unsigned i=0; i<L.getVoisins(1,2).size(); i++)
    cout << L.getVoisins(1,2)[i].toString()<<endl;
*/

    //Labyrinthe L(2,2);
    //cout<< L(0,0).getVal();
    cout << L.toString()<<endl;
    //L.resetVal();
    //cout << L.toString()<<endl;

  cout << L.getCellsAsString()<<endl;
  //cout << L(0,0).toString()<<endl;*/
    return 0;
}
