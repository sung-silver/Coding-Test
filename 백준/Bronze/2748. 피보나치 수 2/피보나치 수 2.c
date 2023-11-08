#include<stdio.h>

int main() {
	long long int a, b, c;
	int n;
	
	scanf("%d", &n);
	
	if (n <= 1) {
		printf("%d", 1);
	}
	else {
		a = 0, b = 1;
		for (int i = 0; i < n - 1; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		printf("%lld\n", c);
	}

	return 0;
}