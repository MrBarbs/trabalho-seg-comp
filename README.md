# Trabalho de segurança computacional - 2023-1
# AES (Advanced Encryption Standard)
É um algoritmo de criptografia simétrica amplamente utilizado e considerado uma das principais escolhas para a criptografia de dados. Ele substituiu o antigo algoritmo DES (Data Encryption Standard) devido à sua segurança e desempenho aprimorados.
O AES opera no modo de criptografia de bloco, o que significa que ele criptografa e descriptografa dados em blocos fixos de tamanho fixo. O tamanho do bloco padrão do AES é de 128 bits (16 bytes). No entanto, o AES também suporta tamanhos de chave de 128 bits, 192 bits e 256 bits.

PASSO A PASSO
#### CHAVE 
     É necessário um chave secreta compartilhada entre o remetente e o destinatário para criptografar e descriptografar os dados.

#### EXPANSÃO DE CHAVE
     A chave original passa por uma etapa de expansão de chave para gerar uma série de chaves de rodada que serão usadas nas iterações do algoritmo.

#### CRIPTOGRAFIA 
    O algoritmo AES executa várias rodadas (10, 12 ou 14, dependendo do tamanho da chave) de substituição de bytes, permutação de linhas, permutação de colunas e adição de chave para embaralhar e transformar os dados. Cada rodada usa uma chave de rodada diferente.

#### DESCRIPTOGRAFIA
    O processo de descriptografia do AES é semelhante à criptografia, mas envolve a aplicação das operações inversas nas etapas de criptografia. As chaves de rodada são usadas na ordem inversa.

# IMPLEMENTAÇÃO
A main do projeto fica no App.java, sendo assim para rodar basta digitar no terminal: `java App.java`
