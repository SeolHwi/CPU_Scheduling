
import java.util.*;

public class Queue {

    // Process를 담는 ArrayList들을 리스트로 만든 queues
    private List<ArrayList<Process>> queues;

    // 큐 생성
    public Queue() {
        queues = new ArrayList<>(Arrays.asList(
                new ArrayList<>(),      // real_time
                new ArrayList<>(),      // Q1
                new ArrayList<>(),      // Q2
                new ArrayList<>(),      // Q3
                new ArrayList<>()       // Q4
        ));
    }

    // 각 큐를 반환하는 메서드
    public ArrayList<Process> getQueue(int index) {
        return queues.get(index);
    }

    // 프로세스를 ArrayList에 저장
    private void add(ArrayList<Process> arrayList, Process process) {
        arrayList.add(process);
    }

    // 프로세스를 priority에 따라 큐에 분류
    void classification(Process process) {
        if (process.getPriority() < 0)               // priority가 -10 이상 0 미만인 경우
            add(queues.get(0), process);
        else if (process.getPriority() <= 10)        // priority가 1 이상 10 이하인 경우
            add(queues.get(1), process);
        else if (process.getPriority() <= 20)        // priority가 11 이상 20 이하인 경우
            add(queues.get(2), process);
        else if (process.getPriority() <= 30)        // priority가 21 이상 30 이하인 경우
            add(queues.get(3), process);
        else                                    // priority가 31 인 경우
            add(queues.get(4), process);
    }

    // 큐가 비었는지 확인
    public boolean isQueueEmpty(int index) {
        return queues.get(index).isEmpty();
    }

    // 큐의 갯수를 반환
    public int getQueueNum() {
        return queues.size();
    }

}
