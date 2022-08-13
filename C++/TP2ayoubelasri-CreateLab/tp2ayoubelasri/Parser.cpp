#include "Parser.h"
#include <iostream>
#include<fstream>
#include <string>
#include <regex>
using namespace std;

namespace labyrinthe
{	
	// Exception const char * si pb de syntaxe
  std::vector<unsigned char> Parser::parse(const std::string & str)
  {
    std::vector<unsigned char> cells;
    std::regex rx("[0-3]+");
    std::smatch m;
    if (std::regex_match(str, m, rx))
    {
        for(unsigned i=0;i<str.size();i++)
        {
            cells.push_back(str[i]-'0');
        }
        return cells;
    }
    else
	{
		throw "Erreur de syntaxe";
	}
   }
}
