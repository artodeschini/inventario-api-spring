# Projeto API Rest de Materiais

## requisitos

* maven
* java 17
* lombok
* h2

## Criação do projeto

Esté projeto foi dessenvolvido com [spring](https://start.spring.io/) que realiza um crud com a h2 database

## para maiores detalhes com spring

[help spring](HELP.md)

## Interface grafica

Foi desenvolvida em conjunto com esse projeto um [projeto angular](https://github.com/artodeschini/inventario-app-angular)

## acesso a console do h2

Este projeto foi realizado utilizando h2da



## Base de dados

Foi utilizada [h2 database](https://www.h2database.com/html/main.html), porém pode ser substituido por qualquer banco de dados relacional que tenha suporte a jdbc4

Para acessar a [console h2](http://localhost:8080/h2-console) voce pode utilizar esse link

## boilerplate

A fim de evitar a `boilerplate` codigo repetitivo foi utilizado [lombok](https://projectlombok.org/) afim de remover codigo como get e set construtores e escrita do metodo toString

[implementado](src/main/java/org/todeschini/intentario/model/Produto.java)
