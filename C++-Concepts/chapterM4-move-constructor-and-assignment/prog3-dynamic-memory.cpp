// Move constructor and move assignment - dynamic memory with copy and move semantics
// https://www.learncpp.com/cpp-tutorial/move-constructors-and-move-assignment/

#include <iostream>
#include <chrono>

template <class T>
class DynamicArrayCopySemantics
{
private:
    T* m_array;
    int m_length;

public:
    DynamicArrayCopySemantics(int length) : m_array(new T[length]), m_length(length) { }

    ~DynamicArrayCopySemantics()
    {
        delete[] m_array;
    }

    // Copy constructor - deep copy
    DynamicArrayCopySemantics(const DynamicArrayCopySemantics& arr): m_length(arr.m_length)
    {
        m_array = new T[m_length];
        for (int i = 0; i < m_length; ++i) {
            m_array[i] = arr.m_array[i];
        }
    }

    // Copy assignment
    DynamicArrayCopySemantics& operator=(const DynamicArrayCopySemantics& arr)
    {
        if (&arr == this) {
            return *this;
        }

        delete[] m_array;

        m_length = arr.m_length;
        m_array = new T[m_length];
        for (int i = 0; i < m_length; ++i) {
            m_array[i] = arr.m_array[i];
        }

        return *this;
    }

    int getLength() const { return m_length; }
    T& operator[](int index) { return m_array[index]; }
    const T& operator[](int index) const { return m_array[index]; }
};


template <class T>
class DynamicArrayMoveSemantics
{
private:
    T* m_array;
    int m_length;

public:
    DynamicArrayMoveSemantics(int length) : m_array(new T[length]), m_length(length) { }

    ~DynamicArrayMoveSemantics()
    {
        delete[] m_array;
    }

    // Copy constructor
    DynamicArrayMoveSemantics(const DynamicArrayMoveSemantics& arr) = delete;

    // Copy assignment
    DynamicArrayMoveSemantics& operator=(const DynamicArrayMoveSemantics& arr) = delete;

    // Move constuctor
    DynamicArrayMoveSemantics(DynamicArrayMoveSemantics&& arr) noexcept :
        m_length(arr.m_length), m_array(arr.m_array)
    {
        arr.m_length = 0;
        arr.m_array = nullptr;
    }

    // Move assignment
    DynamicArrayMoveSemantics& operator=(DynamicArrayMoveSemantics&& arr) noexcept
    {
        if (&arr == this) {
            return *this;
        }

        delete[] m_array;

        m_length = arr.m_length;
        m_array = arr.m_array;
        arr.m_length = 0;
        arr.m_array = nullptr;

        return *this;
    }

    int getLength() const { return m_length; }
    T& operator[](int index) { return m_array[index]; }
    const T& operator[](int index) const { return m_array[index]; }
};

DynamicArrayCopySemantics<int> cloneArrayAndDoubleCS(const DynamicArrayCopySemantics<int>& arr)
{
    DynamicArrayCopySemantics<int> dbl(arr.getLength());
    for (int i = 0; i < arr.getLength(); ++i) {
        dbl[i] = arr[i] * 2;
    }

    return dbl;
}

DynamicArrayMoveSemantics<int> cloneArrayAndDoubleMS(const DynamicArrayMoveSemantics<int>& arr)
{
    DynamicArrayMoveSemantics<int> dbl(arr.getLength());
    for (int i = 0; i < arr.getLength(); ++i) {
        dbl[i] = arr[i] * 2;
    }

    return dbl;
}


class Timer
{
private:
    using clock_t = std::chrono::high_resolution_clock;
    using second_t = std::chrono::duration<double, std::ratio<1>>;
    std::chrono::time_point<clock_t> m_beg;

public:
    Timer() : m_beg(clock_t::now()) { }

    void reset()
    {
        m_beg = clock_t::now();
    }

    double elapsed() const
    {
        return std::chrono::duration_cast<second_t>(clock_t::now() - m_beg).count();
    }
};

int main()
{
    Timer t;

    const int size = 1000000;
    DynamicArrayCopySemantics<int> arrcs(size);

    for (int i = 0; i < size; ++i) {
        arrcs[i] = i;
    }

    arrcs = cloneArrayAndDoubleCS(arrcs);
    std::cout << "Time taken using copy semantics: " << t.elapsed() << "\n";

    t.reset();
    DynamicArrayMoveSemantics<int> arrms(size);
    for (int i = 0; i < size; ++i) {
        arrms[i] = i;
    }

    arrms = cloneArrayAndDoubleMS(arrms);
    std::cout << "Time taken using move semantics: " << t.elapsed() << "\n";

    return 0;
}