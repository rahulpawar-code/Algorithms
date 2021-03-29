// https://aozturk.medium.com/simple-hash-map-hash-table-implementation-in-c-931965904250

/*
 Compilation
 $ g++ -I$(pwd) test.cpp

 Memory leak check
 $ valgrind --leak-check=full --show-leak-kinds=all --track-origins=yes --verbose ./a.out
 $ valgrind --leak-check=full --show-leak-kinds=all --track-origins=yes --verbose ./a.out
*/

#include "hashmap.h"
#include <string>
#include <cstddef>

struct MyKeyHash {
    unsigned long operator()(const int& k) const
    {
        return k % 10;
    }
};

int main()
{
    HashMap<int, std::string, 10, MyKeyHash> map;
    map.put(1, "alice");
    map.put(2, "bob");
    map.put(3, "charlie");
    map.put(4, "eve");

    map.remove(4);
    std::string  value;
    map.get(3, value);
    std::cout << value << "\n";

    return 0;
}