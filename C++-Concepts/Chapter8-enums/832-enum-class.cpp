// enum classes https://www.learncpp.com/cpp-tutorial/enum-classes/

#include <iostream>

#include <iostream>

int main()
{
    enum class Color
    {
        color_red,
        color_blue
    };

    Color color { Color::color_blue };

    std::cout << static_cast<int>(color) << "\n";

    return 0;
}