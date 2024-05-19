#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

double factorial(int n) {
	if (n == 0)
		return 1;
	return n * factorial(n - 1);
}

double combination(int n, int m) {
	return factorial(n) / (factorial(n - m)*factorial(m));
}

int main()
{
	int T, N, M;

	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d%d", &N, &M);
		printf("%.lf\n",combination(M, N));
	}

	return 0;
}