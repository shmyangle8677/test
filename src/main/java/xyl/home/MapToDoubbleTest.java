package xyl.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MapToDoubbleTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        Optional<Integer> optional = list.stream().reduce((x, y)-> {
            if(y%2!=0){
                System.out.println(y);
                x += y;
            }
            return  x;
        });
        System.out.println(optional.get());
    }
}
