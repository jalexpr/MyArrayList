
package myarraylist;

public class TestMyArrayList {
    
    public static void main(String[] args) {
        
        MyArrayList myArr = new MyArrayList();
        
        for(int i = 0; i < 10; i++){
            myArr.add("значение " + (i + 1));
        }
        
        printMyArrayList(myArr);    
                
        MyArrayList myArr2 = new MyArrayList(1);
        
        for(int i = 0; i < 10; i++){
            myArr2.add("значение " + (i + 1));
        }
        
        printMyArrayList(myArr2); 
        
        System.out.println("get(9) -> " +myArr2.get(9));
        //System.out.println("get(11 -> " +myArr2.get(11));
        //System.out.println("get(-3) -> " +myArr2.get(-3));
        printMyArrayList(myArr2);
        
        printMyArrayList(myArr2);
        System.out.println("indexOf(\"значение 6\") -> " +myArr2.indexOf("значение 6"));
        System.out.println("indexOf(\"Что-то не то\") -> " +myArr2.indexOf("Что-то не то"));
        
        System.out.println("myArr2.remove(9) - > " + myArr2.remove(9));
        //System.out.println("myArr2.remove(11) - > " +myArr2.remove(11));
        //System.out.println("myArr2.remove(-2) - > " +myArr2.remove(-2));
        printMyArrayList(myArr2);
        
        //printMyArrayList(myArr2);
        
        myArr2.set(1, "Новое значение");
        //myArr2.set(12, "Новое значение");
        //myArr2.set(-2, "Новое значение");
        printMyArrayList(myArr2);
        
        
    }
    
    public static void printMyArrayList(MyArrayList list){
        System.out.println(list.toString() + ":\nsize = " + list.getSize());
        for(String str : list){
            System.out.println(str);
        }
        System.out.println("");
    }
}
