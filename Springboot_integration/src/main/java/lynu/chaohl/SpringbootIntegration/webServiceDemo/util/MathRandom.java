/**
 * @author:chaohl
 * @date:2021/1/29
 * @Description 数学相关随机数据处理
 */
package lynu.chaohl.SpringbootIntegration.webServiceDemo.util;

import java.util.HashSet;
import java.util.Set;

public class MathRandom {

    /*
     * @param max：随机数上限
     * @param min：随机数下限
     * @Author chaohl
     * @Description  获得范围随机整数
     * @Date 15:40 2021/1/29
     * @return int
     **/
    public static int getIntRandom(int max,int min){
        return (int)(Math.random()*(max-min+1)+min);
    }
    public static Double getDoubleRandom(double max,double min){
        return (Math.random()*(max-min+1)+min);
    }


    /*
     *
     * @param max：随机数上限
     * @param min：随机数下限
     * @Author chaohl
     * @Description  获取不重复随机整数集合
     * @Date 15:48 2021/1/29
     * @return java.util.Set
     **/
    public static Set getNorepeatNum(int max, int min){

        Set numSets=new HashSet();
        for (int i=min;i<=max;i++){
            numSets.add(getIntRandom(max,min));
        }
        return numSets;
    }
}
