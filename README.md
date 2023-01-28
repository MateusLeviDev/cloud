## crud-node-mongodb
### Back-end com Node.js e MongoDB
<p>
`Model`: mapeamento de tabela no banco de dados. fazendo conexão com a tabela do banco com nosso back-end. devemos ter o model para reverenciar.
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
- correção problema: trocar a porta do localhost. Atualizei meu url mongodb de 'mongodb://localhost:27017/student' para 'mongodb://127.0.0.1:27017/student' e funcionou bem para mim. Funcioando após novas atualizações. 
</p>
