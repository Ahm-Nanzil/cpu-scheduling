

public class Process {
    int id;
    int arrivalTime;
    int duration;
    GlobalTimer globalTimer;


    public Process(int id,int arrivalTime, int duration, GlobalTimer globalTimer){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
        this.globalTimer=globalTimer;
    }

    public void runProcess(){



            System.out.println("My process ID: "+id);
        System.out.println("duration:---->"+duration);
            System.out.println("Global time: "+globalTimer.time);
            globalTimer.time++;
            duration--;

            if(duration<=0){
//                System.out.println("Goingggggggggggggggggggggggggggggggggg to get duration");
                int initialDuration=Time.getProcessDuration(id)+1;
                int turnAroundTime=globalTimer.time-1-arrivalTime;
                int waitingTime=turnAroundTime-initialDuration;
//                System.out.println("Burstime=====>"+initialDuration);
                System.out.println("Waiting time=============> "+waitingTime);
                System.out.println("Turn Arround time========> "+turnAroundTime);
                System.out.println("********Process Id: "+id + " completed its job********");
                System.out.println("--------------------------------------");
            }
            else {
//                FCFS.readyQueue.poll();
//                System.out.println("1 second reduce");
                FCFS.readyQueue.add(new Process(id, arrivalTime, duration, globalTimer));
            }



    }
    public int getId() {
        return id;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getDuration() {
        return duration;
    }
    public GlobalTimer getGlobalTimer() {
        return globalTimer;
    }
}