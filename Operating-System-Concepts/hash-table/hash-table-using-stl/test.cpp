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

struct StringKeyHash {
    unsigned long operator()(const std::string& key, size_t tableSize) const
    {
        unsigned long hash = 5381;

        for (auto ch : key) {
            hash = ((hash << 5) + hash) + static_cast<int>(ch);
        }

        return hash % tableSize;
    }
};

int main()
{
    HashMap<std::string, std::string, 1024, StringKeyHash> map;
    map.put("abc", "alice");
    map.put("xyz", "bob");
    map.put("mno", "charlie");
    map.put("pqr", "eve");

    map.remove("pqr");
    std::string  value;
    map.get("abc", value);
    std::cout << value << "\n";

    return 0;
}