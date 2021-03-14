// Intro to smart pointers - memory leak
// https://www.learncpp.com/cpp-tutorial/intro-to-smart-pointers-move-semantics/


// To check memory leak - run valgrind on a.out file


#include <iostream>

class Resource
{
public:
    Resource() {
        std::cout << "Resource object created\n";
    }

    ~Resource() {
        std::cout << "Resource object destroyed\n";
    }
};

void foo(const int x)
{
    Resource* ptr = new Resource();

    if (x <= 1) {
        return;                     // early return from foo(), ptr won't be delete
    }

    delete ptr;
}


void bar(const int y)
{
    Resource* ptr = new Resource();

    if (y == 0) {
        throw 0;                    // early return from foo(), ptr won't be delete
    }

    delete ptr;
}

int main()
{
    foo(1);
    bar(0);

    return 0;
}