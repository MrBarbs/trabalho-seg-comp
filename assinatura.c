#include <inttypes.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>


// Funções
//     Geração de números primos:
//         Uma função para gerar números primos grandes, como p e q.

//     Cálculo do módulo n:
//         Uma função para calcular o produto n = p * q, que será o módulo para as operações de criptografia e descriptografia.

//     Cálculo da função totiente de Euler φ(n):
//         Uma função para calcular a função totiente de Euler, φ(n) = (p - 1) * (q - 1).

//     Cálculo do inverso multiplicativo:
//         Uma função para calcular o inverso multiplicativo de um número, usado para calcular a chave privada de descriptografia.

//     Criptografia RSA:
//         Uma função para criptografar uma mensagem original usando a chave pública (e, n).
//         A mensagem criptografada é calculada elevando a mensagem original à potência e módulo n.

//     Descriptografia RSA:
//         Uma função para descriptografar uma mensagem criptografada usando a chave privada (d, n).
//         A mensagem original é calculada elevando a mensagem criptografada à potência d módulo n.

//     Assinatura RSA:
//         Uma função para assinar uma mensagem original usando a chave privada (d, n).
//         A assinatura é calculada elevando a mensagem original à potência d módulo n.

//     Verificação de assinatura RSA:
//         Uma função para verificar a assinatura de uma mensagem usando a chave pública (e, n).
//         A mensagem original é calculada elevando a assinatura à potência e módulo n e comparando o resultado com a mensagem original.

// Passo a passo
    // Gere chaves RSA:
    //     Escolha dois números primos grandes, p e q.
    //     Calcule o produto n = p * q, que será o módulo para as operações de criptografia e descriptografia.
    //     Calcule a função totiente de Euler φ(n) = (p - 1) * (q - 1).
    //     Escolha um número inteiro e relativamente primo a φ(n), chamado de e, para ser a chave pública de criptografia.
    //     Calcule o inverso multiplicativo de e módulo φ(n), chamado de d, para ser a chave privada de descriptografia.

    // Implemente as funções de criptografia e descriptografia RSA:
    //     A função de criptografia recebe a mensagem original como entrada e retorna a mensagem criptografada.
    //     A mensagem criptografada é calculada elevando a mensagem original à potência e módulo n.
    //     A função de descriptografia recebe a mensagem criptografada como entrada e retorna a mensagem original.
    //     A mensagem original é calculada elevando a mensagem criptografada à potência d módulo n.

    // Implemente as funções de assinatura e verificação RSA:
    //     A função de assinatura recebe a mensagem original e a chave privada como entrada e retorna a assinatura.
    //     A assinatura é calculada elevando a mensagem original à potência d módulo n.
    //     A função de verificação recebe a mensagem original, a assinatura e a chave pública como entrada e retorna um valor booleano indicando se a assinatura é válida.
    //     Para verificar a assinatura, a mensagem original é calculada elevando a assinatura à potência e módulo n e comparando o resultado com a mensagem original.

    // Implemente funções auxiliares:
    //     Função para converter uma string em um número inteiro para a mensagem original.
    //     Função para converter um número inteiro em uma string para a mensagem original.

    // Teste sua implementação:
    //     Gere um par de chaves RSA.
    //     Criptografe e descriptografe uma mensagem para verificar se a implementação funciona corretamente.
    //     Assine uma mensagem com a chave privada e verifique a assinatura usando a chave pública.

int main(){

    return 0;
}