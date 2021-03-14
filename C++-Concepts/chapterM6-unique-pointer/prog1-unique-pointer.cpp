// Unique pointer
// https://www.learncpp.com/cpp-tutorial/stdunique_ptr/
// https://en.cppreference.com/w/cpp/memory/unique_ptr

#include <iostream>
#include <memory>

class Resource
{
public:
    Resource() { std::cout << "Resource acquired\n"; }
    ~Resource() { std::cout << "Resource released\n"; }

    void foo() { std::cout << "Resource called foo()\n"; }

    friend std::ostream& operator<<(std::ostream& out, const Resource& res)
    {
        out << "This is Resource";
        return out;
    }
};

int main()
{
    std::unique_ptr<Resource> res1(new Resource());
    std::unique_ptr<Resource> res2 { };

    std::cout << "===============\n";
    std::cout << "res1 is " << (static_cast<bool>(res1) ? "not null\n" : "null\n");
    std::cout << "res2 is " << (static_cast<bool>(res2) ? "not null\n" : "null\n");

    res2 = std::move(res1);
    std::cout << "===============\n";
    std::cout << "After moving ownership\n";
    std::cout << "res1 is " << (static_cast<bool>(res1) ? "not null\n" : "null\n");
    std::cout << "res2 is " << (static_cast<bool>(res2) ? "not null\n" : "null\n");

    std::cout << "===============\n";
    res2->foo();
    std::cout << *res2 << "\n";

    std::cout << "===============\n";
    return 0;
}
