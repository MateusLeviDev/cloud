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
