import java.util.*;
public class main {

	
	public static void main(String[] args) {
		node a = new node(0,0);
		node b = new node(1,0);
		node c = new node(2,0);
		node d = new node(3,0);
		node e = new node(4,0);
		node f = new node(5,0);
		ArrayList<node> liste1 = new ArrayList<node>();
		ArrayList<node> liste2 = new ArrayList<node>();
		ArrayList<node> liste3 = new ArrayList<node>();
		liste1.add(a);
		liste1.add(b);
		liste1.add(c);
		liste1.add(d);
		liste1.add(e);
		liste1.add(f);
		liste3.addAll(liste1);
		tsp t = new tsp(liste1);
		TreeMap<Double,ArrayList<node>> map = new TreeMap<Double,ArrayList<node>>();
		ArrayList<node> random_nodes1 = new ArrayList<node>();
		ArrayList<node> random_nodes = new ArrayList<node>();
		Random rand = new Random();
		for (int i=0;i<10;i++) {
			double x = rand.nextDouble()*10;
			double y = rand.nextDouble()*10;
			node n = new node(x,y);
			n.setID(i);
			random_nodes.add(n);
			random_nodes1.add(n);
		}
		 double[][] distances = new double[10][10];
		    for (int i=0;i<distances.length;i++) {
		    	for (int j=0;j<distances[0].length;j++) {
		    		if(i==j) {
		    			distances[i][j] = 0;
		    		}
		    		else {
		    			double distance = random_nodes.get(i).distance(random_nodes.get(j));
		    			distances[i][j] = distance;
		    		}
		    	}
		    }
		    int[] nodeList = new int[10];
		    for(int i=0;i<nodeList.length;i++) {
		        nodeList[i] = random_nodes.get(i).id;
		    }
		
		//printArraylist(candidateRoutes(nodeList),distances);
		double startTime = System.nanoTime();
		for (int i=0;i<random_nodes1.size();i++) {
			map.putAll(t.calculate(random_nodes1.get(i), random_nodes));
			random_nodes.clear();
			random_nodes.addAll(random_nodes1);
		}
		/*for (int i=0;i<liste3.size();i++) {
			map.putAll(t.calculate(liste3.get(i), liste1));
			liste1.clear();
			liste1.addAll(liste3);
		}*/
		
		double endTime = System.nanoTime();
	    System.out.println("Execution time:"+(endTime-startTime)/1000000000);
		liste2.addAll(map.get(map.firstKey()));
		for (int i=0;i<liste2.size();i++) {
			System.out.println(liste2.get(i).id);
		}
		System.out.println("distance: " + map.firstKey());
	}
	  public static ArrayList<int[]> candidateRoutes (int[] nodeList){
	        int[] tabuList = new int[0];
	        int[] candidateList = nodeList;
	        ArrayList<int[]> sol = new ArrayList<>();
	        ArrayList<int[]> solution = giveSubarray(tabuList, candidateList, sol);
	        return solution;
	        }

	    public static ArrayList<int[]> giveSubarray (int[] tabuList, int[] candidateList, ArrayList<int[]> solutionList){
	        if (candidateList.length == 1){
	            int[] tempTabu = add(tabuList, candidateList[0]);
	            solutionList.add(tempTabu);
	        }
	        else{
	            for(int i=0;i<candidateList.length;i++){
	                int[] tempTabu = add(tabuList, candidateList[i]);
	                int[] tempCandidate = remove(candidateList, i);
	                solutionList = giveSubarray(tempTabu, tempCandidate, solutionList);

	            }
	        }
	        return solutionList;
	    }

	    public static int[] add (int[] vector, int element){
	        int[] dummy = new int[vector.length+1];
	        for (int i=0;i<dummy.length;i++){
	            if (i != vector.length){
	                dummy[i] = vector[i];
	            }
	            else{
	                dummy[i] = element;
	            }
	        }
	        return dummy;
	    }

	    public static int[] remove(int[] arr, int index) {
	        if (arr == null || index < 0 || index >= arr.length) {
	            return arr;
	        }
	        int[] anotherArray = new int[arr.length - 1];
	        for (int i = 0, k = 0; i < arr.length; i++) {
	            if (i == index) {
	                continue;
	            }
	            anotherArray[k++] = arr[i];
	        }
	        return anotherArray;
	    }

	    public static void printArraylist (ArrayList<int[]> aList,double[][] distances) {
	    	TreeMap<Double, int[]> map = new TreeMap<Double,int[]>();
	        for(int[] anIntArray:aList) {
	        	
	            //iterate the retrieved array an print the individual elements
	        	double a = 0;
	            for (int aNumber : anIntArray) {
	            	if(aNumber < anIntArray.length-1) {
	            		a+=distances[anIntArray[aNumber]][anIntArray[aNumber+1]];
	            	}
	                System.out.print(aNumber+",");
	               
	            }
	            map.put(a,anIntArray);
	            System.out.println();
	        }
	        System.out.println(map.firstKey()+" shortest distance");
	        int[] arr = map.get(map.firstKey()).clone();
	        for (int i=0;i<map.get(map.firstKey()).length;i++) {
	        	System.out.print(arr[i]+",");
	        }
	    }
	
	
}
