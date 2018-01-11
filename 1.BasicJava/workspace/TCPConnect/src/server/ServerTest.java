package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerTest {
	public static void main(String[] args) throws IOException {

		// 1. 서버 소켓을 생성한다 => 열어놓을 포트번호 필요(특정한 포트 외에는 아무렇게 지정 가능)
		ServerSocket server = new ServerSocket(5555);

		// 2. 서버소켓이 클라이언트의 연결을 기다림
		System.out.println("클라이언트 연결을 기다림..");
		while (true) {
			Socket sock = server.accept();
			/*
			 * 클라이언트가 접속해오기를 기다리고 있다가 클라이언트가 접속해오면 클라이언트와 연결된 소켓 객체를 반환한다.
			 */
			System.out.println("클라이언트가 접속했어요!!");
			InetAddress inet = sock.getInetAddress();
			System.out.println("클라이언트의 IP: " + inet.getHostAddress());

			int num = new Random().nextInt(100) + 0; // 0부터 99까지 랜덤하게 발생

			// 서버가 클라이언트에게 숫자 데이터를 보낸다.
			// 출력스트림 활용
			OutputStream os = sock.getOutputStream();

			// 자바의 다양한 데이터(자료형)를 보내는 DataOutputStream 활용
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeInt(num);
			dos.flush();

			// 클라이언트가 보내는 메시지를 듣고 콘솔에 출력하자
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println("From Client>>>" + dis.readUTF());

			// 원래는 null 체크하고 종료하면 좋음
			dos.close();
			dis.close();
			os.close();
			is.close();
			if (sock != null)
				sock.close();
		}
	}
}
