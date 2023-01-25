import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FCFS{
    /**
     * @param args the command line arguments
     */
    public
//    static PriorityQueue<Process> copyProcessQueue  = new PriorityQueue<Process>(10);
    static PriorityQueue<Process> processQueue = new PriorityQueue<Process>(10, new Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });

    static PriorityQueue<Process> waitingQueue = new PriorityQueue<Process>(10, new Comparator<Process>() {
        public int compare(Process process1, Process process2) {
            return (int)(process1.getDuration()-process2.getDuration());
        }
    });

    static PriorityQueue<Process> readyQueue = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getDuration()-process2.getDuration());
                }
            });
    static GlobalTimer globalTimer = new GlobalTimer(0);

    public static void main(String[] args) {


        Process p1=new Process(1,0,2,globalTimer);
        Process p2=new Process(2,2,1,globalTimer);
        Process p3=new Process(3,1,8,globalTimer);
        Process p4=new Process(4,5,4,globalTimer);
        Process p5=new Process(5,4,5,globalTimer);
        Process copyProcess[]=new Process[]{p1,p2,p3,p4,p5};
//        for (Process p:copyProcess
//        ) {
//
//                System.out.println("ppppppppppppppppp id:"+p.id);
//                System.out.println("ppppppppppppppppp Brust Time"+p.duration);
//            }


        Time.setCopyProcess(copyProcess);
        processQueue.add(p1);
        processQueue.add(p2);

        processQueue.add(p3);

        processQueue.add(p4);
        processQueue.add(p5);






//        int fl=0;
        while(!processQueue.isEmpty()){

            if(checkIfNewProcessArrived()){

                while(!processQueue.isEmpty() && processQueue.element().getArrivalTime()<
                        globalTimer.time){
//                    System.out.println("I am in waiting stage");
//                    Scanner scanner=new Scanner(System.in);
//                    scanner.nextLine();
                    addinWaitingQueue();
                }

                while(!waitingQueue.isEmpty()){
//                    System.out.println("I am ready for add readyqueue");
//                    Scanner scanner=new Scanner(System.in);
//                    scanner.nextLine();
                    readyQueue.add(waitingQueue.poll());
                }
            }

//            if(!readyQueue.isEmpty())
//                runProcessInCpu();

            else {
//                fl++;
//                System.out.println("No process is in Ready Queue");
//                System.out.println("No proceess ------- Global time: "+globalTimer.time);
                globalTimer.time++;

                            }
            while (!readyQueue.isEmpty()){
                if(checkIfNewProcessArrived()){
//                    System.out.println("Inner processArrived check"+checkIfNewProcessArrived());
//                    System.out.println("Global Timer:-------"+globalTimer.time);
                    break;
                }
                else {
//                    System.out.println("Inner processArrived check else  "+checkIfNewProcessArrived());
//                    System.out.println("Global Timer:-------"+globalTimer.time);
                    runProcessInCpu();
                }
            }
//            if(fl==30){
//                System.out.println("I am exit");
//                Scanner scanner=new Scanner(System.in);
//                scanner.nextLine();
//            }
        }
    }

    public static boolean checkIfNewProcessArrived(){
//        System.out.println(" i am now check process is arriving stage");
        if(!processQueue.isEmpty()){

//            System.out.println(processQueue.element().getArrivalTime());
            if(processQueue.element().getArrivalTime()<globalTimer.time)
//                System.out.println("New Process arrived at------>"+globalTimer.time);
                return true;
        }
        return false;
    }

    public static void addinWaitingQueue(){
        waitingQueue.add(processQueue.poll());
    }

    public static void runProcessInCpu(){
        Process process = readyQueue.poll();
        process.runProcess();
    }

}