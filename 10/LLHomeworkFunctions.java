import java.util.ArrayList;

public class LLHomeworkFunctions {

	public static void main(String [] args) {
        // TODO: Part of this assignment is to implement this correctly.
	}

	/*
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return true if the lists are equal.  Assume both lists terminate.
	 */

	//the big O for this is n
    public static <T> boolean equalLists(ListNode<T> list1, ListNode<T> list2) {
		// TODO: Part of this assignment is to implement this correctly.
    if(list1 == null || list2 == null){
      if(list1 == null && list2 == null){
        return true;
      }
      return false;
    }

		if(list1.value.equals(list2.value)){
			//null is for address, so use '==' instead of equals
			equalLists(list1.next, list2.next);
		}else return false;

	}


	/*
	 * @param <T>
	 * @param list1
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */

	//the big O for this is n^2
	ArrayList<T> values = new ArrayList<T>();
	public static <T> boolean terminates(ListNode<T> list) {
    // TODO: Part of this assignment is to implement this correctly.

    // code below is never going to end, forget it
   	//  if(list == null){
   	//  	return true;
    // }else{
    // 	terminates(list.next);
    // }

    //well, checking value
    if(list == null) return true;

    if(values.size() > 0){
      for(T t: values){
      	if(t.equals(list.value){
      		return false;
      	}
      }
    }
  	values.add(list.value);
  	terminates(list.next);

	}
}
