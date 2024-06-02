
import java.util.*;

class RoundRobbin {
    private static final int TIME_QUANTUM = 20;         // time quantum

    private Queue queue = new Queue();

    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        queue.classification(process);
    }

    boolean allQueuesEmpty() {
        for (int i = 0; i < queue.getQueueNum(); i++) {
            if (!queue.isEmptyQueue(i)) {
                return false;
            }
        }
        return true;
    }

    void rrRun() {
        processQueue(0, TIME_QUANTUM);
    }

    private void processQueue(int queueIndex, int running_time) {

        ArrayList<Process> currentQueue = queue.getQueue(queueIndex);
        String queueName = queue.getQueueName(queueIndex);

        if (currentQueue.isEmpty()) {
            System.out.println(queueName + " is Empty.");
            processQueue(queueIndex + 1, TIME_QUANTUM);
            return;
        }

        Process process = currentQueue.remove(0);
        int remainingTime =  process.getRemaining_time();

        if (remainingTime > running_time) {
            process.setRemaining_time(remainingTime - running_time);

            if (!queueName.equals("real_time")) {
                process.setPriority();
            }
            classification(process);

            System.out.println(
                    " process_id: " + process.getProcess_id() +
                    " Queue id: " + queueName +
                    " priority: " + process.getPriority() +
                    " computing_time: " + process.getComputing_time() +
                    " processing_time: " + process.getRemaining_time() +
                    " turn_around_time: " + process.getTurn_around_time()
            );
        } else {
            System.out.println(
                    "완료!! " +
                    " process_id: " + process.getProcess_id() +
                    " Queue id: " + queueName +
                    " priority: " + process.getPriority() +
                    " computing_time: " + process.getComputing_time() +
                    " turn_around_time: " + process.getTurn_around_time()
            );

            if (remainingTime < running_time) {
                if (!currentQueue.isEmpty())
                    processQueue(queueIndex, running_time - remainingTime);
                else if (queueIndex + 1 < queue.getQueueNum())
                    processQueue(queueIndex + 1, running_time - remainingTime);
            }
        }
    }
}
