import java.util.PriorityQueue;

public class Time {
    static int durationTime=0;

    static Process copyProcess[];
    public  static void setCopyProcess(Process p[]){
        copyProcess=p;

    }
    public static int getProcessDuration(int idofProcess){

        for (Process p:copyProcess
                ) {

            if (idofProcess==p.id){
                 durationTime=p.duration;
//                System.out.println("ppppppppppppppppp id:"+p.id);
//                System.out.println("ppppppppppppppppp Brust Time"+p.duration);
            }

        }
        return durationTime;
    }
    }

