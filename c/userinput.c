#include <stdio.h>

int main() {
    int num_a, num_b, sum;
    printf("\n enter first number\n");
    scanf("%d", & num_a);

    printf("\n enter second number\n");
    scanf("%d", & num_b);

    sum = num_a + num_b;
    printf("\n The sum is: %d\n", sum);

    return 0;
}