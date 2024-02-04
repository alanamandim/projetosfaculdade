// Arquivo: uart.h
// Autor: Arliones Hoeller, IFSC-SJE

#ifndef __UART_H__
#define __UART_H__
#include "fifo_linear.h"
class UART
{
private:
    struct UART_Registers_t
    {
        unsigned char ucsra;
        unsigned char ucsrb;
        unsigned char ucsrc;
        unsigned char reserved;
        unsigned char ubrrl;
        unsigned char ubrrh;
        unsigned char udr;
    };
    static UART_Registers_t *regs;
    //utilize uma FIFO de saída tx e outra de entrada rx no componente UART
    static FIFO_LINEAR<unsigned char,32>Rx_fifo;
    static FIFO_LINEAR<unsigned char,32>Tx_fifo;
    
public:
    enum UART_Baudrate_t
    {
        UART_9600 = 103,
        UART_14400 = 68,
        UART_19200 = 51
    };

    UART(UART_Baudrate_t baud = UART_9600, int db = 8, int pr = 0, int sb = 1)
    {
        // regs = (UART_Registers_t*) 0xc0;
        regs->ubrrh = (unsigned char)((baud >> 8) & 0x0f);// shift the register right by 8 bits
        regs->ubrrl = (unsigned char)  (baud & 0x00ff); //set baud rate
        // // regs->ucsra = 0;
        regs->ucsrb =   (1 << 4) | (1 << 3);//|(1 << 7) //4 rx 3 tx enable receiver and transmitter
        regs->ucsrc = (3 << 1); // data em 8bits
    }

    void put(char c) //function to send data
    {
        
        //desativa a interrepução global
        __asm__("cli");
               //enfilerar
        if(Tx_fifo.enqueue(c)!=FIFO_LINEAR<unsigned char,32>::FIFO_ERROR_FULL)
            
        //ativa a interrupção global
        __asm__("sei");
            //ativa interrupção da uart ucsrb (1<<5)
        regs->ucsrb |= (1<<5);
        
    }
    

    void puts(char *s)
    {
        puts((const char *)s);
    }
    void puts(const char * s)
    {
        while(*s != '\0')//varre 
            put(*s++);
    }

    char get() //function to receive data
    {
        unsigned char x;
        while(Rx_fifo.dequeue(&x) !=FIFO_LINEAR<unsigned char,32>::FIFO_SUCCESS);
        return x;

    }

    static void uart_RX_handlers()
    {
        __asm__("cli");
        //pegar o dado do registrador e enfileirar
        Rx_fifo.enqueue(regs->udr);
        __asm__("sei");

    }

    static void uart_udre_handlers()
    {
        // desinfilera e e salva no registrador
        unsigned char info;
        if(Tx_fifo.dequeue(&info)!=FIFO_LINEAR<unsigned char,32>::FIFO_ERROR_EMPTY)
            regs->udr = info;
            //desabilita a interrupção da uart
        else regs->ucsrb &= ~(1 << 5 ) ;
    }
    

};

#endif