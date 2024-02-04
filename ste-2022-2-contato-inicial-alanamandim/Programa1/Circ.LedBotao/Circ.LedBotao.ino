volatile int botao =0;
int led = 0;

enum State_t
{
  OFF = 0,
  E1 = 1,
  ON = 2,
  E2 = 3
};
State_t state = OFF;

void botao_isr(){
  static unsigned long ultima_interrupcao =0;
  static unsigned long tempo_botao = 50;
 
  unsigned long agora = millis();//tempo que o botao ta pressionado
  if((agora-ultima_interrupcao) >=tempo_botao){
    Serial.println("b");
    botao=1;
    ultima_interrupcao = agora;
  }
}

void setup(){
  pinMode(2,INPUT);
  pinMode(13,OUTPUT);
  Serial.begin(9600);
  attachInterrupt(digitalPinToInterrupt(2), botao_isr, RISING);
}
void loop(){
  noInterrupts();
  int b = botao;
  botao=0;
  interrupts();
  
  switch(state){
    case OFF:
      if(b==1){
          state =E1;
            Serial.println("E1");
          led=1;
            attachInterrupt(digitalPinToInterrupt(2), botao_isr, LOW);
      }
      break;
    case E1:
    if(b==1){
      state=ON;
      Serial.println("ON");
      led=1;
      attachInterrupt(digitalPinToInterrupt(2), botao_isr, RISING);  
    }else{
      led=1;
    }
    break;
    case ON:
      if(b==1){
          state=E2;
          Serial.println("E2");
          led=0;
          attachInterrupt(digitalPinToInterrupt(2), botao_isr, LOW);
        }else{
          led=1;
        }
      break;
    case E2:
    if(b==1){
      state=OFF;
      Serial.println("OFF");
      led=0;
      attachInterrupt(digitalPinToInterrupt(2), botao_isr, RISING);

    }else{
      led=0;
      break;
    }
  }
  digitalWrite(13,led);
  delay(50);
}
