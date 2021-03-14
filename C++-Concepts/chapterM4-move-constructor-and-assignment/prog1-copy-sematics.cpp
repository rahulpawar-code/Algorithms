// Move constructors and Move assignment - Copy semantics deep copy
// https://www.learncpp.com/cpp-tutorial/move-constructors-and-move-assignment/


#include <iostream>

template <class T>
class AutoPtr
{
private:
    T* m_ptr;

public:
    AutoPtr(T* ptr = nullptr) : m_ptr(ptr) { }

    ~AutoPtr()
    {
        if (m_ptr != nullptr) {
            delete m_ptr;
        }
    }

    // Copy contructor - deep copy
    AutoPtr(const AutoPtr& a)
    {
        m_ptr = new T;
        *m_ptr = *a.m_ptr;
    }

    // Copy assignment - deep copy
    AutoPtr& operator=(const AutoPtr& a)
    {
        if (&a == this) {
            return *this;
        }

        delete m_ptr;

        m_ptr = new T;
        *m_ptr = *a.m_ptr;

        return *this;
    }

    // Overloaded operator
    T& operator*() const { return *m_ptr; }
    T* operator->() const { return m_ptr; }
};

class Resource
{
public:
    Resource() { std::cout << "Resource created\n"; }
    ~Resource() { std::cout << "Resource destroyed\n"; }
};

AutoPtr<Resource> createResource()
{
    AutoPtr<Resource> res (new Resource());
    return res;                             // will invoke copy contructor
}

int main()
{
    AutoPtr<Resource> mainres;
    mainres = createResource();             // will invoke copy assignment

    return 0;
}