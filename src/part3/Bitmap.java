package part3;

/**
 * @author xiye
 */
public class Bitmap {
    int[][] bitmap = new int[8][8];
    int[][] workmap = new int[8][8];

    public Bitmap() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                bitmap[i][j] = 0;
                workmap[i][j] = 0;
            }
        }
    }

    public boolean apply(Work work) {
        int mapRemain = 0;
        int remainSize = work.getSize();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(bitmap[i][j]==0){
                    mapRemain++;
                }
            }
        }
        if(mapRemain<remainSize){
            return false;
        }
        int index = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (bitmap[i][j] == 0) {
                    bitmap[i][j] = 1;
                    workmap[i][j] = work.getIndex();
                    showTheAddress(index, i, j);
                    remainSize--;
                    index++;
                    if(remainSize==0){
                        return true;
                    }
                    }
                }
            }
        return true;
        }


    public boolean release(int workIndex) {
        int index=1;
        boolean flag = false;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(workmap[i][j]==workIndex){
                    workmap[i][j]=0;
                    bitmap[i][j]=0;
                    showTheAddress(index,i,j);
                    index++;
                    System.out.println("已被回收！");
                    flag= true;
                }
            }
        }
        return flag;
    }

    public void showTheAddress(int index, int byteIndex, int bitIndex) {
        System.out.println("###第" + index + "块###");
        System.out.print("柱面号：" + byteIndex + " ");
        System.out.print("磁道号：" + (bitIndex / 4) + " ");
        System.out.print("物理记录号：" + (bitIndex % 4)+" ");
        System.out.print("字节号："+byteIndex+" ");
        System.out.println("位数："+bitIndex);
    }

    public void showBitMap(){
        System.out.println("~~~~位示图~~~~");
        System.out.println("  0 1 2 3 4 5 6 7");
        for(int i=0;i<8;i++){
            System.out.print(i+" ");
            for(int j=0;j<8;j++){
                System.out.print(bitmap[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~");
    }
}


