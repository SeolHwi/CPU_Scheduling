
import java.util.*;

class RoundRobbin {
    private static final int TIME_QUANTUM = 20;         // time quantum
    private static final int PLUS_PRIORITY = 10;        // priority 증가량
    private static final int MAX_PRIORITY = 31;         // priority 최대값

    private Queue queue = new Queue();

    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        queue.classification(process);
    }

    void rrRun() {
        for (int i = 0; i < queue.getQueueNum(); i++) {
            if (!queue.isQueueEmpty(i)) {
                processQueue(queue.getQueue(i), queue.getQueueName(i));
            }
            System.out.println(queue.getQueueName(i) + " is empty");
        }
    }

    private void processQueue(ArrayList<Process> queue, String name) {

        while (!queue.isEmpty()) {

            Process process = queue.remove(0);
            int remainingTime =  process.getProcessing_time();

            if (remainingTime > TIME_QUANTUM) {
                process.setProcessing_time(remainingTime - TIME_QUANTUM);

                if (!name.equals("real_time")) {
                    int newPriority = Math.min(process.getPriority() + PLUS_PRIORITY, MAX_PRIORITY);
                    process.setPriority(newPriority);
                    classification(process);
                }
            } else {
                System.out.println(
                        "process_id: " + process.getProcess_id() +
                        " Queue id: " + name +
                        " priority: " + process.getPriority() +
                        " computing_time: " + process.getComputing_time() +
                        " turn_around_time: " + process.getTurn_around_time()
                );
            }
        }
    }
}
