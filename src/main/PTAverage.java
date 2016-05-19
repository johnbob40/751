package main;//####[1]####
//####[1]####
import java.util.Collection;//####[3]####
import pu.RedLib.Reduction;//####[4]####
import pt.runtime.TaskIDGroup;//####[5]####
//####[5]####
//-- ParaTask related imports//####[5]####
import pt.runtime.*;//####[5]####
import java.util.concurrent.ExecutionException;//####[5]####
import java.util.concurrent.locks.*;//####[5]####
import java.lang.reflect.*;//####[5]####
import pt.runtime.GuiThread;//####[5]####
import java.util.concurrent.BlockingQueue;//####[5]####
import java.util.ArrayList;//####[5]####
import java.util.List;//####[5]####
//####[5]####
public class PTAverage {//####[7]####
    static{ParaTask.init();}//####[7]####
    /*  ParaTask helper method to access private/protected slots *///####[7]####
    public void __pt__accessPrivateSlot(Method m, Object instance, TaskID arg, Object interResult ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {//####[7]####
        if (m.getParameterTypes().length == 0)//####[7]####
            m.invoke(instance);//####[7]####
        else if ((m.getParameterTypes().length == 1))//####[7]####
            m.invoke(instance, arg);//####[7]####
        else //####[7]####
            m.invoke(instance, arg, interResult);//####[7]####
    }//####[7]####
//####[8]####
    public static double average(Collection<Double> elements) {//####[8]####
        double sum = 0;//####[9]####
        int myPos = ParaTask.getLowerBoundThreshold();//####[10]####
        for (Double d : elements) //####[14]####
        {//####[14]####
            sum += d;//####[15]####
        }//####[16]####
        return myPos;//####[17]####
    }//####[18]####
//####[22]####
    public static void compute() throws ExecutionException, InterruptedException {//####[22]####
        Collection<Double> elements = Data.generate(30000000);//####[23]####
        long startTime = System.currentTimeMillis();//####[24]####
        double x = 0;//####[25]####
        for (Double d : elements) //####[26]####
        {//####[26]####
            x += d;//####[27]####
        }//####[29]####
        long endTime = System.currentTimeMillis();//####[31]####
        long duration = (endTime - startTime);//####[33]####
        System.out.println(duration);//####[34]####
        System.out.println(x);//####[35]####
        startTime = System.currentTimeMillis();//####[37]####
        endTime = System.currentTimeMillis();//####[42]####
        duration = (endTime - startTime);//####[43]####
        System.out.println(duration);//####[44]####
    }//####[46]####
}//####[46]####
