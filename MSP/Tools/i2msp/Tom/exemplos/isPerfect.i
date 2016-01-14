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
for (i = 1; i <= (number - 1); i++){
        rem = number % i;
	if (rem == 0)
        {
            sum = sum + i;
        }
    }
    return sum==number;
}