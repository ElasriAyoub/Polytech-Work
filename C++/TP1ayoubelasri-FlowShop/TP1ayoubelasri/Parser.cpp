#include "Parser.h"
#include <iostream>
#include<fstream>
#include <string>
#include <regex>

using namespace std;
namespace flowshop
{
    vector<vector<double>> Parser::parse(const std::string & str)
  {
    std::regex rx("(\\[(\\d+(.\\d+)?,){2}(\\d+(.\\d+)?)\\])+");   
    std::regex rx3("([.\\d]+)");
    std::smatch m;

    vector<vector<double>> v;
    if (std::regex_match(str, m, rx))
    {
        std::string log=str;
        vector<double> lot;
        while(regex_search(log, m, rx3))
        {
            float val = atof(m.str().c_str());
            log=m.suffix();
            lot.push_back(val);
            if(lot.size()==3)
            {
                v.push_back(lot);
                lot.resize(0);
            }
        }
         return v;
    }
    else
    {       
        throw "Erreur de syntaxe";
    }
  }


}
