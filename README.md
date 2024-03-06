# Ecommerce API REST
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/matheus-fvp13/java-ecommerce/blob/main/LICENSE)

# Sobre o projeto
Esse projeto é uma aplicação de comércio eletrônico que busca utilizar a arquitetura de software hexagonal para garantir
a separação clara entre a lógica de negócios e as camadas de infraestrutura. O modelo de domínio inclui entidades como Usuário, Pagamento, Categoria, Pedido, Produto e Item de Pedido, cada uma com seus atributos e relacionamentos definidos. A implementação busca proporcionar uma experiência de compra intuitiva, 
permitindo que os usuários realizem pedidos, efetuem pagamentos e visualizem produtos organizados por categorias. 

# Modelo conceitual

```mermaid
classDiagram
    class User {
        -id: Integer
        -firstName: String
        -lastName: String
        -email: String
        -phone: String
        -password: String
    }
    class Payment {
        -id: Integer
        -moment: Date
    }
    class Category {
        -id: Integer
        -name: String
    }
    class Order {
        -id: Integer
        -moment: Date
        -orderStatus: OrderStatus
        + total() double
    }
    class Product { 
        -id: Integer
        -name: String
        -description: String
        -price: Double
        -imgUrl: String
    }
    class OrderItem {
        -quantity: Integer
        -price: Double
        +subTotal() double
    }
    class OrderStatus {
        <<enumeration>>
        -WAITING_PAYMENT: int
        -PAID: int
        -SHIPPED: int
        -DELIVERED: int
        -CANCELED: int
    }
    
    User "1"--"*" Order
    Payment "1"--"1" Order
    Category "1..*"--"*" Product
    Order "*"-- OrderItem
    Product "1..*"-- OrderItem
```

# Tecnologias utilizadas
- Java 21
- Maven
- Spring Boot 3.2.3
- Spring Web
- Spring Data JPA
- Flyway Migrations
- H2 Database
- Postman

# Como executar o projeto
**Pré-requisitos: Java 21**

```bash
# clonar repositório
git clone https://github.com/matheus-fvp13/java-ecommerce.git

# entrar na pasta do projeto
cd java-ecommerce

# executar o projeto
./mvnw spring-boot:run
```

# Autor
Matheus Fernando Vieira Pinto

https://www.linkedin.com/in/matheus-fvp/
