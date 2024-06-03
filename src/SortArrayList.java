// ArrayList를 정렬하기 위한 클래스
import java.util.Comparator;

class SortArrayList implements Comparator<Process> {

    @Override
    public int compare(Process o1, Process o2) {

        // 비교할 priority 두 개를 선언
        int priority1 = o1.getPriority();
        int priority2 = o2.getPriority();

        // priority가 하나만 음수여도 realtime으로 실행되는 프로세스
        if (priority1 < 0)
            return Integer.compare(priority2, priority1);
        // priority가 양수인 경우
        else
            return Integer.compare(priority1, priority2);
    }
}
