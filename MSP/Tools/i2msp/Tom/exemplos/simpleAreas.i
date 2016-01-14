void main(){
int height;
float resf;
int width;
int base1;
int base2;
int diagonal1;
int diagonal2;
height=input(int);
width=input(int);
base1=input(int);
base2=input(int);
diagonal1=input(int);
diagonal2=input(int);
resf=rectangleTriangleArea(height,width);
print(resf);
resf=trapeziumArea(base1,base2,height);
print(resf);
resf=diamondArea(diagonal1,diagonal2);
print(resf);
resf=paralelogramArea(width,height);
print(resf);
}
float rectangleTriangleArea(int height, int width){
return 0.5*height*width;
}

float trapeziumArea(int base1,int base2, int height){
return 0.5*(base1+base2)*height;
}

float diamondArea(int diagonal1,int diagonal2){
return 0.5*diagonal1*diagonal2;
}

float paralelogramArea(int width,int height){
return width*height;
}

