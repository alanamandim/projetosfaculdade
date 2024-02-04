#ifndef __ALARM_H__
#define __ALARM_H__

#include "observer.h"
#include "FQueue.h"
#include "LinkedList.h"
#include "defs.h"

class Alarm : public Observer
{
    public:
        Alarm(FunctionQueue * _fqueue)
                : fqueue(_fqueue)
        {

        }
        virtual ~Alarm() {}

        void schedule(Event *ev) 
        {
            __asm__("cli");

            //FIFO
            #if SCHED_TYPE == SCHED_FIFO
            events.insert(ev, ev->time);

            //RMS
            #elif SCHED_TYPE == SCHED_RMS
             Microseconds t = ev->time - (Timer0::micros() - ev->release_time);
             events.insert(ev, t);

            //EDD  dead line - release_time
            #elif SCHED_TYPE ==SCHED_EDD
            Microseconds t = ev->time -(Timer0::micros()- ev->release_time);
            events.insert(ev,ev->release_time + ev->time);

            #endif
            __asm__("sei");

        }

        virtual void update(int val)
        {
            if(events.size()==0) return;
            Microseconds rank = events.update_head_rank(val);
            if(rank ==0)
            {
                Event *ev = events.remove_head();
                ev->release_time = Timer0::micros();
                //FIFO
                #if SCHED_TYPE == SCHED_FIFO
                fqueue->enqueue(ev);
      
                //RMS
                #elif SCHED_TYPE == SCHED_RMS
                fqueue->insert(ev,ev->priority);

                //EDD
                #elif SCHED_TYPE ==SCHED_EDD
                fqueue->insert(ev,ev->release_time+ev->time);

                #endif

                rank = events.update_head_rank(0);
            }        
        }
    private:
        FunctionQueue *fqueue;
        LinkedList<Event*,true,true,Microseconds> events;
};
#endif