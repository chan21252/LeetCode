package t832;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] A) throws RuntimeException {
        int lineNum = A.length;
        final int minLineNum = 1;
        final int maxLineNum = 20;

        //检查行数
        if (lineNum < minLineNum || lineNum > maxLineNum) {
            throw new RuntimeException("A的行数不在1-20之间");
        }

        //每行取反后的二维数组
        int[][] AResver = new int[lineNum][];
        for (int i = 0; i < lineNum; i++) {
            //检查每行的长度和行数是否一致
            int lineLen = A[i].length;
            if (lineLen != lineNum) {
                throw new RuntimeException("行的长度和A的长度不一致");
            }

            //每行的元素逆序
            int[] lineResver = new int[lineLen];
            for (int j = lineLen - 1; j >= 0; j--) {
                int pixel = A[i][j];
                if (pixel < 0 || pixel > 1) {
                    throw new RuntimeException("值不是0或1");
                }
                lineResver[lineLen - j - 1] = A[i][j];
            }

            AResver[i] = lineResver;
        }

        //取反
        for (int i = 0; i < AResver.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                AResver[i][j] = (AResver[i][j] == 0) ? 1 : 0;
            }
        }

        return AResver;
    }
}
