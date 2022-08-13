#pragma once
#include<vector>
#include<string>
namespace flowshop
{
class Parser
{
    public:
      static std::vector<std::vector<double>> parse(const std::string & str);
};
}

