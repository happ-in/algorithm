# [백준: 1238 파티 🥳](https://www.acmicpc.net/problem/1238)

### sudo ✍ 
처음에는 이차원 배열로 visited[from][to] 이렇게해서 해야하나 했는데 생각해보니 최단 시간이면 그냥 다익스트라를 쓰면 되겠군? 이란 생각이 들었다. 처음에 푼 코드가 [시간초과](https://colorscripter.com/s/xyDgMk9)여서 다익스트라 알고리즘을 내가 잘못 알고 있군! 이란 생각이 들어 위키백과의 내용을 좀 참고 했다. ㅎㅎ.. 시간초과 코드보면 **당당하게 삼중 for문**을 쓰고 통과되길 바랬다... 몽총이 😎

<br/>

### [다익스트라 알고리즘](https://ko.wikipedia.org/w/index.php?title=%EB%8D%B0%EC%9D%B4%ED%81%AC%EC%8A%A4%ED%8A%B8%EB%9D%BC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98&action=edit&section=2)  
1. 모든 꼭짓점을 미방문 상태로 표시한다. 
2. 초기점을 0으로, 다른 모든 꼭짓점을 무한대로 설정한다. 
3. 미방문한 마을 중 최단 거리를 가진 마을과 연결된 도시들의 거리를  갱신
4. 미방문한 마을 중 최단 거리를 가진 마을을 방문한 마을로 변경
5. 도시 마을 N번 만큼 반복


<br/>

### algorithm 💻
1. 모든 꼭짓점을 미방문 상태로 표시
2. 초기점은 0, 나머지 꼭짓점은 무한대로 설정
    ```java
    int[] minDist = new int[N+1];
    boolean[] visited = new boolean[N+1];체크
    Arrays.fill(minDist, INF);
    minDist[root] = 0;
    ```

3. 미방문한 마을 중 최단 거리를 가진 마을과 연결된 도시들의 거리를  갱신
    * 3-1) 미방문한 꼭짓점 중 최단 거리를 가진 꼭짓점 찾기
        ```java
        for (int j = 1; j <= N; j++) {
            if (!visited[j] && min > minDist[j]) {
                min = minDist[j];
                index = j;
                }
        }
        ```
    * 3-2) 연결된 도시들 갱신  
        ```java
        for (int j = 0, size = cities[index].size(); j < size; j++) {
            Conn conn = cities[index].get(j);
            if (minDist[index] == INF || visited[conn.x]) continue;
            minDist[conn.x] = Math.min(minDist[conn.x], minDist[index] + conn.dist);
        }
        ```

4. 미방문한 마을 중 최단 거리를 가진 마을을 방문한 마을로 변경
    ```java
    visited[index] = true;
    ```

5. 도시 마을 N번 만큼 반복
6. 끝!

<br/>

### 배운 점 🌵  
다익스트라 알고리즘 문제를 오랜만에 풀었더니 좋았다! 잊어버렸던 알고리즘 하나를 다시 찾은 느낌? 다음 문제는 벨만포드 알고리즘으로 골라봐야겠다