## 1. Habilitar APIs Necessárias
- Habilite a API do App Engine Admin no Console do Google Cloud.

## 2. Criar um Projeto
- Use o comando para criar um novo projeto ou selecione um projeto existente.

- permissões necessárias. objectviewer 

```
gcloud projects create [PROJECT_ID]
gcloud config set project [PROJECT_ID]

gcloud app deploy
gcloud app browse

gcloud auth list
gcloud app describe
```

## 3. Startando app engine
gcloud app create --region us-central


```
roles/appengine.serviceAgent:

Permite que serviços do App Engine interajam com outros serviços do Google Cloud, como Cloud Storage, Pub/Sub, etc.

roles/cloudbuild.builds.builder:

Necessária para permitir que o Cloud Build crie e implante seu aplicativo.

roles/storage.objectViewer:

Permite que a conta de serviço acesse objetos em buckets do Cloud Storage, o que é fundamental para a implantação.

roles/editor:

Proporciona permissões amplas para editar todos os recursos em um projeto do Google Cloud. Isso é útil se você estiver configurando recursos adicionais além do App Engine.

roles/storage.legacyBucketOwner e roles/storage.legacyBucketReader:

Permissões legadas para gerenciar e acessar buckets do Cloud Storage.

roles/pubsub.serviceAgent:

Permite que o App Engine interaja com o Pub/Sub, se você estiver usando este serviço.
```

/home/levi/Pictures/Screenshots/Screenshot from 2024-10-09 09-57-57.png


### deploy an app to cloud using app engine

- criar projeto
- App Engine Admin API -> enabled
- podemos criar um service agent 

`gcloud iam service-accounts create app-engine-account --project radiant-clone-440115-h4`

gcloud iam service-accounts list --project radiant-clone-440115-h4 //lista os service accounts do projeto

- dar a conta a permissão de Object Viewer

`gcloud projects add-iam-policy-binding spring-pubsub-template \   
    --member="serviceAccount:app-engine-account@radiant-clone-440115-h4.iam.gserviceaccount.com" \
    --role="roles/storage.objectViewer"`


- podemos criar algumas versoes desses serviços
- gcloud app deploy --version=v2 //podemos indicar a versao ao inves de deixar o processo fazer auto
- enquanto deploy ocorre, nossa v1 ainda fica ainda. apos sucesso da v2 o link principal aparece pra ativa no caso a ultima versao, o trafego para a v1 nao é indicado, mas ela esta rodando se buscarmos
- gcloud app browse --version <version>
- temos tb a opção de fazer o deploy da nova versão sem mudar o direcionamento do traffic imediatamente. exemplo: realizar a couple de tests e depois realizar o deploy e switch traffic 
- gcloud app deploy --version=v3 --no-promote
- se quiser mudar o trafego podemos executar
- gcloud app services set-traffic --splits=v3=.5,v2=.5
- O valor 0.5 (ou .5) no comando gcloud app services set-traffic representa a proporção do tráfego direcionado para uma versão específica do serviço. No exemplo:

- gcloud app services set-traffic --splits=v3=.5,v2=.5

O comando está configurando uma divisão de tráfego onde:

    50% do tráfego será direcionado para a versão v3 do serviço.
    50% do tráfego será direcionado para a versão v2 do serviço.

Em resumo, os valores 0.5 e .5 representam uma divisão igual de 50% para cada versão do serviço. Esse comando é útil para realizar testes de divisão de tráfego entre versões (como A/B testing) ou migrações graduais.

- gcloud app services set-traffic --splits=v3=1 ---> todo traffic pra v3

- curl watch (url)
- conseguimos criar multiplos services no app engine e multiples versions

- App engine - Cron job

```
yaml


cron:
- description: "daily summary job"
  url: /tasks/summary
  schedule: every 24 hours 

```

- scheduled jobs. use cases: send a report by email day, refresh cache data every 30 minutes
- configured using cron.yaml
- gcloud app deploy cron.yaml. performs a HTTP GET request to the configured url on schedule

#### how i go from v1 to v2 without downtime?

- do this on the weekend

- 1 : im very confident. deploy and shift all traffic at once.

```
gcloud app deploy
```

- 2 : i want to manage the migration from v1 to v2
- deploy v2 without shifting traffic (--no-promote)

```
gcloud app deploy --no-promote
```

- gradualmente shift traffic to v2 add -migrate option. not supported by app engine flexible. or control de pace `gcloud app services set-traffic --splits=v3=1`

- Configuração de Tráfego e Versionamento:
Com o controle de versão, você pode implementar múltiplas versões de uma aplicação e dividir o tráfego entre elas. Isso facilita testes A/B e lançamentos incrementais, gerenciados com comandos como gcloud app services set-traffic.

- Explorar práticas de cache (ex.: Memcache) e sessões para melhorar a eficiência e performance dos aplicativos.
- Ambiente Flexível: Baseado em contêineres Docker, oferece maior flexibilidade para escolher a linguagem, a configuração do sistema e o tamanho das instâncias. É recomendado para cargas de trabalho que exigem mais controle sobre o ambiente.


### App engine - Remember

- is regional. you cannot change an app region
- good option for simple ms. is not as powerful as `kubernetes`.
- o controle de versões é feito por serviço, e o App Engine serve apenas como o ambiente de execução e gerenciamento dos serviços e suas versões.
- você pode ter um único App Engine que representa o ambiente geral do seu aplicativo, mas dentro dele, é possível configurar e gerenciar múltiplos serviços.
- i dont want to alloe more that 10 instances for an app engine app: set max_instances in app.yaml. `basic_scaling > max_instances: 10`
- deploy new version without shifting traffic: `gclou app engine deploy --no-promote` : cria uma nova versão do service, mas o traffic ainda vai pra old version. podemos testar a nova e migrar aos poucos a nova versão
