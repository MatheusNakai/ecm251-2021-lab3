package br.maua;

public class V1 {
    int v[] = {2, 3, 1, 4, 2, 5, 3, 8, 2, 3};




    int mv1() {
        int s = 0;
        for (int i = 0; i < v.length; i += 2) {
            s += v[i];
        }
        return s;
    }

    float mv2(int x){
        return x+this.mv1();
    }
    float mv2(float x){
        return 3+x*this.mv1();
    }

}
