import java.util.ArrayList;
import java.util.List;

public class MessageRoom {
    // 접속한 상담사(ClientHandler) 목록을 관리하는 리스트
    private List<ClientHandler> handlers = new ArrayList<>();

    // 상담사가 입장하면 목록에 추가
    public void join(ClientHandler handler) {
        handlers.add(handler);
        System.out.println("새로운 사용자가 입장했습니다.");
    }

    // 모두에게 메시지 방송 (Broadcast)
    public void broadcast(String message) {
        for (ClientHandler handler : handlers) {
            handler.sendMessage(message); // 각 상담사에게 메시지 전달 요청
        }
    }
}