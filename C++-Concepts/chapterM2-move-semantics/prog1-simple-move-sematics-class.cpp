// Move semantics - constructors with move semantics
// https://www.learncpp.com/cpp-tutorial/intro-to-smart-pointers-move-semantics/

#include <iostream>

template <class T>
class AutoPtr
{
private:
    T* m_ptr;

public:
    AutoPtr(T* ptr = nullptr) : m_ptr (ptr) { }

    ~AutoPtr()
    {
        if (m_ptr != nullptr) {
            delete m_ptr;
        }
    }

    // Copy constructor implementing move semantics
    AutoPtr(AutoPtr& a)
    {
        m_ptr = a.m_ptr;  // Transfer m_ptr from source to destination
        a.m_ptr = nullptr; // nullify source after transfer
    }

    // Assignment operator implementing move semantics
    AutoPtr& operator=(AutoPtr& a)
    {
        if (&a == this) {
            return *this;
        }

        delete m_ptr;
        m_ptr = a.m_ptr;
        a.m_ptr = nullptr;
        return *this;
    }

    T& operator*() const { return *m_ptr; }
    T* operator->() const { return m_ptr; }

    bool isNull() { return m_ptr == nullptr; }
};

class Resource
{
public:
    Resource() { std::cout << "Resource object created\n"; }
    ~Resource() { std::cout << "Resource object destroyed\n"; }
};

int main()
{
    AutoPtr<Resource> res1 (new Resource());
    AutoPtr<Resource> res2;

    std::cout << "res1 is null ? " << std::boolalpha << res1.isNull() << "\n";
    std::cout << "res2 is null ? " << std::boolalpha << res2.isNull() << "\n";

    std::cout << "Transfering ownership from res1 to res2\n";
    res2 = res1;

    std::cout << "res1 is null ? " << std::boolalpha << res1.isNull() << "\n";
    std::cout << "res2 is null ? " << std::boolalpha << res2.isNull() << "\n";

    std::cout << "======================================\n";

    AutoPtr<Resource> res3 (new Resource());
    std::cout << "res3 is null ? " << std::boolalpha << res3.isNull() << "\n";

    std::cout << "Transfering ownership from res3 to res4\n";
    AutoPtr<Resource> res4 (res3);

    std::cout << "res3 is null ? " << std::boolalpha << res3.isNull() << "\n";
    std::cout << "res4 is null ? " << std::boolalpha << res4.isNull() << "\n";

    std::cout << "======================================\n";

    return 0;
}