void main(){
float meters;
float feet;
float km;
float miles;

meters=input(float);
feet=metersToFeet(meters);
print(feet);
feet=input(float);
meters=feetToMeters(feet);
print(meters);
km=input(float);
miles=kmToMiles(km);
print(miles);
miles=input(float);
km=milesToKm(miles);
print(km);

}

float metersToFeet(float meters){
	return meters*1.0936;
}

float feetToMeters(float feet){
	return feet/1.0936;
}

float kmToMiles(float km){
	return km*0.62137;
}

float milesToKm(float miles){
	return miles/0.62137;
}
