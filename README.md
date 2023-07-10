# trabalho-seg-comp
Trabalho de segurança computacional - 2023-1

#RSA PASSO A PASSO

- Gere chaves RSA:
     1.Escolha dois números primos grandes, p e q.
     
     2.Calcule o produto n = p * q, que será o módulo para as operações de criptografia e descriptografia.
     
     3.Calcule a função totiente de Euler φ(n) = (p - 1) * (q - 1).
     
     4.Escolha um número inteiro e relativamente primo a φ(n), chamado de e, para ser a chave pública de criptografia.
     
     5.Calcule o inverso multiplicativo de e módulo φ(n), chamado de d, para ser a chave privada de descriptografia.
     

  - Implemente as funções de criptografia e descriptografia RSA:
     1.A função de criptografia recebe a mensagem original como entrada e retorna a mensagem criptografada.
     
     2.A mensagem criptografada é calculada elevando a mensagem original à potência e módulo n.
     
     3.A função de descriptografia recebe a mensagem criptografada como entrada e retorna a mensagem original.
     
     4.A mensagem original é calculada elevando a mensagem criptografada à potência d módulo n.


- Implemente as funções de assinatura e verificação RSA:
     1.A função de assinatura recebe a mensagem original e a chave privada como entrada e retorna a assinatura.
     
     2.A assinatura é calculada elevando a mensagem original à potência d módulo n.
     
     3.A função de verificação recebe a mensagem original, a assinatura e a chave pública como entrada e retorna um valor booleano indicando se a assinatura é válida.
     
     4.Para verificar a assinatura, a mensagem original é calculada elevando a assinatura à potência e módulo n e comparando o resultado com a mensagem original.
     

  - Implemente funções auxiliares:
     1.Função para converter uma string em um número inteiro para a mensagem original.
     
     2.Função para converter um número inteiro em uma string para a mensagem original.
     

 - Teste sua implementação:
    1.Gere um par de chaves RSA.

    2.Criptografe e descriptografe uma mensagem para verificar se a implementação funciona corretamente.
     
    3.Assine uma mensagem com a chave privada e verifique a assinatura usando a chave pública.
     
