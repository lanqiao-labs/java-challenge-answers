
public class Yh_tangle {
	public static void yh(int n) {
		int yh[][]=new int[n][]; //定义二维数组；必须设置一维长度
        int sum=0; //总和
		
        //遍历二维数组
		for(int i=0;i<n;i++) {
			yh[i]=new int[i+1];//申请空间，第i行有i+1个数（i从0开始）
			for(int j=0;j<n-i-1;j++) {//打印等腰三角前面的空格
				System.out.print("  ");//两个空格
			}
            //遍历一维数组
			for(int j=0;j<i+1;j++) {
				if(j==0||j==yh[i].length-1) {//行首行末为1
					yh[i][j]=1;
				}else {
                    //当前一维数组的索引n元素的值，等于前一个数组索引n-1，加上索引n的值
					yh[i][j]=yh[i-1][j]+yh[i-1][j-1];
				}
                //格式化输出元素值
				System.out.printf("%4s",yh[i][j]+" ");
                //求和
                sum += yh[i][j];
			}
            //换行
			System.out.println();
		}
        //输出总和
        System.out.print("\n"+"前十行和为："+sum);
	}
	public static void main(String[] args) {
        //调用输出方法
		yh(10);
	}
}