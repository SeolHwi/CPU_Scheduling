
import java.util.*;

public class RoundRobin {
    private static final int time_quantum = 20;
    private static final int QUEUES = 5;

    ArrayList<Process> processes = new ArrayList<>();

    ArrayList<Process> realtime = new ArrayList<>();
    ArrayList<Process> Q1 = new ArrayList<>();
    ArrayList<Process> Q2 = new ArrayList<>();
    ArrayList<Process> Q3 = new ArrayList<>();
    ArrayList<Process> Q4 = new ArrayList<>();

    void add(ArrayList<Process> arrayList, Process process) {
        arrayList.add(process);
    }

    void rrRun() {
        for (Process process : processes) {
            if (process.priority < 0)
                add(realtime, process);
            else if (process.priority < 10)
                add(Q1, process);
            else if (process.priority < 20)
                add(Q2, process);
            else if (process.priority < 30)
                add(Q3, process);
            else
                add(Q4, process);
        }
        processes.clear();

        for (Process process : realtime) {
            System.out.println(
                "process_id: " + process.process_id +
                " queue_id: " + process.queue_id +
                " priority: " + process.priority +
                " computing_time: " + process.computing_time +
                " turn_around_time: " + process.turn_around_time
            );
        }
        realtime.clear();

        for (Process process : Q1) {
            System.out.println(
                "process_id: " + process.process_id +
                " queue_id: " + process.queue_id +
                " priority: " + process.priority +
                " computing_time: " + process.computing_time +
                " turn_around_time: " + process.turn_around_time
            );
        }
        Q1.clear();
    }
}
