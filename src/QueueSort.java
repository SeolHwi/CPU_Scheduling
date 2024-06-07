
import java.util.ArrayList;
import java.util.Comparator;

public class QueueSort {

    public static void sort(ArrayList<Process> queue, String queueName) {

        if (queueName.equals("real_time"))
            queue.sort(Comparator.comparingInt(Process::getPriority).reversed());
        else
            queue.sort(Comparator.comparingInt(Process::getPriority));
    }
}
