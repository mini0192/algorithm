class Solution {
    int startX;
    int startY;

    private int returnMin(int[] arr) {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private int returnLen(int a, int b) {
        a -= startX;
        b -= startY;
        return (a * a) + (b * b);
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        this.startX = startX;
        this.startY = startY;

        for(int i = 0; i < balls.length; i++) {
            int[] len = new int[4];

            int fixBallX;
            int fixBallY;

            //top
            fixBallX = balls[i][0];
            fixBallY = n + (n - balls[i][1]);

            if(fixBallX == startX) {
                if(balls[i][1] > startY) {
                    len[0] = 999999;
                } else {
                    len[0] = returnLen(fixBallX, fixBallY);
                }
            } else {
                len[0] = returnLen(fixBallX, fixBallY);
            }

            //left
            fixBallX = balls[i][0] * -1;
            fixBallY = balls[i][1];

            if(fixBallY == startY) {
                if(balls[i][0] < startX) {
                    len[1] = 999999;
                } else {
                    len[1] = returnLen(fixBallX, fixBallY);
                }
            } else {
                len[1] = returnLen(fixBallX, fixBallY);
            }

            //right
            fixBallX = m + (m - balls[i][0]);
            fixBallY = balls[i][1];

            if(fixBallY == startY) {
                if(balls[i][0] > startX) {
                    len[2] = 999999;
                } else {
                    len[2] = returnLen(fixBallX, fixBallY);
                }
            } else {
                len[2] = returnLen(fixBallX, fixBallY);
            }

            //bottom
            fixBallX = balls[i][0];
            fixBallY = balls[i][1] * -1;

            if(fixBallX == startX) {
                if(balls[i][1] < startY) {
                    len[3] = 999999;
                } else {
                    len[3] = returnLen(fixBallX, fixBallY);
                }
            } else {
                len[3] = returnLen(fixBallX, fixBallY);
            }

            answer[i] = returnMin(len);
        }
        return answer;
    }
}