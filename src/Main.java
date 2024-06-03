import java.util.*;

public class Main {
    private static final int MAX_PRIORITY = 31;         // priority 최대값
    private static final int MIN_PRIORITY = -10;         // priority 최솟값

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobin roundRobin = new RoundRobin();

        System.out.println("실행 시 1 0 0 0 입력 / 종료 시 -1 입력");
        while (true) {
            int type = scanner.nextInt();
            if (type == -1) {                   // 입력 종료
                System.out.println("입력 종료.");
                while (!roundRobin.allQueuesEmpty()) {      // 모든 큐가 빌 때까지 반복 실행
                    roundRobin.rrRun();
                }
                break;
            }
            else if (type == 0) {
                int process_id = scanner.nextInt();
                int priority = scanner.nextInt();
                int computing_time = scanner.nextInt();

                if (priority > MAX_PRIORITY)              // priority가 30을 초과한 경우 31로 고정
                    priority = MAX_PRIORITY;
                else if (priority < MIN_PRIORITY) {      // priority가 -10 미만인 경우 메세지 출력 후 큐에 넣지 않음
                    System.out.println("priority 값은 -10 미만으로 설정할 수 없습니다.");
                    continue;                   // 잘못 입력된 값 무시 후 계속하여 입력
                }
                else if (priority == 0) {
                    System.out.println("priority 값은 0 으로 설정할 수 없습니다.");
                    continue;
                }

                // 큐에 프로세스 삽입
                Process process = new Process(process_id, priority, computing_time);
                roundRobin.classification(process); // classification 호출 추가
            }
            else if (type == 1) {
                scanner.nextInt();              // 0 입력
                scanner.nextInt();              // 0 입력
                scanner.nextInt();              // 0 입력
                // 큐에 있는 프로세스 실행
                roundRobin.rrRun();
            }
        }
    }
}
