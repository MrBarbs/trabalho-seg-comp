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
    
    key = os.urandom(16)
    iv = os.urandom(16)
    
    session_key = key + iv
    
    n, e = map(int, public_key)
    public_key = (n, e)
    print("Chave PUBLICA (CIFRAR): ", public_key)
    print()
        
    n, d = map(int, private_key)
    private_key = (n, d)    
    print("Chave PRIVADA (CIFRAR): ", private_key)
    print()    

    cifrar_session_key = rsa.cifrar(public_key, session_key)
    assinatura = rsa.assinatura(private_key, mensagem)
    assinatura = base64.b64encode(assinatura).decode('ascii')
    cifrar_session_key = base64.b64encode(cifrar_session_key).decode("ascii")
    print("Assinatura: ", assinatura)
    print()

    print("############# DECIFRA #####################")
    ###### DECIFRA ##########    

    signature = base64.b64decode(assinatura)
    print("Assinatura: ", signature)
    print()
    
    cipher_session_key = base64.b64decode(cifrar_session_key)
    
    n, d = map(int, private_key)
    private_key = (n, d)
    print("Chave PRIVADA (DECIFRAR): ", private_key )
    print()

    n, e = map(int, public_key)
    public_key = (n, e)
    print("Chave PUBLICA (DECIFRAR): ", public_key )
    print()

    session_key = rsa.decifrar(private_key, cipher_session_key)
    key, iv = session_key[:16], session_key[16:]

    result = rsa.verificar(public_key, mensagem,signature)
    
    if result:
        print("Assinatura ok")
