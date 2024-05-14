
import java.util.*;

public class RoundRobin {
    private static final int time_quantum = 20;         // time quantum
//    private static final int QUEUES = 5;                // 큐의 갯수

    // 큐 생성
    ArrayList<Process> realtime = new ArrayList<>();
    ArrayList<Process> Q1 = new ArrayList<>();
    ArrayList<Process> Q2 = new ArrayList<>();
    ArrayList<Process> Q3 = new ArrayList<>();
    ArrayList<Process> Q4 = new ArrayList<>();

    // 프로세스를 ArrayList에 저장
    void add(ArrayList<Process> arrayList, Process process) {
        arrayList.add(process);
    }
    
    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        if (process.priority < 0)               // priority가 -10 이상 0 미만인 경우
            add(realtime, process);
        else if (process.priority <= 10)        // priority가 1 이상 10 이하인 경우
            add(Q1, process);
        else if (process.priority <= 20)        // priority가 11 이상 20 이하인 경우
            add(Q2, process);
        else if (process.priority <= 30)        // priority가 21 이상 30 이하인 경우
            add(Q3, process);
        else                                    // priority가 31 인 경우
            add(Q4, process);
    }

    void rrRun() {
        for (Process process : realtime) {
            System.out.println(
                "process_id: " + process.process_id +
                " priority: " + process.priority +
                " computing_time: " + process.computing_time +
                " turn_around_time: " + process.turn_around_time
            );
        }
        realtime.clear();

        for (Process process : Q1) {
            System.out.println(
                "process_id: " + process.process_id +
                " priority: " + process.priority +
                " computing_time: " + process.computing_time +
                " turn_around_time: " + process.turn_around_time
            );
        }
        Q1.clear();
    }
}
