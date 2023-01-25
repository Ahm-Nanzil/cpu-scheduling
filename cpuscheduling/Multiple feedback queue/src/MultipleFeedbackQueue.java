import java.util.Comparator;
import java.util.PriorityQueue;
public class MultipleFeedbackQueue {
    /**
     * @param args the command line arguments
     */
    public static int queueNumber=0;
    public static boolean procssArrived=false;
    public static Process copyProcess[] = new Process[5];
    static PriorityQueue<Process> processQueue = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });

    static PriorityQueue<Process> readyQueueRR1 = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });
    static PriorityQueue<Process> readyQueueRR2 = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });
    static PriorityQueue<Process> readyQueueFCFS = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });
    static GlobalTimer globalTimer = new GlobalTimer(0);

    public static void main(String[] args) {
        int forProcessCreate=0;

        Process p1=new Process(1,0,2,globalTimer,-1);
        Process p2=new Process(2,2,1,globalTimer,-1);
        Process p3=new Process(3,1,8,globalTimer,-1);
        Process p4=new Process(4,5,4,globalTimer,-1);
        Process p5=new Process(5,4,5,globalTimer,-1);
//        System.out.println(forProcessCreate);
        if(forProcessCreate==0){
            copyProcess= new Process[]{p1, p2, p3, p4, p5};
            forProcessCreate=1;
        }
//        System.out.println(forProcessCreate);


        processQueue.add(new Process(1,0,2,globalTimer,-1));
        processQueue.add(new Process(2,2,1,globalTimer,-1));
        processQueue.add(new Process(3,1,8,globalTimer,-1));
        processQueue.add(new Process(4,5,4,globalTimer,-1));
        processQueue.add(new Process(5,4,5 ,globalTimer,-1));
        while(!processQueue.isEmpty()||!readyQueueRR1.isEmpty() || !readyQueueRR2.isEmpty() || !readyQueueFCFS.isEmpty()){

            if(checkIfNewProcessArrived()){

                while(!processQueue.isEmpty() && processQueue.element().getArrivalTime()<=
                        globalTimer.time){
                    readyQueueRR1.add(processQueue.poll());
//                    procssArrived=false;
                }
            }



            while (!readyQueueRR1.isEmpty()){
                if (checkIfNewProcessArrived()){
                    procssArrived=true;
                    break;
                }else {
                    runProcessInCpu();
                }

            }

            if (processQueue.isEmpty() && readyQueueRR1.isEmpty() && !readyQueueRR2.isEmpty()){
                queueNumber=1;
                System.out.println("I am in Round Robin Queue2 For 8");
                while (!readyQueueRR2.isEmpty()){
                    if (checkIfNewProcessArrived()){
                        procssArrived=true;
                        break;
                    }else {
                        runProcessInCpu();
                    }

                }
            }
            if (processQueue.isEmpty() && readyQueueRR1.isEmpty() && readyQueueRR2.isEmpty() && !readyQueueFCFS.isEmpty()){
                queueNumber=2;
                System.out.println("I am in FCFS Queue..");
                while (!readyQueueFCFS.isEmpty()){
                    if (checkIfNewProcessArrived()){
                        procssArrived=true;
                        break;
                    }else {
                        runProcessInCpu();
                    }

                }
            }

            if (readyQueueRR1.isEmpty() && readyQueueRR2.isEmpty() && readyQueueFCFS.isEmpty()){System.out.println("No process is in Ready Queue");
                System.out.println("Global time: "+globalTimer.time);
                globalTimer.time++;

            }
        }
    }

    public static boolean checkIfNewProcessArrived(){

        if(!processQueue.isEmpty()){

            if(processQueue.element().getArrivalTime()<=globalTimer.time)
                return true;
        }
        return false;
    }

    public static void runProcessInCpu(){
        Process process;
        if (queueNumber==0){
            process= readyQueueRR1.poll();
            for (Process p:copyProcess) {
                if (p.id==process.id){
                    if(process.firstResponseTime==-1){
                        process.firstResponseTime= globalTimer.time;
                    }
                }
            }
            if (process.runProcess()){

                process.arrivalTime= globalTimer.time+1;
                readyQueueRR2.add(process);
        }

//        process= readyQueueRR1.poll();

        }
        else if (queueNumber==1) {
            process = readyQueueRR2.poll();
            for (Process p : copyProcess) {
                if (p.id == process.id) {
                    if (process.firstResponseTime == -1) {
                        process.firstResponseTime = globalTimer.time;
                    }
                }
            }
            if (process.runProcess()) {

                process.arrivalTime = globalTimer.time + 1;
                readyQueueFCFS.add(process);
            }
        }

        else if (queueNumber==2) {
            process = readyQueueFCFS.poll();
            for (Process p : copyProcess) {
                if (p.id == process.id) {
                    if (process.firstResponseTime == -1) {
                        process.firstResponseTime = globalTimer.time;
                    }
                }
            }
            process.runProcess();
        }


    }
}