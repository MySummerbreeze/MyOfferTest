package com.zzy.test12Backtracking;

/**
 * 回溯法解决：矩阵中的路径
 * 		回溯法通常使用递归实现
 * 		特点：当我们在某一步选择了其中一个选项时，就进入下一步，然后又面临新的选项，我们就这样重复选择，直到到达最终状态。
 * @author user
 *
 *	对于现在来说只能背：
 *		两个函数：
 *			第一个函数遍历每一个字符，并调用dfs函数
 *			第二个函数dfs函数：
 *				首先判断是否出界，或是现字符与当前字符不相等，若是则返回false
 *				第二：判断是否已经找到所有的字符，条件是length-1是否等于当前index，在上边的判断中，已经进行过是否相等的判断
 *				将该数存放在一个char变量中，因为遍历过的字符需要记录，其次将当前字符设置为一个特殊字符
 *				接下来：
 *				boolean res = 
 *				dfs(row+1,col,word,index+1,board)||
 *				dfs(row-1,col,word,index+1,board)||
				dfs(row,col+1,word,index+1,board)||
				dfs(row,col-1,word,index+1,board);
				最后将原字符还给board
				返回true
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
		//找到第一个char
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
        //从[i,j]这个坐标开始查找
        if (dfs(board, words, i, j, 0))
            return true;
    }
}
return false;
}

static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
//边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
//如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
    return false;
//如果word的每个字符都查找完了，直接返回true
if (index == word.length - 1)
    return true;
//把当前坐标的值保存下来，为了在最后复原
char tmp = board[i][j];
//然后修改当前坐标的值
board[i][j] = '.';
//走递归，沿着当前坐标的上下左右4个方向查找
boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
        dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
//递归之后再把当前的坐标复原
board[i][j] = tmp;
return res;
}*/