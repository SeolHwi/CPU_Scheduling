
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Process process = null;
        RoundRobin roundRobin = new RoundRobin();

        System.out.println("실행 시 1 0 0 0 입력 / 종료 시 -1 입력");
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

                if (priority > 30)              // priority가 30을 초과한 경우 31로 고정
                    priority = 31;
                else if (priority < -10) {      // priority가 -10 미만인 경우 메세지 출력 후 큐에 넣지 않음
                    System.out.println("priroty 값은 -10 미만으로 설정할 수 없습니다.");
                    continue;
                }

                // 큐에 프로세스 추가
                process = new Process(process_id, priority, computing_time);
                roundRobin.add(process);
            } else if (type == 1) {
                scanner.nextInt();              // 0 입력
                scanner.nextInt();              // 0 입력
                scanner.nextInt();              // 0 입력
                // 큐에 있는 프로세스 실행
                roundRobin.example();
            }
        }
    }
}
