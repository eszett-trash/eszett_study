package thread;

public class ThreadTest20 {
public static void main(String[] args) {
	DataBox db = new DataBox();
	
	ProducerThread pth = new ProducerThread(db);
	ConsumerThread pth2 = new ConsumerThread(db);
	
	pth.start();
	pth2.start();
}
}

class DataBox {
	private String data;

	public synchronized String getData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String returnData = data;
		System.out.println("읽어온데이터 : " + data);
		data = null; // 데이터 사용 후 데이터를 비워줌
		notify();
		return returnData;
	}

	// 데이터를 공급하는 메서드

	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println("공급한 데이터 : " + data);
		notify();
	}
}

class ProducerThread extends Thread {
	private DataBox dataBox;

	public ProducerThread(DataBox dataBox) {
		super();
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			String data = "Data-" + i;
			dataBox.setData(data);
		}
	}
}

class ConsumerThread extends Thread{
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		super();
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			String data = dataBox.getData();
			System.out.println("반환값 : "+ data);
		}
	}
}