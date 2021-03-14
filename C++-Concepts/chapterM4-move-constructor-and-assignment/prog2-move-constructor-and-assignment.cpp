// Move constructor and move assignment
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

    // Copy constructor - deep copy
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

    // Move constuctor transfer ownership from a to this
    AutoPtr(AutoPtr&& a) : m_ptr(a.m_ptr)
    {
        a.m_ptr = nullptr;
    }

    // Move assignment trasnfer ownership
    AutoPtr& operator=(AutoPtr&& a) noexcept
    {
        if (&a == this) {
            return *this;
        }

        delete m_ptr;

        m_ptr = a.m_ptr;
        a.m_ptr = nullptr;

        return *this;
    }

    // Overloaded operators
    T& operator*() const { return *m_ptr; }
    T* operator->() const { return m_ptr; }
};


class Resource
{
public:
    Resource() { std::cout << "Resource acquired\n"; }
    ~Resource() { std::cout << "Resource destroyed\n"; }
};

AutoPtr<Resource> createResource()
{
    AutoPtr<Resource> ptr (new Resource());
    return ptr;
}

int main()
{
    AutoPtr<Resource> res;
    res = createResource();

    return 0;
}