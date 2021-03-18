package Nakai.company;

public class ValidadorCPF {
    private static String[] invalidosConhecidos ={
            "00000000000","11111111111", "22222222222",
            "33333333333", "44444444444", "55555555555",
            "66666666666", "77777777777", "88888888888", "99999999999"
};
    private static final int[]multiplicadoresPrimeiroDigito={
            10,9,8,7,6,5,4,3,2
    };
    private static final int[] multiplicadoresSegundoDigito={
        11,10,9,8,7,6,5,4,3,2
    };
    private static final int Tamanho_CPF =11;

    public static boolean validarCPF(String cpf){
        cpf=cpf.replace(".","");
        cpf=cpf.replace("-","");
        if(cpf.length()!=Tamanho_CPF)
            return false;

        //Verifica se o cpfesta dentro dos invalidos conhecidos
        for(String cpfInvalidos:invalidosConhecidos) {
            if (cpfInvalidos.equals(cpf))
                return false;
        }

        //Validacao do primeiro e do segundo digito
        if (validarDigito(multiplicadoresPrimeiroDigito,cpf)&& validarDigito(multiplicadoresSegundoDigito,cpf));
            return true;

    }
    private static boolean validarDigito(int[]multiplicadores,String cpf){
        int somatoria=0;
        for (int i = 0; i < multiplicadores.length; i++) {
            somatoria+=multiplicadores[i]*Integer.parseInt(""+cpf.charAt(i));

        }
        return (""+((somatoria*10)%11)%10).equals(""+cpf.charAt(multiplicadores.length));
    }
}