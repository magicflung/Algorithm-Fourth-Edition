package String.StringSorts;

public class LSD {
	public static void sort(String[] a, int W) {
		// 通过前W个字符将a[]排序
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		for(int d = W - 1; d >= 0; d--) {
			// 根据第d个字符用建索引计数法排序
			int[] count = new int[R + 1]; // 计算出现的频率
			for(int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
				// 下表加1，是为了访问count[]数组对应位置时可以直接获取aux[]中对应的下标
			}
			for(int r = 0; r < R; r++) { // 将频率转换为索引
				count[r + 1] += count[r];
			}
			for(int i = 0; i < N; i++) { // 将元素分类
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			for(int i = 0; i < N; i++) { // 回写
				a[i] = aux[i];
			}
		}
	}
}
