
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class Board {
    int maze[][];
    int rows;
    int cols;
    Point src;
    Point dest;
    Vector<Point> path;
    public Board(int [][] matrix,int r,int c, Point src, Point dest)
    {
        path = new Vector<>();
        this.rows=r;
        this.cols=c;
        maze = new int[r][c];
        this.src = new Point(src.x,src.y);
        this.dest = new Point(dest.x,dest.y);
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
               maze[i][j]= matrix[i][j];
            }
        }
    }
    public boolean isPassed(Point p)
    {
        int size = path.size();
        for(int i=0;i<size;i++)
        {
            Point q = path.elementAt(i);
            if(p.x==q.x && p.y==q.y)
            {
                return true;
            }
        }
        return false;
    }
    public boolean isValidMove(int i, int j)
    {
	if((i >= 0) && (i <this.rows) && (j >= 0) && (j < this.cols))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int BFS()
    {
        int rowDirection[] = {1, 0, 0, -1};
        int colDirection[] = {0, 1, -1, 0};

	// check source and destination cell
	// of the mazerix have value 1
	if (maze[src.x][src.y] != 1 || maze[dest.x][dest.y] != 1)
        {
            return -1;
        }
	boolean [][] visited = new boolean[rows][cols];
	visited[src.x][src.y] = true;
        
	Queue<Node> q = new LinkedList<>();
	Node s = new Node(src, 0);
	q.add(s); // Enqueue source cell
	// Do a BFS starting from source cell
	while (!q.isEmpty())
	{
		Node curr = q.peek();
		Point p = curr.p;
                if (p.x == dest.x && p.y == dest.y)
                {         
                    if(isPassed(new Point(p.x,p.y))==false)
                    {
                         path.add(new Point(p.x,p.y));//save path
                    }
                    return curr.distance;
                }
		q.remove();
		for (int i = 0; i < 4; i++)
		{
			int row = p.x + rowDirection[i];
			int col = p.y + colDirection[i];
	
			if (isValidMove(row, col)==true && maze[row][col] == 1 && visited[row][col]==false)
			{
				visited[row][col] = true;
                                if(isPassed(new Point(p.x,p.y))==false)
                                {
                                    path.add(new Point(p.x,p.y));//save path
                                }
				Node Adjcell = new Node	(new Point(row, col),curr.distance + 1 );
                                q.add(Adjcell);
			}
		}
	}
	return -1;
    }
    public void displayPath()
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(src.equals(new Point(i,j))==true || dest.equals(new Point(i,j))==true)
                {
                    System.out.print(1+"\t");
                }
                else if(isPassed(new Point(i,j))==true)
                {
                    System.out.print(1+"\t");
                }
                else
                {
                        System.out.print(0+"\t");
                }
            }
            System.out.println("");
        }
    }
}
