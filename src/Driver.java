/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class Driver {
    public static void main(String[] args) {
            
    int [][] mat = {
                {1,1,1,1,1},
                {1,0,1,0,1},
                {2,2,2,0,1},
                {0,1,1,1,1},
                {2,2,2,0,1}
        };
	Point source = new Point(0, 0);
	Point dest = new Point(4, 4);
        Board b = new Board(mat,5,5, source, dest);
	if(b.BFS()==-1)
        {
            System.out.println("Path not found");
        }
        else
        {
            b.displayPath();
        }
    }
    
}
