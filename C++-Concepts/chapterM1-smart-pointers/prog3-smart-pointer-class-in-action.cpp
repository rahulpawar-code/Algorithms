// Intro to smart pointers - smart pointer class in action
// https://www.learncpp.com/cpp-tutorial/intro-to-smart-pointers-move-semantics/

#include <iostream>

template <class T>
class AutoPtr
{
private:
    T* m_ptr;

public:
    AutoPtr(T* ptr = nullptr) : m_ptr(ptr) {}

    ~AutoPtr()
    {
        if (m_ptr != nullptr) {
            delete m_ptr;
        }
    }

    T& operator*() const { return *m_ptr; }
    T* operator->() const { return m_ptr; }
};


class Resource
{
public:
    Resource() { std::cout << "Resource object created\n"; }
    ~Resource() { std::cout << "Resource object destroyed\n"; }
    void sayHi() { std::cout << "Resource object says hiiii!\n"; }
};

void foo(const int x)
{
    AutoPtr<Resource> ptr (new Resource());

    if (x == 0) {
        return;
    }

    ptr->sayHi();
}

int main()
{
    std::cout << "======================================\n";
    foo(1);
    std::cout << "======================================\n";
    foo(0);
    std::cout << "======================================\n";
    return 0;
}
