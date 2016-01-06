void main() {
    int a;
    int res;
    a = input(int);
    res = reverse(a);
	if(a==res){
		print('s');
	}
	else{
		print('n');
	}
}

int reverse(int temp){
	int reverse;
	reverse=0;

	while( temp != 0 ){
		reverse = reverse * 10;
		reverse = reverse + temp%10;
		temp = temp/10;
	}
	
	return reverse;
}
