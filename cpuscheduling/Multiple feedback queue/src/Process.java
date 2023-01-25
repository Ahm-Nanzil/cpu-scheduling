public class Process {
    int id ;
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

        boolean remaingTime=false;
//        System.out.println("Process id------------>"+id);
//        System.out.println("Arrival Time---------->"+arrivalTime);
        if (MultipleFeedbackQueue.queueNumber==0){
            switch (duration) {
                case 1:
//                    System.out.println("Enter ------------------------->1");
                    for (int i = 0; i < 1; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->1");
                    break;
                case 2:
//                    System.out.println("Enter ------------------------->2");
                    for (int i = 0; i < 2; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->2");
                    break;
                case 3:
//                    System.out.println("Enter ------------------------->3");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->3");
                    break;
                case 4:
//                    System.out.println("Enter ------------------------->4");
                    for (int i = 0; i < 4; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->3");
                    break;
                case 0:
//                    System.out.println("Duration is---------->"+duration);
                    break;
                default:

//                    System.out.println("Enter ------------------------->Bigger than 4");
                    for (int i = 0; i < 4; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    remaingTime=true;

//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->Bigger than 4");


            }
        }
        else if(MultipleFeedbackQueue.queueNumber==1){
            switch (duration) {
                case 1:
//                    System.out.println("Enter ------------------------->1");
                    for (int i = 0; i < 1; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->1");
                    break;
                case 2:
//                    System.out.println("Enter ------------------------->2");
                    for (int i = 0; i < 2; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->2");
                    break;
                case 3:
//                    System.out.println("Enter ------------------------->3");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
//                    System.out.println("Brfore leave duration"+duration);
//                    System.out.println("Brfore leave global timer"+globalTimer.time);
//                    System.out.println("leave ---------------------------->3");
                    break;
                case 4:

                    for (int i = 0; i < 4; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    break;
                    case 5:

                    for (int i = 0; i < 5; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    break;
                    case 6:

                    for (int i = 0; i < 6; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    break;
                    case 7:

                    for (int i = 0; i < 7; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    break;
                    case 8:

                    for (int i = 0; i <8; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    break;
                case 0:
//                    System.out.println("Duration is---------->"+duration);
                    break;
                default:

                    System.out.println("Enter ------------------------->Bigger than 4");
                    for (int i = 0; i < 8; i++) {
                        System.out.println("My process ID: " + id);
                        System.out.println("Global time: " + globalTimer.time);
                        globalTimer.time++;
                        duration--;
                    }
                    remaingTime=true;

                    System.out.println("Brfore leave duration"+duration);
                    System.out.println("Brfore leave global timer"+globalTimer.time);
                    System.out.println("leave ---------------------------->Bigger than 4");


            }
        }
        else if (MultipleFeedbackQueue.queueNumber==2) {
            for(int i=0;i<duration;i++){
                System.out.println("My process ID: "+id);
                System.out.println("Global time: "+globalTimer.time);
                globalTimer.time++;
            }
            remaingTime=false;
        }
        if (remaingTime==false){

            int initialArrivalTime=0;
            int initialDuration=0;
            for (Process p:MultipleFeedbackQueue.copyProcess
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

        return remaingTime;

//            globalTimer.time++;
//
//
//        System.out.println("********Process Id: "+id + " completed its job********");
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
