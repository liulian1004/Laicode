/**
 * class Building {
 *   public int start;
 *   public int end;
 *   public int height;
 *   public Building(int start, int end, int height) {
 *     this.start = start;
 *     this.end = end;
 *     this.height = height;
 *   }
 * }
 */
public class Solution {
  public int totalArea(List<Building> buildings) {
    //T: nlogn
    // total sum - overlapped sum
    if(buildings.size() == 0){
      return 0;
    }
    int sum = 0;
    for(Building b: buildings){
      sum += (b.end - b.start)*b.height;
    }
    Collections.sort(buildings, new MyCompare());
    Building cur = buildings.get(0);
    for(int i = 1; i < buildings.size(); i++){
      Building temp = buildings.get(i);
      //calcualte the overlap sum
      if(temp.start < cur.end){
        //这里temp的end 可能在cur end之后，或者之后，所以要算距离离start最近的，即min end
        sum -=Math.min(temp.height, cur.height)*(Math.min(cur.end, temp.end)-temp.start);
      }
      //update cur building
      if(temp.end > cur.end){
           cur = temp;
      }

    }
    return sum;
  }
  private class MyCompare implements Comparator<Building> {
    @Override
    public int compare(Building b1, Building b2){
      if(b1.start == b2.start && b1.end == b2.end){
        return 0;
      }
      if(b1.start < b2.start || b1.start == b2.start && b1.end < b2.end){
        return -1;
      }
      return 1;
    }
  }
}
