import java.io.*;
import java.util.*;

public class BOJ2042 {
    static long[] tree, arr;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[4 * N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {       // 변경
                update(1, N, 1, b, c - arr[b]);
                arr[b] = c;     // 안 바꿔준거 멍청했다
            } else {
                sb.append(search(1, N, b, (int) c, 1)).append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }

    // 세그먼트 트리 생성
    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];       // 시작 == 끝, 트리 노드에 값 삽입
        int mid = (start + end) / 2;                            // 왼쪽, 오른쪽 노드의 합으로 상위 노드 값 구하는 재귀
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // 값 변경
    static void update(int start, int end, int node, int idx, long change) {
        if (idx < start || idx > end) return;       // 범위 out 종료
        tree[node] += change;                       // 인덱스가 존재하는 범위면 값 변경
        if (start == end) return;                   // leaf 노드면 종료
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, change);               // 왼쪽 줄기 update
        update(mid + 1, end, node * 2 + 1, idx, change);    // 오른쪽 줄기 update
    }

    // 원하는 구간 값 검색
    static long search(int start, int end, int from, int to, int node) {
        if (end < from || start > to) return 0;                         // 범위 out
        if (from <= start && to >= end) return tree[node];              // 찾고자 하는 범위 안에 포함되는 노드면 값을 반환
        int mid = (start + end) / 2;                                    // 위에서 포함되지 않는 나머지 노드의 값을 찾아서 반환
        return search(start, mid, from, to, node * 2) + search(mid + 1, end, from, to, node * 2 + 1);
    }
}
