void main(){
	int nDays;
	int years;
	int months;
	int days;
	nDays=input(int);
	years=daysToYears(nDays);
	months=daysToMonths(nDays);
	days=totalDaysToDays(nDays);
	print(nDays);
	print('=');
	print(years);
	print('\\');
	print(months);
	print('\\');
	print(days);
}

int daysToYears(int nDays){
	return nDays/ 365;
}

int daysToMonths(int nDays){
	return ndays % 365 / 7;
}

int totalDaysToDays(int nDays){
	return ndays % 365 % 7;
}