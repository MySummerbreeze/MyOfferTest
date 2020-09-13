package com.zzy.test12Backtracking;

/**
 * ���ݷ�����������е�·��
 * 		���ݷ�ͨ��ʹ�õݹ�ʵ��
 * 		�ص㣺��������ĳһ��ѡ��������һ��ѡ��ʱ���ͽ�����һ����Ȼ���������µ�ѡ����Ǿ������ظ�ѡ��ֱ����������״̬��
 * @author user
 *
 *	����������˵ֻ�ܱ���
 *		����������
 *			��һ����������ÿһ���ַ���������dfs����
 *			�ڶ�������dfs������
 *				�����ж��Ƿ���磬�������ַ��뵱ǰ�ַ�����ȣ������򷵻�false
 *				�ڶ����ж��Ƿ��Ѿ��ҵ����е��ַ���������length-1�Ƿ���ڵ�ǰindex�����ϱߵ��ж��У��Ѿ����й��Ƿ���ȵ��ж�
 *				�����������һ��char�����У���Ϊ���������ַ���Ҫ��¼����ν���ǰ�ַ�����Ϊһ�������ַ�
 *				��������
 *				boolean res = 
 *				dfs(row+1,col,word,index+1,board)||
 *				dfs(row-1,col,word,index+1,board)||
				dfs(row,col+1,word,index+1,board)||
				dfs(row,col-1,word,index+1,board);
				���ԭ�ַ�����board
				����true
 *
 */

public class MyBacktracking {
	public static boolean exist(char[][] board, String word) {
		if(word.equals("")||word == null) {
			return false;
		}
		if(board == null||board.length == 0) {
			return false;
		}
		//�ҵ���һ��char
		for(int i = 0;i<board.length;i++) {
			for(int j = 0;j<board[i].length;j++) {
				if(dfs(i,j,word,0,board)) {
					return true;
				}
			}
		}
		
		return false;
    }
	
	public static boolean dfs(int row,int col,String word,int index,char[][] board) {
		if(row>=board.length||row<0||
			col>=board[0].length||col<0||
			word.charAt(index) != board[row][col]) {
			return false;
		}
		if(word.length()-1 == index) {
			return true;
		}
		char tmp = board[row][col];
		board[row][col] = '$';
		boolean res = dfs(row+1,col,word,index+1,board)||dfs(row-1,col,word,index+1,board)||
				dfs(row,col+1,word,index+1,board)||dfs(row,col-1,word,index+1,board);
		board[row][col] = tmp;
		return res;
	}
	
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(exist(board,word));;
	}
}









/*public static boolean exist(char[][] board, String word) {
char[] words = word.toCharArray();
for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
        //��[i,j]������꿪ʼ����
        if (dfs(board, words, i, j, 0))
            return true;
    }
}
return false;
}

static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
//�߽���жϣ����Խ��ֱ�ӷ���false��index��ʾ���ǲ��ҵ��ַ���word�ĵڼ����ַ���
//�������ַ�������board[i][j]��˵����֤�������·�����߲�ͨ�ģ�ֱ�ӷ���false
if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
    return false;
//���word��ÿ���ַ����������ˣ�ֱ�ӷ���true
if (index == word.length - 1)
    return true;
//�ѵ�ǰ�����ֵ����������Ϊ�������ԭ
char tmp = board[i][j];
//Ȼ���޸ĵ�ǰ�����ֵ
board[i][j] = '.';
//�ߵݹ飬���ŵ�ǰ�������������4���������
boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
        dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
//�ݹ�֮���ٰѵ�ǰ�����긴ԭ
board[i][j] = tmp;
return res;
}*/