void main(){
int number;
number=input(int);
if(isPerfect(number)){
print('y');
}
else{
print('n');
}

}

boolean isPerfect(int number){
int rem;
int sum=0;
int i;
number = number-1;
for (i = 1; i <= number; i++){
        rem = number % i;
	if (rem == 0)
        {
            sum = sum + i;
        }
    }
    if(sum==number){
    	return true;
    }
    else{
    	return false;
    }
}