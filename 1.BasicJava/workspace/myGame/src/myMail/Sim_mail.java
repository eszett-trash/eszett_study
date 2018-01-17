package myMail;

import org.apache.commons.mail.SimpleEmail;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;

public class Sim_mail {
	private void simmail() {
	    SimpleEmail email = new SimpleEmail();
	    email.setCharset("euc-kr");    email.setHostName("mail.somehost.com");  // SMTP 서버를 지정
	    email.addTo("madvirus@empal.com", "최범균"); // 수신자를 추가
	    email.setFrom("madvirus@madvirus.net", "범균"); // 보내는 사람 지정
	    email.setSubject("텍스트 테스트 메일입니다."); // 메일 제목
	    MimeMultipart msg = new MimeMultipart("mixed");
	    email.setContent(msg);
	    email.send(); // 메일 발송

	}
	public static void main(String[] args) {

	}
}
