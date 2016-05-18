//Pyjama compiler version:v1.5.3
package main;

import java.util.Collection;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;

import pj.pr.*;
import pj.PjRuntime;
import pj.Pyjama;
import pi.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;
import pj.pr.exceptions.OmpParallelRegionLocalCancellationException;

public class Average {

    public static void average() {{
        Collection<Double> elements = Data.generate(30000000);
        ParIterator<Double> pi = ParIteratorFactory.createParIterator(elements, 8);
        double sum = 0;
        System.out.println("start");
        long startTime = System.nanoTime();
        for (Double d : elements) {
            sum += d;
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println(duration);
        System.out.println(sum);
        sum = 0;
        startTime = System.nanoTime();
        /*OpenMP Parallel region (#0) -- START */
        InternalControlVariables icv_previous__OMP_ParallelRegion_0 = PjRuntime.getCurrentThreadICV();
        InternalControlVariables icv__OMP_ParallelRegion_0 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_0);
        int _threadNum__OMP_ParallelRegion_0 = icv__OMP_ParallelRegion_0.nthreads_var.get(icv__OMP_ParallelRegion_0.levels_var);
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();
        inputlist__OMP_ParallelRegion_0.put("sum",sum);
        inputlist__OMP_ParallelRegion_0.put("elements",elements);
        inputlist__OMP_ParallelRegion_0.put("pi",pi);
        _OMP_ParallelRegion_0 _OMP_ParallelRegion_0_in = new _OMP_ParallelRegion_0(_threadNum__OMP_ParallelRegion_0,icv__OMP_ParallelRegion_0,inputlist__OMP_ParallelRegion_0,outputlist__OMP_ParallelRegion_0);
        _OMP_ParallelRegion_0_in.runParallelCode();
        sum = (Double)outputlist__OMP_ParallelRegion_0.get("sum");
        elements = (Collection<Double>)outputlist__OMP_ParallelRegion_0.get("elements");
        pi = (ParIterator<Double>)outputlist__OMP_ParallelRegion_0.get("pi");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_0);
        RuntimeException OMP_ee_0 = (RuntimeException) _OMP_ParallelRegion_0_in.OMP_CurrentParallelRegionExceptionSlot.get();
        if (OMP_ee_0 != null) {throw OMP_ee_0;}
        /*OpenMP Parallel region (#0) -- END */

        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println(duration);
        System.out.println(sum);
    }
    }
        static class _OMP_ParallelRegion_0{
                private int OMP_threadNumber = 1;
                private InternalControlVariables icv;
                private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
                private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
                private ReentrantLock OMP_lock;
                private ParIterator<?> OMP__ParIteratorCreator;
                public AtomicReference<Throwable> OMP_CurrentParallelRegionExceptionSlot = new AtomicReference<Throwable>(null);

                //#BEGIN shared variables defined here
                double sum = 0.0d;
                Collection<Double> elements = null;
                ParIterator<Double> pi = null;
                //#END shared variables defined here
                public _OMP_ParallelRegion_0(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
                    this.icv = icv;
                    if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                        this.OMP_threadNumber = 1;
                    }else {
                        this.OMP_threadNumber = thread_num;
                    }
                    this.OMP_inputList = inputlist;
                    this.OMP_outputList = outputlist;
                    icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
                    icv.OMP_CurrentParallelRegionBarrier = new PjCyclicBarrier(this.OMP_threadNumber);
                    //#BEGIN shared variables initialised here
                    sum = (Double)OMP_inputList.get("sum");
                    elements = (Collection<Double>)OMP_inputList.get("elements");
                    pi = (ParIterator<Double>)OMP_inputList.get("pi");
                    //#END shared variables initialised here
                }

                private void updateOutputListForSharedVars() {
                    //BEGIN update outputlist
                    OMP_outputList.put("sum",sum);
                    OMP_outputList.put("elements",elements);
                    OMP_outputList.put("pi",pi);
                    //END update outputlist
                }
                class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
                    private int alias_id;
                    private ConcurrentHashMap<String, Object> OMP_inputList;
                    private ConcurrentHashMap<String, Object> OMP_outputList;
                    //#BEGIN private/firstprivate reduction variables defined here
                    //#END private/firstprivate reduction variables  defined here
                    MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                        this.alias_id = id;
                        this.OMP_inputList = inputlist;
                        this.OMP_outputList = outputlist;
                        //#BEGIN firstprivate reduction variables initialised here
                        //#END firstprivate reduction variables initialised here
                    }

                    @Override
                    public ConcurrentHashMap<String,Object> call() {
                        try {
                            /****User Code BEGIN***/
                            /*OpenMP Work Share region (#0) -- START */
                            
                {//#BEGIN firstprivate lastprivate reduction variables defined and initialized here
                    double OMP_WoRkShArInG_PRIVATE_0sum = sum;
                    //#set implicit barrier here, otherwise unexpected initial value happens
                    PjRuntime.setBarrier();
                    //#END firstprivate lastprivate reduction variables defined and initialized here
                    try{
                        int i=0;
                        int OMP_iterator = 0;
                        int OMP_end = (int)((elements.size())-(0))/(1);
                        if (((elements.size())-(0))%(1) == 0) {
                            OMP_end = OMP_end - 1;
                        }
                        int __omp_loop_thread_num = Pyjama.omp_get_thread_num();
                        int __omp_loop_num_threads = Pyjama.omp_get_num_threads();
                        for (OMP_iterator=__omp_loop_thread_num*8; OMP_iterator<=OMP_end && 8>0; OMP_iterator=OMP_iterator+__omp_loop_num_threads*8) {
                            for (int OMP_local_iterator = OMP_iterator; OMP_local_iterator<OMP_iterator+8 && OMP_local_iterator<=OMP_end; OMP_local_iterator++){
                                i = 0 + OMP_local_iterator * (1);
                                {
                                    OMP_WoRkShArInG_PRIVATE_0sum += pi.next();
                                }if (OMP_end == OMP_local_iterator) {
                                    //BEGIN lastprivate variables value set
                                    //END lastprivate variables value set
                                }
                            }
                        }
                    } catch (pj.pr.exceptions.OmpWorksharingLocalCancellationException wse){
                    } catch (Exception e){throw e;}
                    //BEGIN  reduction
                    PjRuntime.reductionLockForWorksharing.lock();
                    sum=sum+OMP_WoRkShArInG_PRIVATE_0sum;
                    PjRuntime.reductionLockForWorksharing.unlock();//END reduction
                    PjRuntime.setBarrier();
                }

                            PjRuntime.setBarrier();
                            PjRuntime.reset_OMP_orderCursor();
                            /*OpenMP Work Share region (#0) -- END */

                            /****User Code END***/
                            //BEGIN reduction procedure
                            //END reduction procedure
                            PjRuntime.setBarrier();
                        } catch (OmpParallelRegionLocalCancellationException e) {
                         	PjRuntime.decreaseBarrierCount();
                        } catch (Exception e) {
                            PjRuntime.decreaseBarrierCount();
                        	PjExecutor.cancelCurrentThreadGroup();
                        OMP_CurrentParallelRegionExceptionSlot.compareAndSet(null, e);
                    }
                    if (0 == this.alias_id) {
                        updateOutputListForSharedVars();
                    }
                    return null;
                }
            }
            public void runParallelCode() {
                for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                    Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                    PjRuntime.submit(i, slaveThread, icv);
                }
                Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
                PjRuntime.getCurrentThreadICV().currentThreadAliasID = 0;
                try {
                    masterThread.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



}
