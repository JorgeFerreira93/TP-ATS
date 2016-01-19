void main(){
int num;
num=input(int);
if(isStrong(num)){
	print('Y');
}
else{print('N');}
}

boolean isStrong(int num){
  int temp;
  int r;
  int f;
  int i;
  temp=num;
  while(temp){
      i=1,f=1;
      r=num%10;

      while(i<=r){
         f=f*i;
        i++;
      }
      sum=sum+f;
      temp=temp/10;
  }
  return num==sum;
}