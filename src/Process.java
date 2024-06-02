


class Process {

    private static final int PLUS_PRIORITY = 10;        // priority 증가량
    private static final int MAX_PRIORITY = 31;         // priority 최대값

    private int start_time;             // 프로세스가 큐에 도착한 시간
    private int end_time;               // 프로세스가 종료된 시간
    private int process_id;             // 프로세스 아이디
    private int priority;               // 우선순위
    private int computing_time;         // 프로세스 수행 시간
    private int remaining_time;        // 프로세스 남은 수행 시간
    private int turn_around_time;       // 완료 시간 - 프로세스 실행 시작 시간
    
    // 프로세스 생성
    Process (int process_id, int priority, int computing_time) {
        this.start_time = 0;
        this.end_time = 0;
        this.process_id = process_id;
        this.priority = priority;
        this.computing_time = computing_time;
        this.remaining_time = computing_time;
        this.turn_around_time = 0;
    }

    public void setStart_time(int time) {
        this.start_time = time;
    }
    public void setEnd_time(int time) {
        this.end_time = time;
    }

    public int getProcess_id() {
        return process_id;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority() {
        priority += PLUS_PRIORITY;
        if (priority > MAX_PRIORITY) { priority = MAX_PRIORITY; }
    }

    public int getComputing_time() {
        return computing_time;
    }

    public int getRemaining_time() { return remaining_time; }
    public void setRemaining_time(int time) {
        this.remaining_time = time;
    }

    public int getTurn_around_time() {
        return turn_around_time;
    }
    public void setTurn_around_time() {
        turn_around_time = end_time - start_time;
    }

}
