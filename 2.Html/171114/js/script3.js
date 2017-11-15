// Date 객체 : 날짜와 시간을 처리하는 객체

        var d = new Date();

        document.write(d);
        document.write("<br>");
        document.write(d.getDate());
        document.write("<br>");
        document.write(d.getMonth()+1);
        document.write("<br>");

        //세이브파일을 위한 헤더파일을 만든다
        //파일입출력으로 읽어오기  

        //객체변수.getTime();
        //객체변수에 설정된 날짜 및시간까지의 경과시간을 밀리세컨드 단위로 반환한다.
        //단위 기준 날짜 : 1970년 1월 1일 0시 0분 0초(표준시)
        //밀리세컨드 단위 : 1/1000 (1000 = 1초)

        // var d = new Date();
        // document.write(d.getTime());

        var testDay = new Date();

        document.write(testDay.getFullYear());
        document.write("<br>");

//객체에 설정된 날짜나 시간을 변경하는 메소드들 (set으로 시작하는 메서드)
        // 객체변수.setYear(년도);
        // 객체변수.setMonth(월-1);
        // 객체변수.setDate(일);
        // 객체변수.setDay(요일);

        // 객체변수.setHours(시);
        // 객체변수.setMinutes(분);
        // 객체변수.setSecond(초);

        // 객체변수.setTime(경과시간을 ms단위로 설정한다.);
        // 기준날짜 및 시간으로부터 주어진 경과시간 만큼 경과한 날짜 및 시간으로 객체변수를 새로 설정한다.

        document.write(testDay+"<br>");
        testDay.setTime(1000);

//날짜 및 시간을 문자열 형태로 반환하는 메서드들
        // 객체변수.toGMTString();//그리니치표준시
        // 객체변수.toString();//표준시간으로 나타내고, 지역시간과의 차이도 나타낸다.


        var today = new Date();
        document.write(today.toGMTString());
        document.write("<br>");
        document.write(today.toLocaleString());
        document.write("<br>");
        document.write(today.toString());
