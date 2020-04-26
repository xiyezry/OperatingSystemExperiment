package part2;

public class Rampart {
    private double capacity;
    private int state;
    private double address;
    private int workindex;

    public Rampart(double capacity, int state, double address, int workindex) {
        this.capacity = capacity;
        this.state = state;
        this.address = address;
        this.workindex = workindex;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setAddress(double address) {
        this.address = address;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getState() {
        return state;
    }

    public double getAddress() {
        return address;
    }

    public int getWorkindex() {
        return workindex;
    }

    public void setWorkindex(int workindex) {
        this.workindex = workindex;
    }

    @Override
    public String toString() {
        return
                "分区起始地址: " + address + "\n" +"分区长度: "+capacity+"\n"+"分区状态: "+state+"   "+"分配作业号: "+workindex;
    }
}
