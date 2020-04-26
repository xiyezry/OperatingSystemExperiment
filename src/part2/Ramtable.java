package part2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author xiye
 */
public class Ramtable {
    public LinkedList<Rampart> rampartLinkedList = new LinkedList<Rampart>();

    public Ramtable(){
        rampartLinkedList.add(new Rampart(128,1,0,-1));
    }

    /**
     * 用以为作业申请内存空间
     * @param work 输入作业对象
     * @return 返回能否成功申请
     */
    public boolean apply(Work work){
        for(int i=0;i<rampartLinkedList.size();i++){
            if(rampartLinkedList.get(i).getState()==1&&rampartLinkedList.get(i).getCapacity()>work.getSize()){
                rampartLinkedList.add(i,new Rampart(work.getSize(),0,rampartLinkedList.get(i).getAddress(),work.getWorkindex()));
                rampartLinkedList.get(i+1).setCapacity(rampartLinkedList.get(i+1).getCapacity()-rampartLinkedList.get(i).getCapacity());
                rampartLinkedList.get(i+1).setAddress(rampartLinkedList.get(i).getAddress()+rampartLinkedList.get(i).getCapacity());
                return true;
            }
            else if(rampartLinkedList.get(i).getState()==1&&rampartLinkedList.get(i).getCapacity()==work.getSize()){
                rampartLinkedList.get(i).setWorkindex(work.getWorkindex());
                rampartLinkedList.get(i).setState(0);
                return true;
            }
        }
        return false;
    }

    /**
     * 用以释放内存空间
     * @param workindex 输入释放作业号
     * @return 返回是否成功释放
     */
    public boolean release(int workindex){
        for(int i=0;i<rampartLinkedList.size();i++){
            if(rampartLinkedList.get(i).getWorkindex()==workindex){
                    rampartLinkedList.get(i).setWorkindex(-1);
                    rampartLinkedList.get(i).setState(1);
                    merge();
                    return true;
            }
        }
        return false;
    }

    /**
     * 用以合并相邻分区
     */
    public void merge(){
        if(rampartLinkedList.size()>1) {
            for (int i = 0; i < rampartLinkedList.size() - 1; i++) {
                if (rampartLinkedList.get(i).getState() == 1 && rampartLinkedList.get(i + 1).getState() == 1) {
                    rampartLinkedList.get(i).setCapacity(rampartLinkedList.get(i).getCapacity() + rampartLinkedList.get(i + 1).getCapacity());
                    rampartLinkedList.remove(i + 1);
                    i--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ramtable ramtable = new Ramtable();
        Scanner s = new Scanner(System.in);
        for(int i=0;i<ramtable.rampartLinkedList.size();i++){
            System.out.println(ramtable.rampartLinkedList.get(i).toString());
        }
        while(true) {
            System.out.println("~~~~~~主菜单~~~~~~");
            System.out.print("【1】：分配作业");
            System.out.print("【2】：释放作业");
            System.out.println("【3】：显示内存状态");
            System.out.print("请输入需要进行的操作：");
            switch (s.nextInt()){
                case 1:
                    System.out.print("请输入作业号和作业大小：");
                    if(!ramtable.apply(new Work(s.nextInt(), s.nextDouble()))) {
                        System.out.println("错误！分配失败！空间不足！");
                    }
                    break;
                case 2:
                    System.out.print("请输入需要释放的作业号：");
                    if(!ramtable.release(s.nextInt())){
                        System.out.println("错误！没有在内存分区中没有此作业号！");
                    }
                    break;
                case 3:
                    for (int i = 0; i < ramtable.rampartLinkedList.size(); i++) {
                        System.out.println("#第"+(i+1)+"分区#");
                        System.out.println(ramtable.rampartLinkedList.get(i).toString());
                    }
                    System.out.println();
                default:
                    break;
            }

        }
    }
}
