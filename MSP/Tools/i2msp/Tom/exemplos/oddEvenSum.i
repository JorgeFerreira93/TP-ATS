void main(){
	int tecto;
	int somaPares;
	int somaImpares;
	tecto=input(int);
	somaPares=sumEven(tecto);
	somaImpares=sumOdd(tecto);
	
	print(tecto);
	print(' ');
	print(somaPares);
	print(' ');
	print(somaImpares);
}

int sumEven(int maxVal){
	int evenSum;
	int i;
	evenSum=0;
	for(i=1;i<=maxVal;i++){
		if(i%2==0) {evenSum++};
	}
	return evenSum;
}

int sumOdd(int maxVal){
	int oddSum;
	int i;
	oddSum=0;
	for(i=1;i<=maxVal;i++){
		if(i%2!=0) {oddSum++};
	}
	return oddSum;
}