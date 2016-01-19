void main(){
int num;
int pow;
int res;
num=input(int);
pow=input(int);
res=power(num,pow);
print(res);
}


int power (int num, int pow)
{
    if (pow>0)
    {
        return num * power(num, pow - 1);
    }
    else{
    	return 1;
    	}
}