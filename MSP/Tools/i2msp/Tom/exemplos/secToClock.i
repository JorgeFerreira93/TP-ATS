void main(){
	int nSeconds;
	int realHours;
	int realMinutes;
	int realSeconds;
	nSeconds=input(int);
	realHours=getHours(nSeconds);
	realMinutes=getMinutes(nSeconds);
	realSeconds=getRealSeconds(nSeconds);
	print(nSeconds);
	print('=');
	print(realHours);
	print(':');
	print(realMinutes);
	print(':');
	print(realSeconds);
}

int getHours(int seconds) {
        return seconds / 3600;
}

int getMinutes(int seconds) {
        return (seconds - (getHours(seconds) * 3600)) / 60;
}

int getRealSeconds(int seconds) {
        return seconds - (getMinutes(seconds) * 60)-(getHours(seconds)*3600);
}