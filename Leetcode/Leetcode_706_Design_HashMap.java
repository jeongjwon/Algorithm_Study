import java.util.HashMap;

class MyHashMap {
    HashMap<Integer, Integer> map = new HashMap<>();

    public MyHashMap() {   
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
    
    public int get(int key) {
        return map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void remove(int key) {
        map.remove(key);
    }
}
public class Leetcode_706_Design_HashMap {
    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1,1); //[1,1]
        myHashMap.put(2, 2); //[1,1],[2,2]

        myHashMap.get(1); //1
        myHashMap.get(3); //x

        myHashMap.put(2, 1); //[1,1],[2,1] => 새로운 값으로 대치
        myHashMap.get(2); //1
        myHashMap.remove(2); 
        myHashMap.get(2); // x
    }
}
