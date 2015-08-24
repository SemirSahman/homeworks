package ba.bitcamp.homeworkRekapitulacijaOOP;

public class ArrayManipulation {
/**
 * this method extend array for one index which is null
 * @param c array
 * @return a new extended array
 */
public static Computer[] extendArray(Computer[] c){

    Computer[] a = new Computer[c.length+1];

    for(int i = 0; i<c.length;i++){
        a[i] = c[i];
    }
    return a;
}
/**
 * this method shrinks array for index that you enter as parameter
 * @param c array
 * @param idx index of element we want to remove
 * @return a new shrinked array
 */
public static Computer[] shrinkArray(Computer[] c, int idx){
    int counter = 0;
    Computer[] a = new Computer[c.length-1];
    for(int i = 0;i<a.length;i++){
        if(counter == idx){
            counter++;
        }
        a[i]=c[counter];
        counter++;

    }
    return a;
}
}