/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahsan Riaz
 */
public class Point {
    int x;
    int y;
    Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    boolean isSame(Point p)
    {
        if(p.x==this.x && p.y==this.y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
