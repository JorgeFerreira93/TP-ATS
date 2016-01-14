void main(){
int n;
int r;
float res;
n=input(int);
r=input(int);
res=nPr(n,r);
print(res);
}

float nPr(int n,int r){
	return fact(n) / fact(n - r);
}

int fact(int x){
   if (x <= 1)
       return 1;
   return x * fact(x - 1);
}