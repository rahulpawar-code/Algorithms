// Techie Delight https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
// Naive, Union-Find, Path compression

#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

class DisjointSetNaive
{
private:
    std::unordered_map<std::string, std::string> parent;

public:
    void makeSet(std::vector<std::string> const &objects)
    {
        for (auto object : objects) {
            parent[object] = object;
        }
    }

    std::string find(const std::string& item)
    {
        while (parent[item] == item) {
            return item;
        }
        return find(parent[item]);
    }

    void merge(const std::string& itemA, const std::string& itemB) {
        std::string parentA = find(itemA);
        std::string parentB = find(itemB);
        parent[parentA] = parentB;
    }

    void printSet()
    {
        for (auto& pair : parent) {
            std::cout << pair.first << " : " << pair.second << "\n";
        }
        std::cout << "=================================\n";
    }
};

// Path compression and union by rank
class DisjointSetImproved
{
private:
    std::unordered_map<std::string, std::string> parent;
    std::unordered_map<std::string, int> rank;

public:
    void makeSet(std::vector<std::string> const &objects)
    {
        for (auto object : objects) {
            parent[object] = object;
            rank[object] = 0;
        }
    }

    std::string find(const std::string& item)
    {
        while (parent[item] != item) {
            parent[item] = parent[parent[item]];
        }
        return parent[item];
    }

    void merge(const std::string& itemA, const std::string& itemB) {
        std::string parentA = find(itemA);
        std::string parentB = find(itemB);
        int rankA = rank[itemA];
        int rankB = rank[itemB];

        if (parentA == parentB) {
            return;
        }

        if (rankA > rankB) {
            parent[parentB] = parentA;
        } else if (rankA < rankB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }

    void printSet()
    {
        for (auto& pair : parent) {
            std::cout << pair.first << " : " << pair.second << " : " << rank[pair.first] << "\n";
        }
        std::cout << "=================================\n";
    }
};

int main()
{
    std::vector<std::string> names {"Alice", "Bob", "Charlie", "Dave", "Eve",
                                    "Frank", "Grace", "Heidi", "Ivan", "Judy"};

    DisjointSetNaive setn;
    setn.makeSet(names);
    setn.merge("Alice", "Bob");
    setn.merge("Eve", "Charlie");
    setn.merge("Dave", "Alice");
    setn.merge("Grace", "Ivan");
    setn.printSet();

    DisjointSetImproved seti;
    seti.makeSet(names);
    seti.merge("Alice", "Bob");
    seti.merge("Eve", "Charlie");
    seti.merge("Dave", "Alice");
    seti.merge("Grace", "Ivan");
    seti.printSet();

    return 0;
}