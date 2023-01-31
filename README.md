## crud-node-mongodb
### Back-end com Node.js e MongoDB
<p>
`Model`: mapeamento de tabela no banco de dados. fazendo conexão com a tabela do banco com nosso back-end. devemos ter o model para referênciar.
 <br>
`mongoose`: para fazer essa conexão. mapeamento de módulo, criar controller, conectar ângulo de dados
</p>

https://github.com/GustaGitHub/controle_de_estoque/blob/main/controllers/employees.js

```sh
mongoose.set('strictQuery', true);
mongoose.connect('mongodb://127.0.0.1:27017/CrudNodeMongoDB', 
async(err) => {
    if(err) throw err;
    console.log('connected to MongoDB')
});

```
<p>
 <br>
 
 
- correção problema: trocar a porta do localhost. Atualizei meu url mongodb de 'mongodb://localhost:27017/student' para 'mongodb://127.0.0.1:27017/student' e funcionou bem para mim. Funcioando após novas atualizações. 
</p>
<br>

`diferente do mysql o mongodb ele verifica se tem um model  criado, se não tem a tabela no banco ele já cria, não precisamos fazer uma inicialização no myql, criar database e etc. ou seja, o processo é mais simples com o mongodb.`
<br> 

```sh
module.exports = {
    async index(req, res){
        const usuario = await Usuario.find()
        res.json(usuario)
```

- Mais acima é a criação do módulo.exports. Todas essas funções aqui de dentro vão ficar exportadas para poderem ser usadas em outras páginas como por exemplo em rotas. Primeira função de listagem criada
- `async/await`: async indica que será uma função assíncrona e esse await inidica onde ele deve esperar. Ou seja, quando é criada a função, colocamos ela pra receber, e colocamos antes de retornar `const usuario` ele deve esperar o `Usuario.find()` para retornar e listar, de fato.
- Req: Para trazer dado
- Res: para enviar dados
- `const usuario`: para armazenar os usuários
- `find()`: equivalente ao select do sql
