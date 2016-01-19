void main(){
int limit;
int pos;
int value;
limit=input(int);
printFibonacci(limit);
pos=input(int);
print(pos);
print(' ');
value=fibo(pos);
print(value);
}

void printFibonacci(int limit){
	int fib1;
	int fib2;
	int fib3;
	int count;
	fib1=0;
	fib2=1;
	print(fib1);
	print(' ');
	print(fib2);
	print(' ');
	count = 2;
    while (count < limit){
        fib3 = fib1 + fib2;
        count = count + 1;
        print(fib3);
		print(' ');
        fib1 = fib2;
        fib2 = fib3;
    }
}

int fibo(int num){
    if (num == 0)
    {
        return 0;
    }
    else if (num == 1)
    {
        return 1;
    }
    else
    {
        return fibo(num - 1) + fibo(num - 2);
    }
}