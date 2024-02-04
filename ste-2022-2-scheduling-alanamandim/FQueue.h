#ifndef __FUNCTIONQUEUE_H__
#define __FUNCTIONQUEUE_H__

#include "fifo_linear.h"
#include "defs.h"
#include "LinkedList.h"
#include "timer.h"

struct Event
{
    
    Microseconds time;
    Microseconds release_time = Timer0::micros();
    void (*func)(void*);
    void * args;
    char priority;
};

#if SCHED_TYPE ==SCHED_FIFO
class FunctionQueue : public FIFO_LINEAR<Event, 16>
{
public:

    void run()
    {
        Event next;
        FIFO_Errors_t status = FIFO_ERROR_EMPTY;
        __asm__("cli");
        while (this->size() > 0)
        {
            status = this->dequeue(&next);
            __asm__("sei");
            if (status == FIFO_SUCCESS) next.func(next.args);
        }
        __asm__("sei");
    }

};

#elif SCHED_TYPE == SCHED_RMS
class FunctionQueue : public LinkedList<Event*,true,false,char> //ordenada, nao relativa , tipo do rank
{
public:
    void run()
    {
        Event *next;
        __asm__("cli");
        while(this->size()>0)
        {
            next = this->remove_head();
            __asm__("sei");
            next->func(next->args);
            __asm__("cli");
        }
        __asm__("sei");
    }

};

#elif SCHED_TYPE == SCHED_EDD
class FunctionQueue : public LinkedList<Event *,true,false,Microseconds>
{

public:
void run()
{
    Event *next;
     __asm__("cli");
    while(this->size()>0)
    {
        next = this->remove_head();
        __asm__("sei");
        next->func(next->args);
        __asm__("cli");
    }
    __asm__("sei");
}
};

#endif
#endif // __FUNCTIONQUEUE_H__