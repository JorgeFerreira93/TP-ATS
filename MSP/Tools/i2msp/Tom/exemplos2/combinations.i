void main() {
int n;
int r;
float res;
n=input(int);
r=input(int);
res=nCr(n,r);
print(res);
}

float nCr(int n,int r){
    return (fact(n))/(fact(r)*fact(n-r));
}

int fact(int z){
    int f = 1, i;
    if (z == 0)
    {
        return(f);
    }
    else
    {
        for (i = 1; i <= z; i++)
	{
            f = f * i;
	}
    }
    return(f);
}