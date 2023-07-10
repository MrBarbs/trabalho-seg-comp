import argparse
import os
import base64
import rsa

if __name__ == "__main__":
    
    mensagem = input("Digite a mensagem que deseja ser codificada: ")

    public_key, private_key = rsa.gerar_chaves()
    
    print("################ CHAVES INICIAIS ####################")
    n, e = public_key
    print("Chave PUBLICA (INICIAL): ", public_key)
    print()
    
    _, d = private_key
    print("Chave PRIVADA (INICIAL): ", private_key)            
    print()
    
    print("############# CIFRA #####################")
    ######### CIFRA ###########
    
    #Gera uma chave e um vetor aleatórios de 16 bytes cada, usados
    #para criptografia simétrica 
    key = os.urandom(16)
    iv = os.urandom(16)
    
    #Concatenação para chave da sessão
    session_key = key + iv
    
    #Converte a lista public_key em dois valores inteiros
    # N é o modulo e  E é o expoente publico do RSA
    n, e = map(int, public_key)
    public_key = (n, e)
    print("Chave PUBLICA (CIFRAR): ", public_key)
    print()
    
    #COnverte a lista private_key  
    n, d = map(int, private_key)
    private_key = (n, d)    
    print("Chave PRIVADA (CIFRAR): ", private_key)
    print()    

    #Realiza a criptografia assimetrica da chave de sessão, usando chave publica
    cifrar_session_key = rsa.cifrar(public_key, session_key)
    print("Cifrado: ", cifrar_session_key)
    print()
    
    #Realiza a assinatura digital usando a chave privada
    assinatura = rsa.assinatura(private_key, mensagem)
    
    #Coloca tudo em Base64
    assinatura = base64.b64encode(assinatura).decode('ascii')
    cifrar_session_key = base64.b64encode(cifrar_session_key).decode("ascii")
    print("Assinatura: ", assinatura)
    print()

    print("############# DECIFRA #####################")
    ###### DECIFRA ##########    
    #decodifica a assinatura da base64 para obter os dados binários originais
    signature = base64.b64decode(assinatura)
    print("Assinatura: ", signature)
    print()
    
    # Decodifica a chave de sessão da base64 para obter os dados
    cipher_session_key = base64.b64decode(cifrar_session_key)
    
    # Converte a chave publica
    n, e = map(int, public_key)
    public_key = (n, e)
    print("Chave PUBLICA (DECIFRAR): ", public_key )
    print()
    
     # Convertem a chave privada
    n, d = map(int, private_key)
    private_key = (n, d)
    print("Chave PRIVADA (DECIFRAR): ", private_key )
    print()

    #Decifração da chave, utilizando a chave privda
    session_key = rsa.decifrar(private_key, cipher_session_key)
    
    #Divide a session_key em 2 partes de 16 bytes
    # 16 bytes - chave e próximos 16 bytes vetor de inicialização 
    key, iv = session_key[:16], session_key[16:]
    print("Decifrado: ", session_key)
    print()
    
    # Verifica a autenticidade da assinatura digital da mensagem
    # Usando a chave publica
    result = rsa.verificar(public_key, mensagem,signature)
    
    # Verifica result e se for verdadeira
    # A assinatura foi verificada com sucesso
    if result:
        print("Assinatura ok")
