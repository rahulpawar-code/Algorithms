// Elementary Hash table implementation in C++

/*
 *  Hash value calculation : Hash key calculation  DJB algorithm from Daniel J. Bernstein.
 *  Storage : Array of certain CAPACITY
 *  Keys type: For simplicity assume key are string
 *  Values type : Values can be anything
 *  Collision : Collision resolution through linked list
 */

#include <iostream>
#include <vector>
#include <string>
#include <array>
#include <climits>

const unsigned int CAPACITY = 2048;

class HashTable
{
private:
    class Node
    {
        public:
            const std::string key;
            int value;

            Node(const std::string& k, int v) : key(k), value(v) { }

            void assignValue(int v) { value = v; }
    };


    std::array<std::vector<Node>, CAPACITY> table { };
 public:
    unsigned int keyHashIndex(const std::string& key)
    {
        unsigned int hash = 5381;
        for (auto ch : key) {
            hash = (hash << 5) + hash + static_cast<int>(ch);
        }
        return hash % CAPACITY;
    }


    HashTable() { }

    ~HashTable() = default;

    // If value for key already exists then overwrite value
    void put(const std::string& key, int value)
    {
        if (key.size() == 0) {
            return;
        }

        // check if node is present
        int index = keyHashIndex(key);
        for (auto node : table[index]) {
            if (key.compare(node.key) == 0) {
                node.assignValue(value);
                return;
            }
        }

        Node node(key, value);
        table[index].push_back(node);
    }

    int get(const std::string& key)
    {
        if (key.size() == 0) {
            return INT_MIN;
        }

        // check if node is present
        int index = keyHashIndex(key);
        for (auto node : table[index]) {
            if (key.compare(node.key) == 0) {
                return node.value;
            }
        }

        return INT_MIN;
    }

    int remove(const std::string& key)
    {
        if (key.size() == 0) {
            return INT_MIN;
        }

        // check if node is present
        int index = keyHashIndex(key);
        for (auto it = table[index].begin(); it != table[index].end(); ++it) {
            if ((*it).key.compare(key) == 0) {
                int v = (*it).value;
                //  ----- FIXME -------
                // it = table[index].erase(it); 
                return v;
            }
        }

        return INT_MIN;
    }
};

int main()
{
    HashTable table;
    table.put("alice", 46);
    table.put("bob", 11);
    table.put("charlie", 19);

    std::cout << "Value of key alice : " << table.get("alice") << "\n";
    std::cout << "Value of key bob : " << table.get("bob") << "\n";
    std::cout << "Value of key charlie : " << table.get("charlie") << "\n";

    return 0;
}