
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Process process = null;
        RoundRobin roundRobin = new RoundRobin();

        while (true) {
            int type = scanner.nextInt();
            if (type == -1) {
                // 입력 종료
                System.out.println("입력 종료.");
                break;
            } else if (type == 0) {
                int process_id = scanner.nextInt();
                int priority = scanner.nextInt();
                int computing_time = scanner.nextInt();
                // 큐에 프레스 추가
                process = new Process(process_id, priority, computing_time);
                roundRobin.add(process);
            } else if (type == 1) {
                // 큐에 있는 프로세스 실행
                roundRobin.example();
            }
        }
    }
}
