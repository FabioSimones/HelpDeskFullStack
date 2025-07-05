## Sistema Helpdesk Frontend

--([Fábio Simones](https://github.com/FabioSimones))

## Resumo desse projeto

<p>Este projeto possui a construção de uma aplicação web completa, CRUD (CREATE, READ, UPDATE e DELETE) 
de um sistema web para uma microempresa abrir e encerrar suas ordens de serviço. Em resumo o sistema 
possui clientes e técnicos, onde o cliente solicita reparo a um determinado equipamento para um técnico, 
e o técnico consegue atualizar o status da requisição.</p><br>

## Frontend

<p>Para a construção do frontend utilizaremos o Angular 12, iremos explorar a arquitetura MVC do Angular,
os componentes visuais do Angular Material, Angular reactive forms, navegação.</p>

## 1 - Telas do sistema
![image](https://github.com/user-attachments/assets/25f51dc9-1e48-4c06-b97c-fc575ecc23db)
<p>A imagem a cima mostra a estrutura de pastas adotada para organização das telas do projeto.</p>

## 1.1 - Tela de login
![image](https://github.com/user-attachments/assets/b112fedf-3781-45a4-880e-b257505dc2db)
<p>Como podemos na imagem da tela de login temos as opções do usuário informar o seu email e sua senha,
caso suas informações forem corretas ele então terá acesso a página inicial. Porém caso uma das informações
fornecidas estiverem incorretas o usuário receberá uma mensagem no canto superior direito o notificando 
da falha ao acesso, como podemos observar abaixo:</p>

![image](https://github.com/user-attachments/assets/5404fe88-277d-4bb2-b562-78c552cc52c1)

## 1.2 - Página inicial
<p>Quanto a página inicial podemos observar uma breve descrição do que se trata o projeto. Além disso,
podemos notar um botão, cujo o qual mantém os menus ocultos e mostra os mesmos ao clicarmos, nesse menu você
encontrará a opção de redirecionar a páginas como: Técnicos, Clientes, Chamados, dentre outras.</p>

![image](https://github.com/user-attachments/assets/e6834a9f-7658-459e-b8b8-5895e9e689ff)

## 1.3 - Técnicos
<p>Nesta página o usuário terá acesso a lista de técnicos disponiveis para realizar os chamados de manutenção.
Além de termos as opções de editarmos, excluirmos e criar novos ténicos. Porém aqui deixamos claro que essas opções,
são restritamentes permitidas aos usuário cadastrados como administradores, caso você não esteja logado em um usuário
com essa classificação, será gerado um erro na parte superior direita.</p>

![image](https://github.com/user-attachments/assets/601da1b4-9152-45e9-b361-0c408f2164b6)

## 1.3.1 - Cadastro de técnicos
<p>Aqui será realizado o cadastro do técnico, onde teremos a solicitação de informações dos usuários, que serão
classificados assim como técnicos.</p>

![image](https://github.com/user-attachments/assets/78638161-1ab7-4939-af72-3003e3c10a3b)

## 1.3.2 - Atualizar técnico
<p>Nessa página o usuário admin tem acesso a atualização do cadastro de técnico, ao clicarmos na página de 
listagem no botão para realizar atualização(simbolizado por um lápis) o usuário será redirecionada a seguinte tela:</p>

![image](https://github.com/user-attachments/assets/664e1cce-3912-4652-9e8e-7b19aed8808c)

## 1.3.3 - Deletar técnico
<p>Na tela de deleção, o usuário não poderá alterar campos, só receberá uma ilustração quanto aos dados do técnico 
que estará deletando.</p>

![image](https://github.com/user-attachments/assets/7f73aee4-f593-4378-ae9f-b15daa200a10)


## 1.4 - Clientes
<p>Quanto aos clientes teremos páginas bem parecidas quanto aos de técnicos, então para encurtarmos descrições, basta 
seguir a mesma lógica e escrita para esta sessão.</p>

![image](https://github.com/user-attachments/assets/a27ae77b-cd05-43ce-9b3b-75bcb06d8c06)

## 1.4.1 - Cadastro de clientes

![image](https://github.com/user-attachments/assets/ec99e7fc-38ae-4608-b877-0a79800b9c58)

## 1.4.2 - Atualizar cliente

![image](https://github.com/user-attachments/assets/600872f2-d61e-45cb-ad5b-253f56aeb307)

## 1.4.3 - Deletar cliente
<p>PAra deletar o cliente será necessário checar se o mesmo não possui chamados abertos no sistema, se não
a aplicação gerara uma exceção solicitando que o mesmo seja encerrado o chamado criado.</p>

![image](https://github.com/user-attachments/assets/94a19f63-90dc-4b23-b68c-2f09ee0bcd39)

## 1.5 - Chamados
<p>Seguindo o mesmo padrão de páginas aqui teremos a listagem de chamados, porém por se tratar da parte dos chamados
teremos mais informações agregadas, onde aqui podemos observar maneiras de filtragens como o estado do chamado,
podendo ser: aberto, andamento, encerrado. Além de podermos observar os vinculos entre o cliente criador do chamado,
e o técnico destinado a atende-lo.</p>

![image](https://github.com/user-attachments/assets/85b3a41f-14cc-4a93-8647-47e37e04b80e)


## 1.5.1 - Criar chamado
<p>Na parte de criação de chamado, podemos observar campos que possuem a opção de selecionar, tais coisas como o cliente,
técnico, status e prioridades. Esses campos não podem ser digitados, pois os mesmo já vem de cadastros realizados no sistema,
retornando assim dados já criados em banco de dados.</p>

![image](https://github.com/user-attachments/assets/1c027f7d-3eab-4119-b5df-5e025ee9643f)

## 1.5.2 - Editar chamado
![image](https://github.com/user-attachments/assets/eda1c17c-88d1-40a9-a86f-3c782cc14aa9)

## 1.5.3 - Visualizar chamado
<p>Ao clicar no simbolo do olho, o usuário será destinado a uma página de vizualição do chamado, informando assim as informção que 
já foram cadastradas no chamado selecionado.</p>

![image](https://github.com/user-attachments/assets/0d095025-5d4d-49eb-b9bc-6ae4289074fb)

  




