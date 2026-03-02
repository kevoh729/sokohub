#include <stdio.h>

int main() {
    const PI = 3.124;
    int radius = 7;

    float perimeter = 2*PI*radius;
    float area = PI*radius*radius;

    printf("Perimeter of the circle: %2f\n", perimeter);
    printf("Area of the circle: %2f\n", area);
    return 0;
}