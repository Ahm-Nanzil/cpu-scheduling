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
    }

    public boolean runProcess(){
        boolean remainingTime=true;
        System.out.println("My process ID: "+id);
        duration--;
        if (duration==0){
            remainingTime=false;
            int initialArrivalTime=0;
            int initialDuration=0;
            for (Process p:Pipeline.copyProcess
            ) {

                if (id == p.id) {
//                    System.out.println("Process ID---->"+p.id);
                    initialArrivalTime = p.arrivalTime;
//                    System.out.println("Arrival Time--->"+p.arrivalTime);
                    initialDuration = p.duration;
//                    System.out.println("Dudration------>"+duration);
                }
            }
            int turnAroundTime=globalTimer.time-initialArrivalTime+1;
            int waitingTime=turnAroundTime-initialDuration+1;
            int responseTime=firstResponseTime-initialArrivalTime;
            System.out.println("*******Process Id: "+id + " completed its job*******");
            System.out.print("Process ID    ");
            System.out.print("Waiting Time    ");
//                System.out.print("Response Time    ");
            System.out.println("Turn Around Time ");
            System.out.printf("   "+id);
            System.out.print("              "+waitingTime);
//                System.out.print("               "+responseTime);
            System.out.println("                 "+turnAroundTime);
            System.out.println("----------------------------------------------------------");
        }
        return remainingTime;
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