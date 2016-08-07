package br.com.barbosa.developer.sorveteria.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.barbosa.developer.sorveteria.modelo.repositories.SorveteriaRepositorio;
import br.com.barbosa.developer.sorveteria.modelo.servicos.ServicoAutenticacao;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	@Autowired private SorveteriaRepositorio usuarioRepositorio;
	@Autowired private ServicoAutenticacao servicoAutenticacao;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(servicoAutenticacao)
			.passwordEncoder(encoder());
		
		
		//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("SORVETERIA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/app/sorvetes/**", "/app/ingredientes/**")
			.hasRole("SORVETERIA")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login.jsp")
			.loginProcessingUrl("/autenticar")
			.defaultSuccessUrl("/app/sorvetes")
			.failureUrl("/login.jsp?semacesso=true")
			.usernameParameter("usuario")
			.passwordParameter("senha")
		.and()
			.logout()
				.logoutUrl("/sair")
				.logoutSuccessUrl("/login.jsp?saiu=true");
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}
	
}
