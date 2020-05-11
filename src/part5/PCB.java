package part5;

/**
 * @author xiye
 */
public class PCB {
    /**
     * 进程名
     */
    public String name;
    /**
     * 进程状态 0就绪态 1运行态 2等待态 3完成态
     */
    public int state;
    /**
     * 等待原因 1为等待信号量s1 2为等待信号量s2
     */
    public int waitReason;
    /**
     * 断点
     */
    public int breakpoint;

    public PCB(String name, int state, int waitReason, int breakpoint) {
        this.name = name;
        this.state = state;
        this.waitReason = waitReason;
        this.breakpoint = breakpoint;
    }
}
