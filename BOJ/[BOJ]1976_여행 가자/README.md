# [백준 1976번: 여행 가자 🧳](https://www.acmicpc.net/problem/1976)

### sudo ✍
이번 문제 진짜 10분컷으로 푼 것 같다. 후후 이런 문제만 있었으면 좋겠다...  
이 문제는 **같은 도시를 여러 번 방문하는 것도 가능**이라는 문구 덕분에 쉬웠다.. 만약에 저 문구가 없었다면 나는 머리털을 다 뽑아버렸을거야...

<br/>

#### 아이디어
1. 우선 도시의 연결 여부와 계획한 도시의 입력을 받아온다.
2. 방문할 도시의 첫 번째 도시를 root로 하여 bfs를 돌린다.
3. bfs로 돌리며 방문 여부(visited)를 갱신한다.
4. 계획한 도시들이 방문 여부에 존재하지 않으면 "NO"를 모두 방문했다면 "YES"를 출력한다.  

같은 도시를 여러 번 방문 가능하므로 연결만 되어 있다면 돌아서라도 갈 수 있다. 그러므로 계획한 도시들이 서로 연결만 되어 있다면 무조건 순서에 맞춰서 갈 수 있다!😊 

<br/>

### algorithm 💻  
1. 방문을 계획한 도시의 첫 번째 도시를 root로 한다.
    ```java
    q.add(cities[0])
    visited[cities[0]] = true;
    ```

2. 현재 갈 수 있는 모든 도시를 체크한다. (bfs를 돌린다.)  
    ``` java
     while(!q.isEmpty()) {
        int now = q.poll();
        for (int i = 0, size = graph[now].size(); i < size; i++) {
            int next = (int) graph[now].get(i);
            if (!visited[next]) {
                q.add(next);
                visited[next] = true;
            }
        }
     }
    ```

3. 계획한 모든 도시가 첫 번째 도시에서 갈 수 있다면 "YES"
    한 도시라도 갈 수 없다면 "NO"  
    ```java
    for (int city : cities) {
        if (!visited[city]) {
            System.out.println("NO");
            System.exit(0);
        }
    }
    System.out.println("YES");
    ```