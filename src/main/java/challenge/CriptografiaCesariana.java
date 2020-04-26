package challenge;

public class CriptografiaCesariana implements Criptografia {
    final byte CASAS = 3;

    @Override
    public String criptografar(String texto) {
        return gerarTextoProcessado(texto, "criptografar", CASAS);
    }
    @Override
    public String descriptografar(String texto) {
        return gerarTextoProcessado(texto, "decriptografar", CASAS);
    }
    private String gerarTextoProcessado(String texto, String operacao, int casas){
        if (texto.isEmpty()){
            throw new IllegalArgumentException("Texto em branco não são permitidos");
        }

        String finalText = new String();
        int letra;
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++){
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z'){
                letra = (operacao.equals("criptografar")) ? texto.charAt(i) + casas : texto.charAt(i) - casas;
                if ((char) letra <'a'){
                    letra = letra + 26 + casas;
                }else if((char) letra > 'z'){
                    letra = letra - 26 - casas;
                }
            }else{
                letra = texto.charAt(i);
            }
            finalText = finalText.concat(String.valueOf((char) letra));
        }

        return finalText;
    }
}
