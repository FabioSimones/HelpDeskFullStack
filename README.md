## Sistema Helpdesk Fullstack

--([Fábio Simones](https://github.com/FabioSimones))

## Resumo do projeto
<p>Este projeto possui a construção de uma aplicação web completa, CRUD (CREATE, READ, UPDATE e DELETE) 
de um sistema web para uma microempresa abrir e encerrar suas ordens de serviço. Em resumo o sistema 
possui clientes e técnicos, onde o cliente solicita reparo a um determinado equipamento para um técnico, 
e o técnico consegue atualizar o status da requisição.</p><br>

## Backend
<p>Para a criação da API Rest deste projeto, foi utulizado o Java com o Spring Boot 2.x.x e o banco de dados MySQL, 
sendo utilizado o JPA com Hibernate, validação de dados, tratamentos de exceções, padrão Rest, dentre outras. <br>
Ao desenvolver o projeto resolvi utilizar a plataforma do IntelliJ, apenas por ter mais afinidade com a mesma, 
porém não haverá problema algum na sua execução quanto a utilização de outras plataformas, desde que a mesma 
aceite extensões referentes a Java.</p>

## 1 - Modelo Conceitual
![image](https://github.com/user-attachments/assets/6ba9d02b-1ec5-4d6e-8b5d-8962bf2f654d) <br>
<p>Este é o modelo conceitual do nosso sistema Helpdesk, podemos observar que criamos uma classe pessoa e 
utilizamos o conceito de herança, pois o mesmo tipo de cadastro para o cliente será o do técnico, 
visando apenas alterar o tipo do perfil, para dar alguns acessos ao técnico que não existem quanto ao 
cliente. Quanto ao chamado teremos variáveis como datas para informar as ações de criação e finalização 
assim como enumeradores para definir prioridades e o status quanto a sua execução.</p>

## 2 - Casos de uso
O escopo funcional do sistema consiste nos seguintes casos de uso:

<table>
  <thead>
    <tr align="left">
      <th>Caso de uso</th>
      <th>Visão geral</th>
      <th>Acesso</th>
    </tr>
  </thead>
  <tbody align="left">
    <tr><td>Manter chamado</td><td> CRUD de chamados, podendo filtrar itens pelo nome</td><td>Usuários logado</td></tr>
 <tr><td>Manter cliente</td><td> CRUD de cliente, podendo filtrar itens pelo nome</td><td>Criação: Somente Admin; 
   Outras funções: Usuário logado</td></tr>
 <tr><td>Manter técnico</td><td> CRUD de técnico, podendo filtrar itens pelo nome</td><td>Criação: Somente Admin; 
   Outras funções: Usuário logado</td></tr>
 <tr><td>Alterar chamado</td><td> Poder alterar as informações do chamado, conforme a ordem de serviço for executada
 </td><td>Usuários logado</td></tr>
 <tr><td>Consultar chamados</td><td> Listar chamados cadastrados, podendo filtrar chamados pelo nome</td><td>Usuários logado</td></tr>
 <tr><td>Sign up</td><td> Cadastrar-se no sistema</td><td>Usuários logado</td></tr>
 <tr><td>Login</td><td> Efetuar login no sistema</td><td> Público</td></tr>
 <tr><td>Registrar chamado</td> <td>Salvar no sistema nova ordem de serviço</td><td>Usuário logado</td></tr>
 <tr><td>Atualizar perfil</td><td>  Atualizar o próprio cadastro</td><td>Usuário logado</td>
 <tr><td>Visualizar chamados</td><td>  Visualizar os chamados que o próprio usuário já fez</td><td>Usuário logado</td>   
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>
</p>

## 3 - Atores

<table>
  <tbody align="left">
   <tr><td>Ator</td><td> Responsabilidade
 <tr><td>Usuário anônimo</td><td> Pode realizar casos de uso das áreas públicas do sistema, no nosso caso 
   apenas login.</td></tr>
 <tr><td>Cliente</td><td> Responsável por manter seu próprios dados pessoais no sistema,
 possui acesso aos CRUD's, porém não pode criar outro técnico ou cliente.</td></tr>
<tr><td>Técnico</td><td> Responsável por manter seu próprios dados pessoais no sistema,
possui acesso a CRUD's, porém não pode criar outro técnico ou cliente.</td></tr>
 <tr><td>Admin</td><td> Possui acesso a todas as funcionalidades do sistema.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

## 4 - Casos de uso (detalhamento)

<b>Manter chamado</b>
<table>
  <tbody align="left">
   <tr><td>Atores</td><td> Técnico, Cliente, Admin</td></tr>
<tr><td>Precondições</td><td> -</td></tr>
<tr><td>Pós-condições</td><td> -</td></tr>
<tr><td>Visão geral</td><td> Listar chamados, podendo filtrar o mesmo sendo, por parte do nome 
  ou status do chamado</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. [OUT] O sistema informa uma listagem paginada de titulo, cliente, técnico, 
  data de abertura, prioridade e status.</td></tr>
<tr><td>2. [IN] O usuário informa, opcionalmente, parte do nome de um chamado, 
  ou seleciona o status do mesmo.</td></tr>
<tr><td>3. [OUT] O sistema informa a listagem atualizada</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
<tr><td>Informações complementares</td></tr>
<tr><td>O número padrão de registros por página deve ser 5. Como a listagem é paginada, o
usuário pode navegar nas próximas páginas. Quando chegar a parte do frontend foi adicionado 
  a opção do usuário selecionar a quantidade de itens por página.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<b>Manter cliente</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td>Criação: Somente Admin; Outras funções: Usuário logado</td></tr>
<tr><td>Precondições</td><td> Usuário logado</td></tr>
<tr><td>Pós-condições </td><td>-</td></tr>
<tr><td>Visão geral</td><td> CRUD de clientes, podendo filtrar itens pelo nome</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. Executar caso de uso: Consultar clientes.<br>
2. O Cliente seleciona uma das opções<br>
    -  2.1. Variante Atualizar<br>
    -  2.2. Variante Deletar<br>
</td></tr>
<tr><td>2. Executar caso de uso: Consultar clientes.<br>
2. O Admin seleciona uma das opções<br>
    -  2.1. Variante Inserir<br>
    -  2.2. Variante Atualizar<br>
    -  2.3. Variante Deletar<br>
</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: variantes</td></tr>
<tr><td>2.1. Variante Inserir<br>
2.1.1. [IN] O admin informa perfil do cliente, nome, cpf, email, senha.<br><br>
2.2. Variante Atualizar<br>
2.2.1. [IN] O usuário seleciona um cliente para editar.<br>
2.2.2. [OUT] O sistema informa perfil do cliente, nome, cpf, email, senha, 
  para o cliente selecionado.<br>
2.2.3. [IN] O usuário informa novos valores para perfil do cliente, nome, cpf, email, senha, 
  para o cliente selecionado.<br><br>
2.3. Variante Deletar<br>
2.3.1. [IN] O admin seleciona um cliente para deletar.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: exceções</td></tr>
<tr><td>2.1.1a. Dados inválidos<br>
2.1.1a.1. [OUT] O sistema informa os erros nos campos inválidos [1].<br>
2.1.1a.2. Vai para passo 2.1.1.<br><br>
2.2.3a. Dados inválidos<br>
2.2.3a.1. [OUT] O sistema informa os erros nos campos inválidos [1].<br>
2.2.3a.2. Vai para passo 2.2.1.<br><br>
2.2.3b. Id não encontrado<br>
2.2.3b.1. [OUT] O sistema informa que o id não existe.<br>
2.2.3b.2. Vai para passo 2.2.1.<br><br>
2.3.1a. Id não encontrado<br>
2.3.1a.1. [OUT] O sistema informa que o id não existe.<br>
2.3.1a.2. Vai para passo 2.3.1.<br><br>
2.3.1b. Integridade referencial violada<br>
2.3.1b.1. [OUT] O sistema informa que a deleção não pode ser feita porque viola a
integridade referencial dos dados.<br>
2.3.1b.2. Vai para passo 2.3.1.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<b>Manter técnico</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td>Criação: Somente Admin; Outras funções: Usuário logado</td></tr>
<tr><td>Precondições</td><td> Usuário logado</td></tr>
<tr><td>Pós-condições </td><td>-</td></tr>
<tr><td>Visão geral</td><td> CRUD de técnicos, podendo filtrar itens pelo nome</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. Executar caso de uso: Consultar técnicos<br>
2. O Técnico seleciona uma das opções<br>
    -  2.1. Variante Atualizar<br>
    -  2.2. Variante Deletar<br>
</td></tr>
<tr><td>2. Executar caso de uso: Consultar técnicos<br>
2. O Admin seleciona uma das opções<br>
    -  2.1. Variante Inserir<br>
    -  2.2. Variante Atualizar<br>
    -  2.3. Variante Deletar<br>
</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: variantes</td></tr>
<tr><td>2.1. Variante Inserir<br>
2.1.1. [IN] O admin informa perfil do técnico, nome, cpf, email, senha.<br><br>
2.2. Variante Atualizar<br>
2.2.1. [IN] O usuário seleciona um técnico para editar.<br>
2.2.2. [OUT] O sistema informa perfil do técnico, nome, cpf, email, senha, 
  para o cliente selecionado.<br>
2.2.3. [IN] O usuário informa novos valores para perfil do técnico, nome, cpf, email, senha, 
  para o cliente selecionado.<br><br>
2.3. Variante Deletar<br>
2.3.1. [IN] O admin seleciona um técnico para deletar.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: exceções</td></tr>
<tr><td>2.1.1a. Dados inválidos<br>
2.1.1a.1. [OUT] O sistema informa os erros nos campos inválidos [1].<br>
2.1.1a.2. Vai para passo 2.1.1.<br><br>
2.2.3a. Dados inválidos<br>
2.2.3a.1. [OUT] O sistema informa os erros nos campos inválidos [1].<br>
2.2.3a.2. Vai para passo 2.2.1.<br><br>
2.2.3b. Id não encontrado<br>
2.2.3b.1. [OUT] O sistema informa que o id não existe.<br>
2.2.3b.2. Vai para passo 2.2.1.<br><br>
2.3.1a. Id não encontrado<br>
2.3.1a.1. [OUT] O sistema informa que o id não existe.<br>
2.3.1a.2. Vai para passo 2.3.1.<br><br>
2.3.1b. Integridade referencial violada<br>
2.3.1b.1. [OUT] O sistema informa que a deleção não pode ser feita porque viola a
integridade referencial dos dados.<br>
2.3.1b.2. Vai para passo 2.3.1.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<b>Login</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Usuário anônimo</td></tr>
<tr><td>Precondições</td><td> -</td></tr>
<tr><td>Pós-condições</td><td> Usuário logado</td></tr>
<tr><td>Visão geral</td><td> Efetuar login no sistema</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. [IN] O usuário anônimo informa suas credenciais (email e senha).<br>
2. [OUT] O sistema informa um token válido.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>
<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: exceções</td></tr>
<tr><td>1a. Credenciais inválidas<br>
1a.1. [OUT] O sistema informa que as credenciais são inválidas.<br>
1a.2. Vai para passo 1.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<b>Alterar chamado</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Usuário logado</td></tr>
<tr><td>Precondições</td><td> -</td></tr>
<tr><td>Pós-condições</td><td> -</td></tr>
<tr><td>Visão geral</td><td> Alterar status de chamados</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
<tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. Executar caso de uso: Consultar chamados.<br>
2. [IN] O Usuário logado seleciona um chamado.<br>
3. [OUT] O sistema informa titulo do chamado, status, prioridade, técnico, cliente e descrição.<br>
4. [IN] O Usuário logado informa que o deseja alterar no chamado.<br>
5. [ OUT] O sistema informa os dados atualizados do chamado [1].</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
<tr><td>Informações complementares</td></tr>
<tr><td>[1] Dados do chamado:<br>
- lista informações do chamado.<br>
</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<b>Registrar chamado</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Usuário logados.</td></tr>
<tr><td>Precondições</td><td> - Usuário logado<br>
- Necessário criar novo chamado para ordem de serviços.</td></tr>
<tr><td>Pós-condições</td><td>--</td></tr>
<tr><td>Visão geral</td><td>Salvar o chamado com os dados cadastrados pelo usuário.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. [IN] O usuário informa os dados do chamado [1].<br>
2. [OUT] O sistema informa os dados do chamado[1].</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

## 5 - Dependências
<br>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>

		<!-- Security -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.7.0</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

  
  ## 6 - Seed
  <br>

    Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "550.482.150-95", "valdir@mail.com", encoder.encode("123"));
		tec1.AddPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
 
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

  <br>
