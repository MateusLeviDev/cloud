const express =  require('express'); 
const cookieParser = require('cookie-parser');
const cors = require('cors');
const path = require('path');
const mongoose = require('mongoose');

const routes = require('./src/routes'); //utilizando as devidas rotas exportadas 
const { ppid } = require('process');

const app = express()

mongoose.set('strictQuery', true);
mongoose.connect('mongodb://127.0.0.1:27017/CrudNodeMongoDB', 
async(err) => {
    if(err) throw err;
    console.log('connected to MongoDB')
});

// views 

app.use(cors());
app.use(cookieParser());
app.use(express.json()); //formato que trocaremos as info back > front vai ser json
app.use(routes); // caminho pra rotas

app.listen(3003, function(){ // startar o server 
    console.log("Servidor iniciado com sucesso!")
})