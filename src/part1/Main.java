package part1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author xiye
 */
public class Main {
    public static void main(String[] args) {
        int totalPCB=5;
        int a=1;
        LinkedList<PCB> pcbLinkedList = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入每个进程要求运行的时间：");
        for (int i=0;i<totalPCB;i++){
            pcbLinkedList.add(new PCB(i+1,s.nextInt(),0,1));
        }
        while(!pcbLinkedList.isEmpty()){
            System.out.println("###第"+a+"轮###");
            System.out.println("当前准备运行进程状况");
            System.out.println(pcbLinkedList.getFirst().toString());
            pcbLinkedList.getFirst().run();
            if(pcbLinkedList.getFirst().isFinish()){
                pcbLinkedList.getFirst().setState(0);
                pcbLinkedList.remove();
            }
            else{
                pcbLinkedList.add(pcbLinkedList.remove());
            }
            System.out.println("该进程运行结束后队列状况");
            if(pcbLinkedList.size()!=0) {
                for (int i = 0; i < pcbLinkedList.size(); i++) {
                    System.out.println(pcbLinkedList.get(i).toString());
                }
            }
            else{
                System.out.println("所有进程运行完毕");
            }
            System.out.println();
            a++;
        }
    }
}
