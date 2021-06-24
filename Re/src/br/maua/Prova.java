package br.maua;

public class Prova {
    public static void main(String[] args) {
        int valor = calcula(new int[]{6,8,9,2},new int[]{6,2,4});
        System.out.println(valor);
    }
    public static int calcula(int[] v1, int[ ]v2){
        int t;
        if(v1.length>v2.length){
            t=v1.length;
        }else{
            t=v2.length;
        }
        int r=0;
        for (int i=0;i<t;i++){
            r+=v1[i]*v2[i];
        }

        return r;
    }
}
