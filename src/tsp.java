import java.util.*;

public class tsp {
ArrayList<node> nodeList;
double[][] nodeMap;
public tsp(ArrayList<node> liste) {
	this.nodeList=liste;
	this.nodeMap = new double[this.nodeList.size()][this.nodeList.size()];
}
public TreeMap<Double,ArrayList<node>> calculate(node source,ArrayList<node> liste) {
	TreeMap<Double,ArrayList<node>> map = new TreeMap<Double,ArrayList<node>>();
	
	if(liste.size()>1) {
		liste.remove(source);
		for (int i=0;i<liste.size();i++) {
			ArrayList<node> liste3 = new ArrayList<node>();
			liste3.addAll(liste);
			double a = source.distance(liste3.get(i));
			TreeMap<Double,ArrayList<node>> map2 = new TreeMap<Double,ArrayList<node>>();
			map2.putAll(this.calculate(liste3.get(i),liste3));
			a+=map2.firstKey();
			ArrayList<node> liste1 = new ArrayList<node>();
			liste1.add(source);
			liste1.addAll(map2.get(map2.firstKey()));
			map.put(a, liste1);
		}
		
		TreeMap<Double,ArrayList<node>> map1 = new TreeMap<Double,ArrayList<node>>();
		map1.put(map.firstKey(), map.get(map.firstKey()));
		return map1;
		
		
	}
	else {
		double a =0;
		ArrayList<node> liste1 = new ArrayList<node>();
		liste1.add(source);
		map.put(a, liste1);
		return map;
	}
	
}
}