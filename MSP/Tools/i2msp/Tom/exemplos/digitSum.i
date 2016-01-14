void main(){
	int number;
	int digitSum;
	number=input(int);
	digitSum=digitSum(number);
	print(number);
	print(' ');
	print(digitSum);
}

void digitSum(int number){
	temp = num;
    while (temp > 0)
    {
        digit = temp % 10;
        temp  = temp + digit;
        temp = temp/10;
    }
	return temp;
}