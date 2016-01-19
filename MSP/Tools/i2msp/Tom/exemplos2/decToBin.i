void main(){
	int dec;
	int bin;
	int countOnes;
	dec=input(int);
	bin=decToBin(dec);
	print(dec);
	print(' ');
	print(bin);
}

int decToBin(int dec){
	int num;
	num = dec;
	int binary_number;
	int base;
	int remainder;
	binary_number=0;
	base=1;
	 while (num > 0)
    {
        remainder = num % 2;
        
        binary_number = binary_number + remainder * base;
        num = num / 2;
        base = base * 10;
    }
	return binary_number;
}

