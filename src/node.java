import java.util.ArrayList;
import java.util.*;
public class node {
public double x;
public double y;
public int id=0;
ArrayList<node> nodeList;
public node(double x,double y) {
	this.x=x;
	this.y=y;
}

public double distance(node n) {
	double xdistance = this.x-n.x;
	double ydistance = this.y-n.y;
	double total = xdistance*xdistance+ydistance*ydistance;
	double distance = Math.sqrt(total);
	return distance;
}
public void setID(int id) {
	this.id=id;
}
}
