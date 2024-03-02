**Aplicação Java para Kafka**

Esta é uma aplicação Java que demonstra a integração com o Apache Kafka, uma plataforma de streaming distribuído. A aplicação consiste em um produtor e um consumidor Kafka simples, utilizando a biblioteca Java Kafka Clients.

**Funcionalidades:**

*   **Produtor:** Gera mensagens e as envia para um tópico específico no Kafka.
*   **Consumidor:** Recebe mensagens de um tópico Kafka e as processa conforme necessário.

**Recursos:**

*   **Apache Kafka:** Utiliza o Kafka como o sistema de mensagens para comunicação assíncrona e em tempo real.
*   **Java Kafka Clients:** Implementa a lógica de produção e consumo de mensagens usando a biblioteca Java Kafka Clients.

**Pré-requisitos:**

*   Java 8 ou superior instalado
*   Apache Kafka instalado e configurado localmente ou acessível remotamente

**Instruções de Uso:**

1.  Clone este repositório em sua máquina local.
2.  Certifique-se de ter o Kafka em execução ou ajuste as configurações para se conectar a um cluster Kafka remoto.
3.  Execute o produtor para enviar mensagens ao tópico Kafka desejado.
4.  Execute o consumidor para receber e processar as mensagens do tópico Kafka.

**Estrutura do Projeto:**

*   `src/main/java`: Contém o código-fonte Java da aplicação.
*   `src/main/resources`: Contém arquivos de configuração, como propriedades do Kafka.
