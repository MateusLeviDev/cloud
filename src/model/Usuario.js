// iniciar a criação do módulo

const mongoose = require('mongoose'); //mongoose pode ser considerado nosso ORM, pelo fato de fazer a conexão com o banco

const DataSchema = new mongoose.Schema({
    // dentro da função schema criamos a nossa tabelae depois referenciamos o nome dela
    nome: String,
    senha: String
})

const usuario = mongoose.model('Usuario', DataSchema) //daqui vamos iniciar a construção do model da tabela na database do mongodb. Primeiro paraâmetro é o nome da tabela, em seguida quais os campos "DataSchema"
module.exports = usuario //porque utilizaremos no controller, para por exemplo trabalhar com determinada tabela, chahamos a tabela q queremos, nesse caso da exportação.


