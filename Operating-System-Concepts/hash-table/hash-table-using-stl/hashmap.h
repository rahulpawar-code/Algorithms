// https://aozturk.medium.com/simple-hash-map-hash-table-implementation-in-c-931965904250

#ifndef HASHMAP_H
#define HASHMAP_H

#include "hashnode.h"

#include <array>
#include <vector>
#include <iostream>
#include <cstddef>

template<typename K, std::size_t size>
struct KeyHash
{
    unsigned long operator() (const K& key)
    {
        return reinterpret_cast<unsigned long>(key) % size;
    }
};

template<typename K, typename V, std::size_t size = 1024, typename F = KeyHash<K, size>>
class HashMap
{
private:
    std::array<std::vector<HashNode<K, V>>, size> table { };
    F hashFunc;

public:
    HashMap() = default;
    ~HashMap() = default;

    void put(const K& key, const V& value)
    {
        unsigned long hash = hashFunc(key);

        for (auto node : table[hash]) {
            if (node.getKey() == key) {
                // key already present in map. Simply overwrite value
                node.setValue(value);
                return;
            }
        }

        // Reached here means key is not present in map so simple insert new key-value pair
        HashNode<K, V> node(key, value);
        table[hash].push_back(node);
    }

    void remove(const K& key)
    {
        unsigned long hash = hashFunc(key);

        if (table[hash].size() == 1) {
            if (table[hash][0].getKey() == key) {
                table[hash].clear();
            }
        } else {
            for (auto it = table[hash].begin(); it != table[hash].end(); ++it) {
                if ((*it).getKey() == key) {
                    // if table has only one key-value pair then reset the vector
                    it = table[hash].erase(it);
                }
            }
        }
    }

    bool get(const K& key, V& value)
    {
        unsigned long hash = hashFunc(key);

        for (auto node : table[hash]) {
            if (node.getKey() == key) {
                value = node.getValue();
                return true;
            }
        }
        return false;
    }
};

#endif