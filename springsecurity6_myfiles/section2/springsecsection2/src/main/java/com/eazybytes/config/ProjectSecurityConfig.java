/*

O código fornecido representa uma classe de configuração do Spring Security chamada
`ProjectSecurityConfig`. Essa classe é anotada com `@Configuration`, indicando que ela é
uma classe de configuração do Spring.

A anotação `@Configuration` é usada para marcar uma classe como uma classe de configuração no Spring Framework.

Quando uma classe é anotada com `@Configuration`, o Spring reconhece que essa classe contém
configurações específicas do aplicativo. Essas configurações podem incluir beans personalizados,
definição de propriedades, configurações de segurança, configurações de banco de dados, entre outras.

Ao usar a anotação `@Configuration`, você está informando ao Spring que a classe possui
uma ou mais configurações que devem ser carregadas e aplicadas durante o tempo de execução da
aplicação. Essas configurações podem ser lidas e interpretadas pelo Spring para fornecer
comportamentos específicos, como a criação de beans personalizados ou a configuração de
componentes do Spring, como o Spring Security.

No caso específico do código fornecido, a anotação `@Configuration` é usada para indicar que a
classe `ProjectSecurityConfig` é uma classe de configuração do Spring Security. Ela contém a
definição do método `defaultSecurityFilterChain`, que configura as regras de segurança para a aplicação.

Em resumo, a anotação `@Configuration` é usada para marcar classes que contêm configurações
específicas do aplicativo no Spring Framework, permitindo que o Spring reconheça e carregue
essas configurações durante a execução da aplicação.

Dentro dessa classe, um método `defaultSecurityFilterChain` é definido e anotado com `@Bean`.
Esse método retorna um `SecurityFilterChain`, que é responsável por configurar as regras de segurança
para a aplicação.

As configurações de segurança personalizadas são definidas dentro do método `defaultSecurityFilterChain`,
utilizando a API fluente do Spring Security.

As configurações neste exemplo são as seguintes:

1. `http.authorizeHttpRequests(...)`: Define as regras de autorização para requisições HTTP. Neste caso, o método `authorizeHttpRequests` recebe um lambda que configura as regras de autorização.
   - `requests.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()`: Define que as URLs "/myAccount", "/myBalance", "/myLoans" e "/myCards" requerem autenticação para acesso.
   - `.requestMatchers("/notices","/contact").permitAll()`: Define que as URLs "/notices" e "/contact" são permitidas para acesso público, ou seja, não requerem autenticação.

2. `.formLogin(Customizer.withDefaults())`: Configura o formulário de login padrão do Spring Security.

3. `.httpBasic(Customizer.withDefaults())`: Configura a autenticação HTTP básica padrão do Spring Security.

Em relação ao Spring Security, a classe `Customizer` é uma classe utilitária fornecida pelo Spring Framework
que facilita a personalização de configurações específicas.

A classe `Customizer` é usada para fornecer um meio conveniente de personalizar configurações sem a
necessidade de escrever classes ou métodos anônimos completos. Ela permite que você forneça apenas os
detalhes necessários para personalizar uma configuração específica.

No contexto do código fornecido, você pode ver o uso do `Customizer` nas chamadas aos métodos
`formLogin` e `httpBasic`:

- `.formLogin(Customizer.withDefaults())`: Isso aplica a configuração padrão para o formulário de
login do Spring Security. O método `withDefaults()` retorna um
`Customizer<HttpSecurity.FormLoginConfigurer<HttpSecurity>>`, que encapsula as personalizações
desejadas para a configuração do formulário de login.

- `.httpBasic(Customizer.withDefaults())`: Isso aplica a configuração padrão para a autenticação
HTTP básica do Spring Security. O método `withDefaults()` retorna um
`Customizer<HttpSecurity.HttpBasicConfigurer<HttpSecurity>>`, que encapsula
as personalizações desejadas para a configuração da autenticação HTTP básica.

Esses métodos `withDefaults()` retornam uma instância de `Customizer` que contém as
personalizações padrão fornecidas pelo Spring Security para as configurações específicas.
Isso permite que você aproveite as configurações padrão sem a necessidade de fornecer todas
as personalizações detalhadas.

Em resumo, o `Customizer` é uma classe utilitária do Spring Framework que facilita a personalização
de configurações específicas, permitindo que você forneça apenas as personalizações necessárias sem
escrever classes ou métodos anônimos completos. Isso simplifica a personalização de configurações no
Spring Security.

Em seguida, o método `http.build()` é chamado para finalizar a configuração do objeto `HttpSecurity`
e retornar o `SecurityFilterChain`.

Existem também comentários no código fornecido com outras configurações alternativas:
- `Configuration to deny all the requests`: Configuração para negar todas as requisições.
- `Configuration to permit all the requests`: Configuração para permitir todas as requisições.

Essas configurações alternativas podem ser descomentadas e usadas, se necessário, substituindo as
configurações existentes.

Em resumo, a classe `ProjectSecurityConfig` configura as regras de segurança para a
aplicação, definindo quais URLs requerem autenticação e quais URLs são públicas,
além de configurar o formulário de login e a autenticação HTTP básica.

*/

package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         *  Below is the custom security configurations
         */

        http.authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();

        /**
         *  Configuration to deny all the requests
         */
        /*http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();*/

        /**
         *  Configuration to permit all the requests
         */
        /*http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();*/
    }

}
