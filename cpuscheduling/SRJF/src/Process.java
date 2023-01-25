public class Process {
    int id;
    int arrivalTime;
    int duration;

    int firstResponseTime;
    GlobalTimer globalTimer;

    public Process(int id,int arrivalTime, int duration, GlobalTimer globalTimer,int firstResponseTime){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
        this.globalTimer=globalTimer;
        this.firstResponseTime=firstResponseTime;
    }

    public boolean runProcess(){
        boolean free=false;
            System.out.println("My process ID: "+id);
            System.out.println("Global time: "+globalTimer.time);
            globalTimer.time++;
            duration--;

if (duration==0){
    free=true;
        int initialArrivalTime=0;
        int initialDuration=0;
        for (Process p:SRJF.copyProcess
        ) {

            if (id == p.id) {
//                    System.out.println("Process ID---->"+p.id);
                initialArrivalTime=p.arrivalTime;
//                    System.out.println("Arrival Time--->"+p.arrivalTime);
                initialDuration=p.duration;
//                    System.out.println("Dudration------>"+duration);
            }
        }


        int turnAroundTime=globalTimer.time-initialArrivalTime;
        int waitingTime=turnAroundTime-initialDuration;
        int responseTime=firstResponseTime-initialArrivalTime;
        System.out.println("My process ID: "+id);
        System.out.println("Global time: "+globalTimer.time);
//            System.out.println("First Response Time"+firstResponseTime);
//            System.out.println("Waiting time=============> "+waitingTime);

//            System.out.println("Turn Arround time========> "+turnAroundTime);

        System.out.println("********Process Id: "+id + " completed its job********");
        System.out.print("Process ID    ");
        System.out.print("Waiting Time    ");
        System.out.print("Response Time    ");
        System.out.println("Turn Around Time ");
        System.out.printf("   "+id);
        System.out.print("              "+waitingTime);
        System.out.print("               "+responseTime);
        System.out.println("                 "+turnAroundTime);
        System.out.println("----------------------------------------------------------");

}

return free;

    } public int getId() {
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
