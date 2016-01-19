void main(){
int num;
num=input(int);
if(isPrime(num)){
	print('Y');
}
else{
    print('N');
    }

}

boolean isPrime(int num){
    int i;
	int count;
	count=0;
	for(i=2;i<=num/2 && count==0;i++){
        if(num%i==0){
         count++;
        }
    }
   return (count==0 && num!= 1);
}