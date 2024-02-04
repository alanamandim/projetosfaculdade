#include "uart.h"

UART::UART_Registers_t * UART::regs = (UART_Registers_t *) 0xc0;
FIFO_LINEAR<unsigned char,32> UART::Rx_fifo;
FIFO_LINEAR<unsigned char,32> UART::Tx_fifo;

extern "C"
{
    void __vector_18() __attribute__ ((signal));
    void __vector_19() __attribute__ ((signal));
   
}

void __vector_18()
{
    // chamar o handler do INT0
    UART::uart_RX_handlers();
}

void __vector_19()
{
    // chamar o handler do INT0
    UART::uart_udre_handlers();
}