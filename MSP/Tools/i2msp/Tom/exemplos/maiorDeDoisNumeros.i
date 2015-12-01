void main() {
    int a;
    int b;
    int res;
    a = input(int);
    b = input(int);
    res = max(a,b);
    print(';');
    print(res);
}

int max(int a, int b){
    int res;
    if (a > b) {
        res = a;
    }
    else {
        res = b;
    }
    return res; 
}
