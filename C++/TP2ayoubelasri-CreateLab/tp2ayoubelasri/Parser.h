#pragma once
#include <string>
#include <vector>

namespace labyrinthe
{
  class Parser
  {
  public:
    static std::vector<unsigned char> parse(const std::string & str);
  };
}
