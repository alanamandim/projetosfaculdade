// Arquivo: adc.h
// Autor: Arliones Hoeller, IFSC-SJE

#ifndef __ADC_H__
#define __ADC_H__
#include "fifo.h"

class ADC
{
public:
    enum ADC_Channel_t
    {
        ADC_CH0 = 0,
        ADC_CH1,
        ADC_CH2,
        ADC_CH3,
        ADC_CH4,
        ADC_CH5,
        ADC_CH6,
        ADC_CH7,
        ADC_CH8,
        ADC_1V1 = 14,
        ADC_0V
    };

    ADC(ADC_Channel_t ch) : channel(ch)
    {
        set_channel();
        regs->adcsra = (1 << 7) | 7 | (1 << 5) | (1 << 3)| (1<<6); //ativando ADATE,ADIE, ADEN e ADPS em (111)
        regs->adcsrb = 0;//selecionando a fonte do auto triger
    }

    int get(int pos)
    {
        //ler dado da fifo
        return Myfifo.dequeue(pos);
    }


    static void adc_handlers(){
        //utilize uma fila circular para a entrada de dados do ADC
        Myfifo.enqueue(regs->adc);

    }

private:
    struct ADC_Registers_t
    {
        volatile unsigned int adc;
        volatile unsigned char adcsra;
        volatile unsigned char adcsrb;
        volatile unsigned char admux;
    };
    static ADC_Registers_t * regs;
    static FIFO<int,16>Myfifo;

    void set_channel()
    {
        regs->admux = (1 << 6) | (channel & 0x0f);
    }
    
    ADC_Channel_t channel;
};

#endif
