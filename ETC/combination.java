package ETC;

public class combination {
    static int[] arr; //원본 배열
    static boolean[] visited; //방문여부 체크하는 배열

    public static void main(String[] args) {
    
        arr = new int[] {1,2,3,4};
        visited = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
            combi(0, 0, i+1);
        }

    }

    //int start : 탐색 시작 인덱스
    //int depth : 현재 탐색하고 있는 인덱스
	//int cnt : 뽑고자 하는 개수
    public static void combi(int start, int depth, int cnt) {
        if(depth == cnt) {
            for(int i=0; i<arr.length; i++) {
                if(visited[i])
                    System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i+1, depth+1, cnt);
                visited[i] = false;
            }
        }
    }
}
