
import java.util.*;

class RoundRobbin {
    private static final int TIME_QUANTUM = 20;         // time quantum

    private Queue queue = new Queue();

    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        queue.classification(process);
    }

    // 모든 큐가 비었는 지 확인 (하나라도 프로세스가 존재하면 false)
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

    private void processQueue(int queueIndex, int runningTime) {

        ArrayList<Process> currentQueue = queue.getQueue(queueIndex);
        String queueName = queue.getQueueName(queueIndex);

        if (currentQueue.isEmpty()) {                   // 현재 큐가 비어있는 경우
            System.out.println(queueName + " is Empty.");
            processQueue(queueIndex + 1, runningTime);     // 다음 큐로 메서드 실행
            return;
        }

        Process process = currentQueue.remove(0);       // 현재 큐에서 프로세스 추출
        int remainingTime =  process.getRemaining_time();

        if (remainingTime > runningTime) {
            process.setRemaining_time(remainingTime - runningTime);

            if (!queueName.equals("real_time"))         // 큐가 real time이 아닌 경우 priority에 10 추가
                process.setPriority();
            classification(process);                    // priority로 큐에 분류

        } else {
            System.out.println(
                    "완료!! " +
                    " process_id: " + process.getProcess_id() +
                    " Queue id: " + queueName +
                    " priority: " + process.getPriority() +
                    " computing_time: " + process.getComputing_time() +
                    " turn_around_time: " + process.getTurn_around_time()
            );

            // 프로세스를 종료시키고 남은 시간이 있을 경우
            if (remainingTime < runningTime) {
                if (!currentQueue.isEmpty())        // 종료한 프로세스가 있던 큐에 다른 프로세스가 있는 경우
                    processQueue(queueIndex, runningTime - remainingTime);
                else if (queueIndex + 1 < queue.getQueueNum())      // 다음 큐가 있는 경우
                    processQueue(queueIndex + 1, runningTime - remainingTime);
            }
        }
    }
}
