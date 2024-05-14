// ArrayList를 정렬하기 위한 클래스
import java.util.Comparator;

public class SortArrayList implements Comparator<Process> {

    @Override
    public int compare(Process o1, Process o2) {

        // 비교할 priority 두 개를 선언
        int priority1 = o1.getPriority();
        int priority2 = o2.getPriority();

        if (priority1 > priority2) {
            return 1;
        } else if (priority1 < priority2) {
            return -1;
        } else
            return 0;
    }
}
