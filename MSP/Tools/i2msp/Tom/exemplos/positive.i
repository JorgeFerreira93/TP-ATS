void main(){
	int num;
	num=input(int);
	if(positive(num)) {print('p');}
	else {print('n');}

}

boolean positive(int num){
	if(num>=0){return true;}
	else{return false;}

}