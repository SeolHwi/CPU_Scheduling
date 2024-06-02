
import java.util.*;
import java.util.concurrent.TimeUnit;

class RoundRobin {
    private static final int TIME_QUANTUM = 20;         // time quantum
    private static final int PLUS_PRIORITY = 10;        // priority 증가량
//    private static final int QUEUES = 5;                // 큐의 갯수

    private Queue queue = new Queue();

    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        queue.classification(process);
    }

    void rrRun() throws InterruptedException {
        for (int i = 0; i < queue.getQueueNum(); i++) {
            if (!queue.isQueueEmpty(i)) {
                processQueue(queue.getQueue(i));
            }
            System.out.println("Queue" + i + "is empty");
        }
    }

    private void processQueue(ArrayList<Process> queue) {
        while (!queue.isEmpty()) {
            System.out.println(
                "process_id: " + queue.get(0).getProcess_id() +
                " priority: " + queue.get(0).getPriority() +
                " computing_time: " + queue.get(0).getComputing_time() +
                " turn_around_time: " + queue.get(0).getTurn_around_time()
            );
            queue.remove(0);
        }
    }
}
//    void exRRRun() {
//        Collections.sort(realtime, new SortArrayList());
//        Collections.sort(Q1, new SortArrayList());
//        Collections.sort(Q2, new SortArrayList());
//        Collections.sort(Q3, new SortArrayList());
//        Collections.sort(Q4, new SortArrayList());
//
//        int time = 0;
//
//        while (!realtime.isEmpty()) {
//            System.out.println(
//                "process_id: " + realtime.get(0).getProcess_id() +
//                " priority: " + realtime.get(0).getPriority() +
//                " computing_time: " + realtime.get(0).getComputing_time() +
//                " turn_around_time: " + realtime.get(0).getTurn_around_time()
//            );
//
//            realtime.remove(0);
//        }
//        realtime.clear();
//
//        while (!Q1.isEmpty()) {
//            System.out.println(
//                "process_id: " + Q1.get(0).getProcess_id() +
//                " priority: " + Q1.get(0).getPriority() +
//                " computing_time: " + Q1.get(0).getComputing_time() +
//                " turn_around_time: " + Q1.get(0).getTurn_around_time()
//            );
//
//            Q1.remove(0);
//        }
//        Q1.clear();
//
//        while (!Q2.isEmpty()) {
//            System.out.println(
//                "process_id: " + Q2.get(0).getProcess_id() +
//                " priority: " + Q2.get(0).getPriority() +
//                " computing_time: " + Q2.get(0).getComputing_time() +
//                " turn_around_time: " + Q2.get(0).getTurn_around_time()
//            );
//
//            Q2.remove(0);
//        }
//        Q2.clear();
//
//        while (!Q3.isEmpty()) {
//            System.out.println(
//                "process_id: " + Q3.get(0).getProcess_id() +
//                " priority: " + Q3.get(0).getPriority() +
//                " computing_time: " + Q3.get(0).getComputing_time() +
//                " turn_around_time: " + Q3.get(0).getTurn_around_time()
//            );
//
//            Q3.remove(0);
//        }
//        Q3.clear();
//
//        while (!Q4.isEmpty()) {
//            System.out.println(
//                "process_id: " + Q4.get(0).getProcess_id() +
//                " priority: " + Q4.get(0).getPriority() +
//                " computing_time: " + Q4.get(0).getComputing_time() +
//                " turn_around_time: " + Q4.get(0).getTurn_around_time()
//            );
//
//            Q4.remove(0);
//        }
//        Q4.clear();
//    }
