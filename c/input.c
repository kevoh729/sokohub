#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int a, b;
	scanf("%d %d", &a, &b);
    printf("\n%d %d\n", a + b, a - b);

    float d, e;
    scanf("%f %f", &d, &e);
    printf("\n%.1f %1f\n", d + e, d - e);
    
    return 0;
}