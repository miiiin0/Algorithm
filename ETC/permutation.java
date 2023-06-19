

public class permutation {

    static int[] arr; //원본 배열
	static int[] output; //출력하고자 하는 배열
    static boolean[] visited; //방문여부 체크하는 배열

    public static void main(String[] args) {
    
        arr = new int[] {1,2,3};
        output = new int[arr.length];
        visited = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
            perm(0, i+1);
        }

    }

	//int depth : 현재 탐색하고 있는 인덱스
	//int cnt : 뽑고자 하는 개수
    public static void perm(int depth, int cnt) {
        
        if(depth == cnt) {
            for(int i=0; i<cnt; i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth+1, cnt);
                visited[i] = false;
            }
        }
    }
}