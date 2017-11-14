function Date(year, month, day, hour, minute, second) {
    //파라미터에서 받은 값을 저장
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.minute = minute;
    this.second = second;

    this.getDay = function () {
        return this.year + "년도" + this.month + "월" + this.day + "일";
    }
    this.setDay = function (newYear, newMonth, newDay) {
        this.year = newYear;
        this.month = newMonth;
        this.day = newDay;
    }
    this.getTime = function () {
        return this.hour + "시 " + this.minute + "분 " + this.second + "초";
    }
    this.setTime = function (newHour, newMinute, newSecond) {
        this.hour = newHour;
        this.minute = newMinute;
        this.second = newSecond;
    }
    this.toString = function () {
        return this.year + "년 " + this.month + "월 " + this.day + "일 " + this.hour + "시 " + this.minute + "분 " + this.second + "초 ";
    }
}

var temp = new Date(2000, 10, 10, 7, 5, 5);

// temp.setDay(1992,10,27);
// temp.setTime(10,9,28);
document.write(temp.toString());