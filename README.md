# Acessibilidade-em-acao
Essa é a tela de inicio, onde pede pro usuário entrar com suas credenciais, se a senha ou o usuário estiverem incorretos, aparecerá uma mensagem nessa barrinha no fim da tela falando que a senha ou o usuário estão incorretos.

![image](https://user-images.githubusercontent.com/121894013/234446516-97f433c4-c13c-491f-b1cf-03226894c78c.png) <br>
Ao apertar no botão "Cadastrar", essa é a tela que aparecerá se  usuário não tiver uma conta cadastrada, tem que preencher com um usuário (que é unique, se ja tiver um usuário com esse nome no banco de dados vai aparecer uma mensagem de erro, informando que ja tem um cadastrado com esse nome) e uma senha, e se apertar no botão "Entrar" ele volta pra tela de início. <br>

![image](https://user-images.githubusercontent.com/121894013/234446556-e950f146-58c1-489a-817c-17ac865cb0e5.png) <br>

Essa é a tela que aparece quando voce entrar com seu usuário e senha, temos o botão "Sair", que ao ser clicado, te desloga e volta para a tela inicial, tambem temos o botão "Reclamar e "Consultar"

![image](https://user-images.githubusercontent.com/121894013/234446607-2300b71f-5244-4332-b2f7-f7bed103eb75.png) <br>
Essa é a tela que abre quando voce aperta o botão "Reclamar", que contém os campo "Nome escola" que é pro usuário digitar o nome da escola, o campo "cep" que ao inserir o cep e apertar no botão "Buscar", o programa pega as informações de uma web service e preenche automáticamente, caso o cep nao retorne nada, o programa solta um pop-up informando que o cep nao foi encontrado. Esse campo não permite a inserção de letras e nem a inserção de  mais de 8 dígitos, o campo nota também nao permite a inserção de mais de um dígito e a inserção de letras. O botão "Limpar" limpa todas as informações dos campos e o botão salvar, se estiver tudo preenchido, envia as informações pro banco de dados e registra sua reclamação. <br>

![image](https://user-images.githubusercontent.com/121894013/234446660-e637587c-26ce-4886-9578-6f3f557b065d.png) <br>

Essa tela "Sobre" nos dá umas informações como quem fez o projeto, o link da webservice que se você clicar, irá abrir, e o instagram, que se você clicar, irá abrir o icone do instagram do projeto. E no voltar, volta para a tela anterior.

![image](https://user-images.githubusercontent.com/121894013/234446699-96748b1a-9ff9-4b68-b5b0-c341c94a39f4.png) <br>

Essa é a tela que abre quando apertamos o botão "Consultar", e pede como parâmetro o nome da escola, e ao apertar no botão "Consultar", nessa área branca, ele retorna o nome da escola, a reclamação e a nota atribuída, caso não tenha uma reclamação para essa escola, aparece a mensagem que não foi encontrado uma reclamção para essa escola. Também temos o botão "Listar todos" que traz todas as reclamações registradas no banco de dados, e botão voltar, que volta para a tela anterior.

![image](https://user-images.githubusercontent.com/121894013/234446727-b9d1b10f-c8ef-454e-8c1e-9796a2a05d3b.png) <br>

##Bibliotecas utilizadas <br>
https://dom4j.github.io/ <br>
http://atxy2k.github.io/RestrictedTextField/ <br>
