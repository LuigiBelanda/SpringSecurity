/*
O código fornecido define uma classe de modelo chamada `Customer` que mapeia uma tabela no banco
de dados usando a anotação `@Entity` do pacote `jakarta.persistence`.

A classe possui as seguintes propriedades:
- `id`: é uma chave primária e é gerada automaticamente usando a estratégia
`GenerationType.AUTO` e o gerador `GenericGenerator`.

No código fornecido, as anotações `@Id`, `@GeneratedValue` e `@GenericGenerator` são usadas para
configurar a geração automática da chave primária (`id`) da entidade `Customer`.

- `@Id`: Essa anotação é usada para indicar que o campo `id` é a chave primária da entidade. Ela
especifica que o campo `id` será usado para identificar exclusivamente cada registro na tabela
correspondente no banco de dados.

`@GeneratedValue`: Essa anotação é usada para configurar a forma como o valor da chave primária
será gerado. No código fornecido, `strategy = GenerationType.AUTO` indica que o provedor JPA
deve escolher a estratégia de geração automática adequada com base no banco de dados em uso.

`@GenericGenerator`: Essa anotação é usada para definir um gerador personalizado para a geração
da chave primária. No código fornecido, `name = "native"` define o nome do gerador como "native",
e `strategy = "native"` indica que o provedor JPA deve usar a estratégia de geração automática nativa
do banco de dados.

No caso específico, a estratégia `GenerationType.AUTO` em conjunto com o gerador `GenericGenerator`
configurado como "native" indica que o provedor JPA utilizará a estratégia de geração automática
nativa do banco de dados. Isso significa que o banco de dados será responsável por gerar automaticamente
os valores para a chave primária durante a inserção de registros na tabela correspondente. A estratégia
específica de geração automática dependerá do banco de dados em uso.

- `email`: representa o endereço de e-mail do cliente.
- `pwd`: representa a senha do cliente.
- `role`: representa o papel (role) do cliente.

Além disso, a classe `Customer` possui métodos getters e setters para cada propriedade,
permitindo o acesso e a modificação dos valores dessas propriedades.

Essa classe é usada em conjunto com um sistema de persistência (como o Hibernate) para
persistir objetos `Customer` no banco de dados. Cada instância da classe `Customer`
representa uma entrada na tabela correspondente no banco de dados.

No contexto de autenticação e autorização, a classe `Customer` pode ser usada para
armazenar informações dos clientes, como seus e-mails, senhas e papéis (roles). Esses
dados podem ser consultados e utilizados pelo Spring Security para autenticar e autorizar
os usuários em um sistema.
*/

package com.eazybytes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String email;
    private String pwd;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
