// Intro to smart pointers - first draft
// https://www.learncpp.com/cpp-tutorial/intro-to-smart-pointers-move-semantics/

#include <iostream>

template <class T>
class AutoPtr
{
private:
    T* m_ptr;

public:
    // Own pointer to a resource
    AutoPtr(T* ptr = nullptr) : m_ptr (ptr) { }

    // Destroy the owned pointer
    ~AutoPtr()
    {
        if (m_ptr != nullptr) {
            delete m_ptr;
        }
    }

    // Overloaded operators
    T& operator*() const { return *m_ptr; }
    T* operator->() const { return m_ptr; }
};

// Resource class which has to be managed
class Resource
{
public:
    Resource() { std::cout << "Resource created\n"; }
    ~Resource() { std::cout << "Resource destroyed\n"; }
};

int main()
{
    AutoPtr<Resource> res (new Resource());

    return 0;
}