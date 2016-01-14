void main(){
	int bin, dec;
	bin=input(int);
	dec=binToDec(bin);
	print(bin);
	print(' ');
	print(dec);
	
}

int binToDec(int bin){
	int decimal_val;
	int num;
	num=bin;
	int base;
	int rem;
	decimal_val=0;
	base=1;
	while (num > 0){
        rem = num % 10;
        decimal_val = decimal_val + rem * base;
        num = num / 10 ;
        base = base * 2;
    }
	return decimal_val;
}