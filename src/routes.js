const express = require('express')

const routes = express.Router(); //router faz a criação de rotas 

routes.get('/', function(req, res){
    /* req requisição trazer para back
    res enviar dados para front  */

    res.json({message: "Bem-vindo ao back-end MongoDB"})
}) 

module.exports = routes; //exportar todas as rotas 

/* 
criou o routes no express, dentro dele existem vários met incluindo get, post, put e delete
falamos sobre uma rota de get, para listar. primeiro parâmetro é o nome da rota, no caso a raiz e segundo vai ser o que ela vai executar. 
*/