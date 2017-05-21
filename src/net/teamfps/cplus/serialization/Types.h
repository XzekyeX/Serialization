#pragma once
/**
* @author Zekye
*
*/
typedef unsigned char ubyte;
typedef unsigned int uint;

#include "ContainerType.h"
#include "Type.h"

#include <vector>
#include <string>
#include <iostream>

using std::vector;
using std::string;

#define println(str) std::cout << str << std::endl;
#define print(str) std::cout << str;
#define printlnHex(str,value) std::cout << str << "0x" << std::hex << (int)value << std::endl;
#define readln(str) std::cin >> str;