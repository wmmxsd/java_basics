package Keyword.staticDemo;

import java.util.ArrayList;
import java.util.List;

public class EmpTestDemo {
    public static void main(String[] args) {
        //初始化20个员工实例：
        List<EmpTest> empList = new ArrayList<>();
        for(int i=0;i<20;i++){
            empList.add(EmpTest.newBuilder().empLevel(5).empNo("Emp_"+i).id(i).mapingOrderLevel("1").orderNumLimit(20).build());
        }
    }
}
