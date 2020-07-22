package SWE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_3752_2 {
	// 3752. ������ �������� (d4)
	// �ι�° Ǯ��. dfs
	static int count;
	static int N;
	static int AllScore[];
	static int score[];

	public static void dfs(int depth) {
		
		// ���� ����
		if (depth >= N) {
			for (int i = 0; i < AllScore.length; i++) {
				if (AllScore[i] > 0) {
					count++;
				}
			}
			return;
		}
		
		for (int j = AllScore.length - 1; j >= 0; j--) {
			if (AllScore[j] == 1) {
				AllScore[j + score[depth]] = 1;
			}
		}
		dfs(depth+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // test_case ����

		for (int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			// ���� ����
			N = Integer.parseInt(br.readLine());

			score = new int[N]; // ���� �������� ���� �迭
			int sum = 0;

			// ������ ����
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(str[i]);
				sum += score[i];
			}

			AllScore = new int[sum + 1]; // ������ �������� ����
			AllScore[0]++;


			// �˻�
			dfs(0);
			
			// ���
			bw.write("#" + test_case + " " + count + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}
}
