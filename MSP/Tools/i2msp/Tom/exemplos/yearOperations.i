void main(){
	int year;
	int yr;
	year=input(int);
	print(year);
	if(isLeapYear(year)){
	print('y');
	}
	else print('n');
	yr=getLastTwoDigits(year);
	print(yr);
}

boolean isLeapYear(int year){
	if ((year % 400) == 0)
        return true
    else if ((year % 100) == 0)
		return false;
    else if ((year % 4) == 0)
        return true;
    else
        return false;
}

int getLastTwoDigits(int year){
	return year % 100;
}