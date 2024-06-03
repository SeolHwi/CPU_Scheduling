
import java.util.*;

class RoundRobin {
    static int currentTime = 0;                         // 현재 시간

    private Queue queue = new Queue();

    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        if (process.getIsNewProcess()) {
            process.setStart_time(currentTime);
            process.setIsNewProcess(false);
        }
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

    void rrRun(int queueIndex, int runningTime) {

        PriorityQueue<Process> currentQueue = queue.getQueue(queueIndex);
        String queueName = queue.getQueueName(queueIndex);

        if (currentQueue.isEmpty()) {                   // 현재 큐가 비어있는 경우
            rrRun(queueIndex + 1, runningTime);     // 다음 큐로 메서드 실행
            return;
        }

        Process process = currentQueue.poll();       // 변경된 부분: remove(0) -> poll()
//        Process process = currentQueue.remove(0);       // 현재 큐에서 프로세스 추출
        int remainingTime =  process.getRemaining_time();

        if (remainingTime > runningTime) {
            currentTime += runningTime;
            process.setRemaining_time(remainingTime - runningTime);

            if (!queueName.equals("real_time"))         // 큐가 real time이 아닌 경우 priority에 10 추가
                process.setPriority();
            classification(process);                    // priority로 큐에 분류

        } else {
            currentTime += remainingTime;
            process.setEnd_time(currentTime);
            process.setTurn_around_time();
            System.out.println(
                    "process_id: " + process.getProcess_id() +
                    "\t Queue id: " + queueName +
                    "\t priority: " + process.getPriority() +
                    "\t computing_time: " + process.getComputing_time() +
                    "\t turn_around_time: " + process.getTurn_around_time()
            );

            // 프로세스를 종료시키고 남은 시간이 있을 경우
            if (remainingTime < runningTime) {
                if (!currentQueue.isEmpty())        // 종료한 프로세스가 있던 큐에 다른 프로세스가 있는 경우
                    rrRun(queueIndex, runningTime - remainingTime);
                else if (queueIndex + 1 < queue.getQueueNum())      // 다음 큐가 있는 경우
                    rrRun(queueIndex + 1, runningTime - remainingTime);
            }
        }
    }
}
