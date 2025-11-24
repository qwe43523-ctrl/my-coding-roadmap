import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        // 1. 방송실 먼저 개설
        MessageRoom room = new MessageRoom();
        
        // 2. 서버 소켓 열기 (9999번 포트)
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("채팅 서버가 시작되었습니다...");

        // 3. 무한히 대기하며 손님 받기
        while (true) {
            Socket socket = serverSocket.accept(); // 손님 도착!
            
            // 4. 전담 상담사(Handler) 고용 및 방송실(Room) 알려주기
            ClientHandler handler = new ClientHandler(socket, room);
            room.join(handler); // 방송실 명단에 등록
            
            handler.start(); // 상담 시작! (스레드 실행)
        }
    }
}