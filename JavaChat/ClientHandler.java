import java.io.PrintWriter;
import java.net.Socket;

// Thread를 상속받아 독립적으로 일할 수 있게 함
public class ClientHandler extends Thread {
    private Socket socket;
    private MessageRoom room;
    private PrintWriter writer;

    public ClientHandler(Socket socket, MessageRoom room) {
        this.socket = socket;
        this.room = room;
    }

    // 메시지를 받아서 실제 클라이언트에게 쏘는 기능
    public void sendMessage(String msg) {
        if (writer != null) {
            writer.println(msg);
        }
    }

    @Override
    public void run() {
        // 여기에 실제 통신 로직이 들어갑니다.
        // 1. 스트림 연결 (Input/Output)
        // 2. while 문으로 계속 메시지 듣기
        // 3. 들은 메시지를 room.broadcast()로 전달하기
        // (이 부분은 일단 구조만 잡고 나중에 채웁니다)
    }
}