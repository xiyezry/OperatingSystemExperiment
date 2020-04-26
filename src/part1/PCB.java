package part1;

/**
 * @author xiye
 */
public class PCB {
    /**进程编号（即进程名)*/
    private final int index;
    /**要求运行的时间单位数*/
    private final int demandtime;
    /**已运行的时间单位数 初始值为零*/
    private int passtime;
    /**1表示就绪状态，0表示结束状态*/
    private int state;

    public PCB(int index, int demandtime, int passtime, int state) {
        this.index = index;
        this.demandtime = demandtime;
        this.passtime = passtime;
        this.state = state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "index=" + index + ", demandtime=" + demandtime + ", passtime=" + passtime;
    }

    public void run(){
        this.passtime++;
    }

    public boolean isFinish(){
        if(this.passtime==this.demandtime){
            this.state = 0;
        }
        return this.passtime==this.demandtime;
    }
}
