package br.maua;

public class V2 extends V1{
    int mv1(){
        int s=0;
        for(int i=1;i<v.length;i+=2){
            s+=v[i];
        }
        return s;
    }
    float mv2(float x){
        return 3+x*this.mv1();
    }
}
