
import java.util.*;

class RoundRobin {
    private static final int TIME_QUANTUM = 20;         // time quantum
    private static final int PLUS_PRIORITY = 10;        // priority 증가량
//    private static final int QUEUES = 5;                // 큐의 갯수

    int time = 0;

    // 큐 생성
    private ArrayList<Process> realtime = new ArrayList<>();
    private ArrayList<Process> Q1 = new ArrayList<>();
    private ArrayList<Process> Q2 = new ArrayList<>();
    private ArrayList<Process> Q3 = new ArrayList<>();
    private ArrayList<Process> Q4 = new ArrayList<>();

    // 프로세스를 ArrayList에 저장
    private void add(ArrayList<Process> arrayList, Process process) {
        arrayList.add(process);
    }
    
    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        if (process.getPriority() < 0)               // priority가 -10 이상 0 미만인 경우
            add(realtime, process);
        else if (process.getPriority() <= 10)        // priority가 1 이상 10 이하인 경우
            add(Q1, process);
        else if (process.getPriority() <= 20)        // priority가 11 이상 20 이하인 경우
            add(Q2, process);
        else if (process.getPriority() <= 30)        // priority가 21 이상 30 이하인 경우
            add(Q3, process);
        else                                    // priority가 31 인 경우
            add(Q4, process);
    }

    void rrRun() {
        
    }

    void exRRRun() {
        Collections.sort(realtime, new SortArrayList());
        Collections.sort(Q1, new SortArrayList());
        Collections.sort(Q2, new SortArrayList());
        Collections.sort(Q3, new SortArrayList());
        Collections.sort(Q4, new SortArrayList());

        int time = 0;

        while (!realtime.isEmpty()) {
            System.out.println(
                "process_id: " + realtime.get(0).getProcess_id() +
                " priority: " + realtime.get(0).getPriority() +
                " computing_time: " + realtime.get(0).getComputing_time() +
                " turn_around_time: " + realtime.get(0).getTurn_around_time()
            );

            realtime.remove(0);
        }
        realtime.clear();

        while (!Q1.isEmpty()) {
            System.out.println(
                "process_id: " + Q1.get(0).getProcess_id() +
                " priority: " + Q1.get(0).getPriority() +
                " computing_time: " + Q1.get(0).getComputing_time() +
                " turn_around_time: " + Q1.get(0).getTurn_around_time()
            );

            Q1.remove(0);
        }
        Q1.clear();

        while (!Q2.isEmpty()) {
            System.out.println(
                "process_id: " + Q2.get(0).getProcess_id() +
                " priority: " + Q2.get(0).getPriority() +
                " computing_time: " + Q2.get(0).getComputing_time() +
                " turn_around_time: " + Q2.get(0).getTurn_around_time()
            );

            Q2.remove(0);
        }
        Q2.clear();

        while (!Q3.isEmpty()) {
            System.out.println(
                "process_id: " + Q3.get(0).getProcess_id() +
                " priority: " + Q3.get(0).getPriority() +
                " computing_time: " + Q3.get(0).getComputing_time() +
                " turn_around_time: " + Q3.get(0).getTurn_around_time()
            );

            Q3.remove(0);
        }
        Q3.clear();

        while (!Q4.isEmpty()) {
            System.out.println(
                "process_id: " + Q4.get(0).getProcess_id() +
                " priority: " + Q4.get(0).getPriority() +
                " computing_time: " + Q4.get(0).getComputing_time() +
                " turn_around_time: " + Q4.get(0).getTurn_around_time()
            );

            Q4.remove(0);
        }
        Q4.clear();
    }
}
