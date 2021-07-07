import java.util.*;

public class NonConstructibleChange {

  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < coins.length; index++){
				intList.add(coins[index]);
		}
		ArrayList<Integer> changeCombinations = new ArrayList<>();
    List<List<Integer>> list = new Program().getAllCombinations(intList);
    for (List<Integer> arr : list) {
        changeCombinations.add(consolidateArray(arr));
    }
		changeCombinations = duplicateRemover(changeCombinations);
		Collections.sort(changeCombinations);  
		Integer counter = 1;
		while(counter - 1 < changeCombinations.size() && counter.equals(changeCombinations.get(counter - 1))){
			counter++;
		}
		if(counter.equals(changeCombinations.size()) && coins.length != 1){
			return counter + 1;
		}
    return counter;
  }
	public List<List<Integer>> getAllCombinations(List<Integer> elements) {
    List<List<Integer>> combinationList = new ArrayList<List<Integer>>();
    for(long i = 1; i < Math.pow(2, elements.size()); i++){
      List<Integer> list = new ArrayList<Integer>();
      for(int j = 0; j < elements.size(); j++){
      	if((i & (long)Math.pow(2, j)) > 0){
					Integer temp = elements.get(j);
						list.add(temp);
        }
      }
    	combinationList.add(list);
    }
    return combinationList;
	}
	public int consolidateArray(List<Integer> a){
		int answer = 0;	
		for(int i = 0; i < a.size(); i++){
			answer += a.get(i);
		}
		return answer;
	}
	public ArrayList<Integer> duplicateRemover(ArrayList<Integer> list){
		ArrayList<Integer> newList = new ArrayList<Integer>();
      for (Integer element : list) {
          if (!newList.contains(element)) {
              newList.add(element);
          }
      }
    return newList;
	}
  public static void main(String[] args){
    /*
     added to make the code actually functional!
     this line will return the smallest number where the amount of change
     cannot be created!
    */
    System.out.println(nonConstructibleChange(new int[] {1,3,5,7}));
  }
}

