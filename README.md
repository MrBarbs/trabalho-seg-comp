# Trabalho de segurança computacional - 2023-1

# Miller-Rabin
O algoritmo de Miller-Rabin é um teste probabilístico de primalidade utilizado para determinar se um número é composto ou provavelmente primo. O algoritmo de Miller-Rabin é baseado no chamado "testemunho de Fermat". Se um número composto n passar no teste de Miller-Rabin, ele é considerado um "falso testemunho de Fermat"

PASSO A PASSO
#### Dado um número ímpar n a ser testado, escreve-se n-1 como 2^r * d, onde d é um número ímpar.
    Para cada iteração i (de 1 a k, onde k é o número de iterações desejadas):
        Escolhe-se um número aleatório a entre 2 e n-2.
        Computa-se x = a^d mod n.
        Se x for igual a 1 ou n-1, passa-se para a próxima iteração.
        Para j variando de 1 a r-1:
            Computa-se x = x^2 mod n.
            Se x for igual a n-1, passa-se para a próxima iteração.
            Se x for igual a 1, o número é considerado composto.
        Se nenhum dos testes anteriores for satisfeito, o número é considerado composto.
Se após todas as iterações o número não for considerado composto, ele é provavelmente primo.

# RSA (Rivest, Shamir e Adleman)
RSA é um algoritmo de cifração assimétrica. A chave de cifração RSA é gerada aleatoriamente. 
A cifração RSA é implementada utilizando o algoritmo de exponenciação modular.

PASSO A PASSO

#### Gere chaves RSA:
  
     Escolha dois números primos grandes, p e q.
     
     Calcule o produto n = p * q, que será o módulo para as operações de criptografia e descriptografia.
     
     Calcule a função totiente de Euler φ(n) = (p - 1) * (q - 1).
     
     Escolha um número inteiro e relativamente primo a φ(n), chamado de e, para ser a chave pública de criptografia.
     
     Calcule o inverso multiplicativo de e módulo φ(n), chamado de d, para ser a chave privada de descriptografia.
     

#### Implemente as funções de criptografia e descriptografia RSA:
    
     A função de criptografia recebe a mensagem original como entrada e retorna a mensagem criptografada.
     
     A mensagem criptografada é calculada elevando a mensagem original à potência e módulo n.
     
     A função de descriptografia recebe a mensagem criptografada como entrada e retorna a mensagem original.
     
     A mensagem original é calculada elevando a mensagem criptografada à potência d módulo n.


#### Implemente as funções de assinatura e verificação RSA:
  
     A função de assinatura recebe a mensagem original e a chave privada como entrada e retorna a assinatura.
     
     A assinatura é calculada elevando a mensagem original à potência d módulo n.
     
     A função de verificação recebe a mensagem original, a assinatura e a chave pública como entrada e retorna um valor booleano indicando se a assinatura é válida.
     
     Para verificar a assinatura, a mensagem original é calculada elevando a assinatura à potência e módulo n e comparando o resultado com a mensagem original.
     

#### Implemente funções auxiliares:
    
     Função para converter uma string em um número inteiro para a mensagem original.
     
     Função para converter um número inteiro em uma string para a mensagem original.
     

#### Teste sua implementação:
   
    Gere um par de chaves RSA.

    Criptografe e descriptografe uma mensagem para verificar se a implementação funciona corretamente.
     
    Assine uma mensagem com a chave privada e verifique a assinatura usando a chave pública.

# OAEP (Optimal Asymmetric Encryption Padding)
OAEP é um algoritmo de preenchimento comumente utilizado junto à cifração RSA.
Este algoritmo é utilizado junto ao RSA pois com ele a propriedade deterministica é evitada.
     
