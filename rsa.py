from os import urandom
from math import ceil
from hashlib import sha1, sha3_256
from operator import xor
from random import random, randrange

# Teste de Miller Rabin para k iterações"
def teste_MillerRabin(n, k=10):
    for i in range(k):
        a = random.randrange(2, n - 1)
        if not iteracao_MillerRabin(n, a):
            return False
    return True

# iteração do teste Miller Rabin"
def iteracao_MillerRabin(n, a):
    exp = n - 1
    while not exp & 1:
        exp >>= 1
            
    if pow(a, exp, n) == 1:
        return True
            
    while exp < n - 1:
        if pow(a, exp, n) == n - 1:
            return True
        exp <<= 1
 
#Retorna um número aleatório ímpar com um número específico de bits       
def maior_impar(nbits=1024):
    return randrange(2 ** (nbits - 2), 2 ** (nbits - 1)) * 2 - 1

#Gera o maior primo
def gerar_primo():
    return next(filter(teste_MillerRabin, iter(maior_impar, 0)))

# https://datatracker.ietf.org/doc/html/rfc8017#appendix-B.2.1
# def mask(data, seed, mlen):
#     t = b''
#     for counter in range(ceil(mlen / 20)):
#         c = counter.to_bytes(4, "big")
#         t += sha1(seed + c).digest()
#     return bytes(map(xor, data, bytes(len(data)) + t[:mlen]))

#Gerador de chaves
def gerar_chaves():
    p = gerar_primo()
    g = gerar_primo()
    n = p * q
    phi_n = (p-1) * (q-1)
    e =  65537
    d = pow(e, -1, phi_n)
    chave_publica = (n,e)
    chave_privada = (n,d)
    return (chave_publica, chave_privada)

# def oaep_encode(n, message):
#     k = (n.bit_length() + 7) // 8
#     message_len = len(message)
#     hash_len = 20
#     lable_hash = b"\xda9\xa3\xee^kK\r2U\xbf\xef\x95`\x18\x90\xaf\xd8\x07\t"
#     padding_string = b"\x00" * (k - message_len - 2 * hash_len - 2)
#     data_block = lable_hash + padding_string + b'\x01' + message
#     seed = urandom(hash_len)
#     masked_data_block = mask(data_block, seed, k - hash_len - 1)
#     masked_seed = mask(seed, masked_data_block, hash_len)
#     return b'\x00' + masked_seed + masked_data_block


# # https://datatracker.ietf.org/doc/html/rfc8017#section-7.1.2
# def oaep_decode(n, em):
#     k = (n.bit_length() + 7) // 8
#     hash_len = 20
#     _, masked_seed, masked_data_block = em[:1], em[1:1 + hash_len], em[1 + hash_len:]

#     seed = mask(masked_seed, masked_data_block, hash_len)
#     data_block = mask(masked_data_block, seed, k - hash_len - 1)
#     _, message = data_block.split(b'\x01')
#     return message

#Realiza a criptografia RSA de uma mensagem usando uma chave fornecida.
#E retorna a mensagem criptografada como uma sequência de bytes.
def rsa(chave, mensagem):
    n , expoente = chave
    k = (n.bit_lenght() + 7) // 8
    m = int.from_bytes(mensagem, "big")
    c = pow(m, expoente, n)
    return c.to_bytes(k, "big")

def cifrar(chave, mensagem):
    crifado = oaep_encode(chave[0], mensagem)
    return rsa(chave, cifrado)

def decifrar(chave, texto_cifrado):
    cifrado = rsa(chave, texto_cifrado)
    return oaep_decode(key[0], cifrado)

def assinatura(chave_privada, data):
    hash = sha3_256(data).digest()
    return rsa(chave_privada, hash)

def verificar(chave_publica, data, assinatura):
    hash = sha3_256(data).digest()
    return rsa(chave_publica, assinatura)[-32:] == hash
    