package javaTest.MyTest;

public class BTestArray {

    public static void main(String[] args) {

        // psvm主方法不能调用本类的非静态方法
        // 对于一般的非static成员变量或方法，需要有一个对象的实例才能调用，
        // 所以要先生成对象的实例，他们才会实际的分配内存空间。
        // 而对于static的对象或方法，在程序载入时便已经分配了内存空间，他只和特定的类想关联，无需实例化。
        // 解决方案：1，本类方法静态，2，生成本类对象调用。
        BTestArray t = new BTestArray();

        //数组初始化
        int[] a = new int[]{100, 200, 300, 5000};
        int[] b = {100, 200, 300, 5000};

        //数组内5个数，算出最小和最大
        t.getMinAndMax();

        //将数组反转
        inversionOfArray();

        //将数组反转 首尾调换方法
        t.inversionOfArray2();

        //选择法排序
        t.selectSort();

        //冒泡排序法
        t.bubbleSort();

        //复制数组
        t.copyArray();
    }

    private void copyArray() {
        String str = "复制数组";
        int[] a = new int[]{110, 225, 3, 36, 50};
        int[] b = new int[3];
        System.arraycopy(a, 1, b, 0, 2);
        printArray(str,b);
    }

    private void bubbleSort() {
        String str = "冒泡排序法";
        int[] a = new int[]{110, 225, 3, 36, 50};
        //冒泡排序法的思路：
        //临近两位比较，把大的放在右侧，从左至右临近两位比较完之后，再从第一位开始，直到刚刚比过的最大一位左边一位。
        //第一步：把数组中最大的数字，先冒泡到最右边
        for (int j = a.length; j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        printArray(str, a);
    }

    private void selectSort() {
        String str = "选择排序法";
        int[] a = new int[]{110, 225, 3, 36, 50};

        //选择法排序的思路：
        //把第一位和其他所有的进行比较，只要比第一位小的，就换到第一个位置来
        //比较完后，第一位就是最小的
        //然后再从第二位和剩余的其他所有进行比较，只要比第二位小，就换到第二个位置来
        //比较完后，第二位就是第二小的
        //以此类推

        //第一步： 把第一位和其他所有位进行比较
        //如果发现其他位置的数据比第一位小，就进行交换
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] < a[0]) {
//                int temp = a[0];
//                a[0] = a[i];
//                a[i] = temp;
//            }
//        }

        //第二步：把第二位和其他所有位进行比较
        //如果发现其他位置的数据比第二位小，就进行交换
//        for (int i = 1; i < a.length; i++) {
//            if (a[i] < a[0]) {
//                int temp = a[0];
//                a[0] = a[i];
//                a[i] = temp;
//            }
//        }
        //依次类推，需要把i从0到数组倒数第二个（循环完倒数第二个的时候，最后一个一定是最大的）
        //所以，建立第二层循环，0<i<a.length
        for (int j = 1; j < a.length - 1; j++) {
            for (int i = j; i < j; i++) {
                if (a[i] < a[0]) {
                    int temp = a[0];
                    a[0] = a[i];
                    a[i] = temp;
                }
            }
        }
        printArray(str, a);

    }

    void inversionOfArray2() {
        int[] a = new int[5];
        for (int i = 0; i < a.length / 2; i++) {
            int middle = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
            a[i] = middle;
        }
        System.out.println("再次反转后的数组中各个值是:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //静态方法
    public static void inversionOfArray() {
        //创建数组
        int[] a = new int[5];
        //错误范例 foreach不能赋值，
        // 当使用forEach来迭代访问数组元素时，
        // forEach中的循环变量只是相当于一个临时变量，
        // 系统会把数组元素依次赋给这个临时变量，
        // 而这个临时变量并不是数组元素，它只保存了数组元素的值。相当于只读迭代输出。
        /*for (int x : a) {
            x = (int) (Math.random() * 100);
            System.out.println("随机数是：" + x);
        }*/

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
            System.out.println("第" + (i + 1) + "个随机数是：" + a[i]);
        }
        //临时数组
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[a.length - 1 - i] = a[i];
        }
        System.out.println("反转了");
        for (int x : temp) {
            System.out.println("反转后随机数是：" + x);
        }
    }

    //生成对象后调用
    public void getMinAndMax() {

        System.out.println("本练习的目的是找出一个最小值");
        int[] a = new int[5];//没有赋值，int类型的数组，默认值是0
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
            System.out.println("第" + (i + 1) + "个随机数是：" + a[i]);
        }
        //for循环找最小
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        //for循环找最大
        int max = a[0];
        for (int x : a) {
            if (max < x) {
                max = x;
            }
        }
        //打印最大值和最小值   \n是回车      \t是一个tab
        System.out.println("\n" + "找出来的最小值：" + min);
        System.out.println("\t" + "找出来的最大值：" + max);
    }

    //专门的打印方法
    public static void printArray(String str, int[] a) {
        System.out.println();
        System.out.println(str);
        for (int x :
                a) {
            System.out.println(x);

        }
        System.out.println();
    }
}
