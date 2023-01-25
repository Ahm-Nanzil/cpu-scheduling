import java.util.Comparator;
import java.util.PriorityQueue;
public class Pipeline{
    /**
     * @param args the command line arguments
     */
    public static Process copyProcess[] = new Process[5];
    static PriorityQueue<Process> processQueue = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });

    static PriorityQueue<Process> readyQueue = new PriorityQueue<Process>(10, new
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
        Process p5=new Process(5,6,5,globalTimer,-1);
//        System.out.println(forProcessCreate);
        if(forProcessCreate==0){
            copyProcess= new Process[]{p1, p2, p3, p4, p5};
            forProcessCreate=1;
        }

        processQueue.add(new Process(1,0,2,globalTimer,-1));

        processQueue.add(new Process(2,2,1,globalTimer,-1));

        processQueue.add(new Process(3,1,8,globalTimer,-1));

        processQueue.add(new Process(4,5,4,globalTimer,-1));

        processQueue.add(new Process(5,6,5,globalTimer,-1));

        while(!processQueue.isEmpty() || !readyQueue.isEmpty()){

            if(checkIfNewProcessArrived()){

                while(!processQueue.isEmpty() && processQueue.element().getArrivalTime()<=
                        globalTimer.time){

                    readyQueue.add(processQueue.poll());
                }
            }

            if(!readyQueue.isEmpty())
                runProcessInCpu();
            else {System.out.println("No process is in Ready Queue");
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
        Process process1= readyQueue.poll();
        Process process2= readyQueue.poll();

        if(process1!=null){
            for (Process p:copyProcess) {
                if (p.id==process1.id){
                    if(process1.firstResponseTime==-1){
                        process1.firstResponseTime= globalTimer.time;
                    }
                }

            }
            System.out.println("run P1");
            if(process1.runProcess()){
                readyQueue.add(process1);
            }
        }
        if(process2!=null){
            for (Process p:copyProcess) {
                if (p.id==process2.id){
                    if(process2.firstResponseTime==-1){
                        process2.firstResponseTime= globalTimer.time;
                    }
                }

            }
            System.out.println("Run p2");
            if(process2.runProcess()){
                readyQueue.add(process2);
            }
        }

        globalTimer.time++;
        System.out.println("Global Time:  "+globalTimer.time);

    }
}