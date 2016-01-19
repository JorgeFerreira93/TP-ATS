void main(){
	int a;
	a=input(int);
	if(even(a)) {
		print('e');
	}
	else {
		print('o');
	}
	
}

boolean even(int number){
	if(number % 2 == 0){
		return true;
	}
	else{
		return false;
	}
}
