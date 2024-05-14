


public class Process {

    private int process_id;
    private int priority;
    private int computing_time;
    private int turn_around_time;
    
    // 프로세스 생성
    Process (int process_id, int priority, int computing_time) {
        this.process_id = process_id;
        this.priority = priority;
        this.computing_time = computing_time;
        this.turn_around_time = 0;
    }

    public int getProcess_id() {
        return process_id;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getComputing_time() {
        return computing_time;
    }

    public int getTurn_around_time() {
        return turn_around_time;
    }
    public void setTurn_around_time(int turn_around_time) {
        this.turn_around_time = turn_around_time;
    }

}
