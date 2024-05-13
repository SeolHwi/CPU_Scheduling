


public class Process {
    int process_id;
    int priority;
    int computing_time;
    String queue_id;
    int turn_around_time;
    
    Process (int process_id, int priority, int computing_time) {
        this.process_id = process_id;
        this.priority = priority;
        this.computing_time = computing_time;
        this.queue_id = (priority > 0) ? ("Q" + (priority / 10 + 1)) : "real_time";
        this.turn_around_time = 0;
    }
}
