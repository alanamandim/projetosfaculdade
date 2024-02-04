// Arquivo: fifo.h
// Autor: Arliones Hoeller, IFSC-SJE

#ifndef __FIFO_H__
#define __FIFO_H__
#include <string.h>

template<typename T, int N>
class FIFO
{
public:

    FIFO()
    {
        fifo_init();
    }
    
    ~FIFO()
    {
    }
    void fifo_init()
    {
        memset(buffer,0,N);
        head = -1;
    }
    //armazene as 16 medições mais recentes (fifo com tamanho 16)
    void enqueue(T data)
    {
        head = ++head%N;
        buffer[head] = data;
        
    }

    T dequeue(int pos)
    {
        return buffer[pos];
    }

    T dequeue()
    {
        return buffer[head];
    }

    void clear()
    {
        head = -1;
    }


private:
    T buffer[N];
    unsigned int  head;
};

#endif