void main(){
int lower;
int upper;
int naoUsada;
lower=input(int);
upper=input(int);
printArmstrongNumbers(lower, upper);
}


void printArmstrongNumbers(int min,int max){
int temp;
int num;
int r;
int sum;
int naoSmellUsada;
for(num=min;num<=max;num++){
         temp=num;
         sum = 0;

         while(temp!=0){
             r=temp%10;
             temp=temp/10;
             sum=sum+r*r*r;
         }
         if(sum==num){
             print(num);
			 print(' ');
			 }
    }
}
