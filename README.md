# Petzin

## Instalação

#### Pré requisitos

- Java 8
- Maven 3+
- Lombok configurado na IDE (O jar esta na pasta lib no projeto, basta clica e apontar para a pasta doo eclipse)

#### Preparando o ambiente

1. Criar variável de ambiente para password do banco H2.
```sh
  SPRING_DATASOURCE_PASSWORD
```

2. Paraca acessar o painel do H2
```sh
  url: http://localhost:8080/api/h2-console
  base: jdbc:h2:mem:petzin
  usuario: sa
```

#### Documentação
```sh
  http://localhost:8080/api/swagger-ui.html#/
```
