# Usando bibliotecas de terceiros em projeto Java

Nesse repositório tem projeto gradle com Java para demonstrar como usar uma biblioteca de terceiros (arquivo `.jar` armazenado dentro do diretório do projeto).

Para o exemplo foi usada a biblioteca [Standar libraries](https://introcs.cs.princeton.edu/java/stdlib) da universidade de [Princeton](https://introcs.cs.princeton.edu/java/home/), que está sob licença de software livre [GPL versão 3](https://choosealicense.com/licenses/gpl-3.0).

Dentro do arquivo [build.gradle](build.gradle) deve-se incluir a dependência para o arquivo [algs4.jar](libs/algs4.jar).

## Como executar esse projeto no terminal usando o gradle

No arquivo [build.gradle](build.gradle) foi feito uso do plugin *application* para indicar o nome da classe principal do projeto. Ou seja, uma classe que possui o método `main` e que deverá ser invocado quando executada tarefa `run`. Isso foi feito com as seguintes linhas:

```groovy
application {
    // Define a classe principal da aplicação
    mainClass = 'poo.Principal'
}
```
Para executar a aplicação:

```bash
# Compilando o projeto
gradle build

# Executando o projeto usando gradle
gradle run

# Executando o projeto usando gradle e passando 
# dois argumentos de linha de comando

gradle run --args="POO engtelecom"
```

## Redirecionamento da entrada

Uma aplicação Java poderia processar um arquivo texto que enviado para essa por meio do redirecionamento da entrada. Por exemplo, o trecho abaixo fará a leitura de todas as linhas do arquivo texto encaminhado e irá imprimir tais linhas:

```java
// é necessário fazer o import para import java.util.Scanner;
public class Teste{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        while(entrada.hasNext()){
            System.out.println(entrada.nextLine());
        }
        entrada.close();
    }
}
```
Supondo que queira enviar o conteúdo do arquivo `aulas.txt` para essa classe `Teste`, então a linha de comando para executar o código seria:

```bash
java Teste < aulas.txt
```

### Redirecionamento da entrada quando é executado por meio do gradle

No arquivo [build.gradle](build.gradle) foram adicionadas as seguintes linhas para definir o fluxo de entrada padrão quando for executada a tarefa `run`.

```groovy
// Definindo o fluxo de entrada padrão quando o projeto for executado
run{
 standardInput = System.in
}
```

Com essas linhas é possível executar o projeto usando o gradle e com o redirecionamento da entrada.

```bash
gradle run < settings.gradle
```

## Como executar esse projeto no terminal sem usar o gradle

É possível compilar e executar esse projeto sem usar o gradle. Contudo, como esse projeto faz uso de uma biblioteca de terceiros (não presente no JDK), é necessário informar o caminho dessa biblioteca (incluir no [*classpath* java](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html)) para a compilação e para a execução. 

### Compilando

```bash
cd src/main/java
javac -cp ../../../libs/algs4.jar:. poo/Principal.java
```

### Executando
```bash 
# Considerando que estará dentro do diretório src/main/java
java -cp ../../../libs/algs4.jar:. poo.Principal POO
```
