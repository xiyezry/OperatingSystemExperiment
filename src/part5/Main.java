package part5;

import java.util.Random;

/**
 * @author xiye
 */
public class Main {
    public static int productionNumber=0;
    public static int[] buffer = new int[10];
    public static int s1 = 10;
    public static int s2 = 0;
    public static int in = 0;
    public static int out = 0;
    public static int currentProcess = 0;
    public static int PC = 0;
    public static int getProductionNumber = 0;
    public static int[] producerExe = new int[]{4,0,2,1,6};
    public static int[] consumerExe = new int[]{0,3,1,5,6};
    public static int maxProduction = 20;
    public static PCB producer = new PCB("producer",0,0,0);
    public static PCB consumer = new PCB("consumer",0,0,0);
    public static PCB current = currentProcess==0?producer:consumer;



    public static void produce(){
        productionNumber++;
        System.out.println(Main.productionNumber+"号产品已被生产");
    }

    public static void consume(){
        System.out.println(Main.getProductionNumber+"号产品已被消费");
    }

    public static void p(){
        if(current==producer){
            System.out.println("生产者P操作.");
            if(--s1<0){
                System.out.println("生产者等待.");
                current.state = 2;
                current.waitReason = 1;
                current.breakpoint=0;
            }
        }
        else{
            System.out.println("消费者P操作");
            if(--s2<0){
                System.out.println("消费者等待.");
                current.state = 2;
                current.waitReason = 2;
                current.breakpoint = 0;
            }
        }
    }

    public static void v(){
        if (current==producer){
            System.out.println("生产者v操作");
            if(++s2<=0&&consumer.state==2){
                consumer.state =0;
            }
        }
        else{
            System.out.println("消费者v操作");
            if(++s1<=0&&producer.state==2){
                producer.state=0;
            }
        }
    }

    public static void put(){
        buffer[in] = productionNumber;
        System.out.println("生产者于"+in+"号缓冲区存入了产品！");
        in = (in+1)%10;
    }
    public static void get(){
        getProductionNumber = buffer[out];
        System.out.println("消费者于"+out+"号缓冲区取出了产品！");
        out = (out+1) %10;
    }
    public static void gotoo(){
        if(current==producer){
            System.out.println("生产者执行goto");
            if(productionNumber>=maxProduction){
                System.out.println("生产者已经生产完指定件数商品，生产者结束运行！");
                current.state = 3;
            }
        }
        else{
            System.out.println("消费者执行goto");
        }
        PC=0;
    }


    public static void main(String[] args) {

        while(true){
            current.breakpoint = PC;
            if(current.state!=2&&current.state!=3){
                current.state = 0;
            }
            Random random  = new Random();
            int randomNum = random.nextInt(2);
            if(producer.state==0&&consumer.state==0){
                current=(randomNum==0)?producer:consumer;
            }
            else if(producer.state==0){
                current = producer;
            }
            else if(consumer.state==0){
                current = consumer;
            }
            else{
                System.out.println("队列为空 调度结束");
                return;
            }
            current.state=1;
            PC = current.breakpoint;
            int i = PC++;
            switch((current == producer)? producerExe[i]:consumerExe[i]){
                case 0:
                    p();break;
                case 1:
                    v();break;
                case 2:
                    put();break;
                case 3:
                    get();break;
                case 4:
                    produce();break;
                case 5:
                    consume();break;
                case 6:
                    gotoo();break;
                default:
                    break;
            }
        }
    }
}
