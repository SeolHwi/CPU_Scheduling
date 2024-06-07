
import java.util.Comparator;
import java.util.LinkedList;

public class QueueSort {

    public static void sort(LinkedList<Process> queue, String queueName) {

        if (queueName.equals("real_time"))
            queue.sort(Comparator.comparingInt(Process::getPriority).reversed());
        else
            queue.sort(Comparator.comparingInt(Process::getPriority));
    }
}
