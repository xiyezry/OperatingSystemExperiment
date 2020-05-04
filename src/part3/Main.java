package part3;

import java.util.Scanner;

/**
 * @author xiye
 */
public class Main {
    public static void main(String[] args) {
        Bitmap a = new Bitmap();
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("***主菜单***");
            System.out.println("【1】：分配空间 【2】:释放空间 【3】：显示位示图");
            System.out.print("请输入需要进行的操作：");
            switch (s.nextInt()){
                case 1:
                    System.out.println("请输入作业号、作业所需大小");
                    if(!a.apply(new Work(s.nextInt(),s.nextInt()))){
                        System.out.println("所剩余空间大小不足！");
                    }
                    break;
                case 2:
                    System.out.println("请输入想要释放的作业号");
                    if(!a.release(s.nextInt())){
                        System.out.println("无此作业号！");
                    }
                    break;
                case 3:
                    a.showBitMap();
                    break;
                default:
                    break;
            }
        }
    }
}
