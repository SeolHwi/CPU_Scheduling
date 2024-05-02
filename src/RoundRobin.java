
import java.util.*;

public class RoundRobin {
    private static final int time_quantum = 20;
    private static final int QUEUES = 5;

    ArrayList<Process> processes = new ArrayList<>();

    void add(Process process) {
        processes.add(process);
    }

    void example() {
        for (Process process : processes) {
            System.out.println(
                "process_id: " + process.process_id +
                " queue_id: " + process.queue_id +
                " priority: " + process.priority +
                " computing_time: " + process.computing_time +
                " turn_around_tiem: " + process.trun_around_time
            );
        }
    }
}
