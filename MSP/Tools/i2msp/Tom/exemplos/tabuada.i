void main(){
int range;
int a;
range=input(int);
printTabuada(range);
}


void printTabuada(int r){
int i;
int j;
for(i=1;i<=r;i++){
      for(j=1;j<=10;j++){
           print(i);
		   print('*');
		   print(j);
		   print('=');
		   print(i*j);}
      print('\n');
	}
}