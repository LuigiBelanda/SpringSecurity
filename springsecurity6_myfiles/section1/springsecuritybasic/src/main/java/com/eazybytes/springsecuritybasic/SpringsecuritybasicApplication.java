/*
O `@ComponentScan` é uma anotação do Spring Framework que indica quais pacotes
devem ser escaneados em busca de componentes (beans) anotados com anotações especiais
do Spring, como `@Component`, `@Service`, `@Controller`, etc.

No código fornecido, a anotação `@ComponentScan` está sendo usada para especificar o pacote
`com.eazybytes.springsecuritybasic.controller`. Isso significa que o Spring irá escanear esse
pacote em busca de classes anotadas com anotações como `@Controller`, `@RestController`,
`@RequestMapping`, entre outras.

Essa anotação é opcional e pode ser usada para ajudar o Spring a encontrar e registrar
automaticamente os controladores (controllers) da aplicação. Sem essa anotação, o Spring
ainda pode encontrar os componentes, desde que estejam localizados em pacotes dentro da
estrutura de pacotes da aplicação definida pelo Spring Boot.

Em resumo, o `@ComponentScan` é usado para instruir o Spring a procurar e registrar
automaticamente os componentes (beans) em um pacote específico ou em pacotes dentro
de uma determinada estrutura de pacotes. Isso ajuda a reduzir a configuração manual
necessária para registrar os componentes no contexto do Spring.
*/

package com.eazybytes.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.eazybytes.springsecuritybasic.controller") // Optional
public class SpringsecuritybasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybasicApplication.class, args);
	}

}
