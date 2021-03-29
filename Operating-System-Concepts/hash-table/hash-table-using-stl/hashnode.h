// https://aozturk.medium.com/simple-hash-map-hash-table-implementation-in-c-931965904250

#ifndef HASHNODE_H
#define HASHNODE_H

template <typename K, typename V>
class HashNode
{
private:
    K key;
    V value;

public:
    HashNode(const K& k, const V& v) : key(k), value(v) { }

    K getKey() const { return key; }

    V getValue() const { return value; }

    void setValue(V value) { HashNode::value = value; }

    void setKey(K key) { HashNode::key = key; }
};

#endif