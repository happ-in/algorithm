# [백준 1302: 베스트셀러 📚](https://www.acmicpc.net/problem/1302)

## 📌 내가 생각한 알고리즘
1. HashMap으로 책 이름과 팔린 갯수를 받아온다.
2. HashMap을 정렬한다.
    * 팔린 권 수가 많은 순서대로 정렬한다.
    * 팔린 갯수가 같은 경우, 책의 이름 순서대로 정렬한다.

<br/>

## 📌 풀이 
### 1. HashMap으로 책 이름과 팔린 갯수를 받아온다.  
![image](https://user-images.githubusercontent.com/36289638/105259721-a59fc000-5bcf-11eb-8ee2-4ccc2ba40b41.png)  

* HashMap에 이미 책이 존재하면 기존 값에 +1
* 없는 경우 새롭게 넣어준다.

<br/>  

### 2. HashMap을 정렬한다.  
![image](https://user-images.githubusercontent.com/36289638/105260067-6faf0b80-5bd0-11eb-8b5d-2d86301b8640.png)
    
Map을 출력하기 위해선 entrySet, keySet을 사용합니다.  
key, val 모두 정렬 조건으로 사용해야하므로 entrySet을 사용했고, Collections.sort 사용을 위해 List로 변경한다.
    
<br/>  

![image](https://user-images.githubusercontent.com/36289638/105260563-565a8f00-5bd1-11eb-8150-3096a438b490.png)

비교하는 메소드 compare을 재정의한다.  
* if문-return : 팔린 갯수가 같은 경우, 책의 이름을 오름차순 정렬한다.
* return : 많이 팔린 순으로 정렬한다.

<br/>

### 3. 출력한다.  
![image](https://user-images.githubusercontent.com/36289638/105260771-b9e4bc80-5bd1-11eb-9f41-15b5aeef6170.png)
* 정렬된 값이므로 제일 첫 번째 값을 가져온다.
