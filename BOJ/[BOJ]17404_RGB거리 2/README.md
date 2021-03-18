# [백준 17404: RGB거리 2 🔴](https://www.acmicpc.net/problem/17404)

<br/>

### sudo✍
보자마자 이건 누가봐도 이리봐도 저리봐도 dp문제다라고 확신했다. 역시나역시나 dp였다. dp는 싫다... 아무튼 RGB가 중복되면 안되기 때문에 첫번째 집 선택하는 거에 따라 답이 달라지겠어서 이차원 배열을 선언해야겠다고 생각했다.   

<br/>

#### **아이디어** 
1. dp[3][N]를 선언하여 i번째 방에 어떤 색을 칠하는지 구한다.
    * RGB가 중복되면 안되므로 아래와 같은 식을 도출할 수 있다.
    * dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paint[i][0];
    * dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paint[i][1];
    * dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paint[i][2];
2. N번째 방의 값 중 최소값을 갱신한다.
3. 완성!

<br/>

처음 위의 아이디어를 떠올리고 처음 작성한 코드는 [이 코드](https://colorscripter.com/s/r0mGYS9)다. 

<br/>

### algorithm💻
1. dp[3][N]를 선언하여 첫번째 방에 어떤 색을 칠하는지 구한다.  
    ```java
    for (int color = 0; color < 3; color++) {
        for (int check = 0; check < 3; check++) {
            if (check == color) dp[0][check] = paint[0][color];
            else dp[0][check] = INF;
        }

        ...
    }
    ```

2. i번째 방에 어떤 색을 칠하는지 구한다.
    ```java
     for (int i = 1; i < N; i++) {
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paint[i][0];
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paint[i][1];
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paint[i][2];
    }
    ```

3. 최소값 도출  
    문제 조건에 의해서 첫번째방과 마지막방의 색이 일치하면 안되므로 아래와 같은 코드가 나왔다.
    ```java
    for (int check = 0; check < 3; check++) {
        if (color == check) continue;
        ans = Math.min(ans, dp[N-1][check]);
    }
    ```    
