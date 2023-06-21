/*
O código fornecido é uma implementação personalizada da interface `UserDetailsService` do Spring Security.
Essa implementação, chamada `EazyBankUserDetails`, é responsável por carregar os detalhes do usuário
com base no nome de usuário fornecido durante o processo de autenticação.

A classe `EazyBankUserDetails` possui uma dependência injetada de `CustomerRepository`, que é uma
classe responsável pela interação com o banco de dados para recuperar informações do cliente.

O método `loadUserByUsername` é implementado para buscar um cliente com base no nome de usuário
(email) fornecido. Se nenhum cliente for encontrado, uma exceção `UsernameNotFoundException` é
lançada. Caso contrário, o nome de usuário e senha são extraídos do primeiro cliente retornado
pela consulta ao banco de dados.

Em seguida, é criada uma lista de `GrantedAuthority` (autoridades concedidas) que contém apenas
uma autoridade, que é o papel (role) do cliente retornado do banco de dados.

Por fim, é criado e retornado um objeto `User` do Spring Security, que implementa a interface
`UserDetails` e contém as informações necessárias do usuário, como nome de usuário, senha e autoridades.

Essa implementação personalizada permite que o Spring Security carregue os detalhes do usuário
do banco de dados com base no nome de usuário fornecido durante a autenticação. Dessa forma, é
possível realizar autenticação e autorização personalizadas com base nos dados dos clientes
armazenados no banco de dados.
*/

package com.eazybytes.config;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EazyBankUserDetails implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;

        List<GrantedAuthority> authorities = null;
        List<Customer> customer = customerRepository.findByEmail(username);

        if (customer.size() == 0) {
            throw new UsernameNotFoundException("User details not found the user: " + username);
        } else {
            userName = customer.get(0).getEmail();
            password= customer.get(0).getPwd();

            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }

        return new User(userName, password, authorities);
    }
}
