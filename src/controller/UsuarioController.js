const Usuario = require('../model/usuario');

module.exports = {
    async index(req, res){
        const usuarios = await Usuario.find() //find equivalente ao select do sql 
        // [select * from ususario]
        res.json(usuarios)
    },

    async detail(req, res){
        const {_id} = req.params; //parâmetro da url do detail
        const usuarios = await Usuario.findOne({_id}) // [select * usuario where id = ?]
        res.json(usuarios)
    },

    async store(req, res){
        const { nome, senha } = req.body; //quando fazemos uma requisição tem a opção para colocar o body, passando as informações via body
        let dataCreate = {} //vai receber um json 
        dataCreate = { 
            nome, senha 
        }
        const usuarios = await Usuario.create(dataCreate) 
        res.json(usuarios)
    },

    async delete(req, res){
        const {_id} = req.params; //parâmetro da url do detail
        const usuarios = await Usuario.findByIdAndDelete({_id}) 
        res.json(usuarios)
    },

    async update(req, res){
        const { _id, nome, senha } = req.body; //quando fazemos uma requisição tem a opção para colocar o body, passando as informações via body
        let dataCreate = {} //vai receber um json. só vale dentro do escopo
        dataCreate = { 
            nome, senha 
        }
        const usuarios = await Usuario.findByIdAndUpdate({_id}, dataCreate, {new: true}) //listaremos um novo registro ao inves do antigo registro
        res.json(usuarios)
    }
}

