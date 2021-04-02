// Implement the RandomizedSet class
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/813/
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/813/discuss/85422/AC-C++-Solution.-Unordered_map-+-Vector

#include <iostream>
#include <unordered_map>
#include <vector>


class RandomizedSet {
private:
    std::unordered_map<int, int> map;
    std::vector<int> nums;

public:
    RandomizedSet() { }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val)
    {
        if (map.find(val) != map.end()) {
            return false;
        }
        nums.emplace_back(val);
        map[val] = nums.size() - 1;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val)
    {
        if (map.find(val) == map.end()) {
            return false;
        }
        int valIndex = map[val];
        int last = nums.back();
        int lastIndex = map[last];
        std::swap(nums[valIndex], nums[lastIndex]);
        nums.pop_back();
        map[last] = valIndex;
        map.erase(val);
        return true;
    }

    /** Get a random element from the set. */
    int getRandom()
    {
        return nums[rand() % nums.size()];
    }
};

int main()
{
    RandomizedSet* obj = new RandomizedSet();

    bool param_1 = obj->insert(12);
    std::cout << param_1 << "\n";
    param_1 = obj->insert(17);
    std::cout << param_1 << "\n";

    bool param_2 = obj->remove(17);
    std::cout << param_2 << "\n";

    int param_3 = obj->getRandom();
    std::cout << param_3 << "\n";

    return 0;
}
