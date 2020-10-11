# registry-rest-api

Postman: https://www.getpostman.com/collections/c96cb51b48521343dfed



##TODO
- Verificar métodos do Controller
- Verificar como não gerar dados duplicados
- Pesquisar sobre ResponseEntity para resolver a questão de Httpstatus

### Get
- Quando encontrar retornar 200 com a entidade
- Quando não encontrar simplesmente retornar 404

### Listagem
- Quando encontrar retornar 200 com a lista de entidades
- Quando não encontrar retornar 20 com lista vazia

### Delete
- Quando encontrar só retornar 200
- Quando não encontrar retornar 404

### Post
- Quando conseguir criar com sucesso retornar 201
- Quando não conseguir criar por erro do user retornar 400

### Put
- Quando conseguir encontrar o ID e atualizar com sucesso retornar 200
- Quando conseguir encontrar o ID e não atualizar retornar 400
- Quando não encontrar ID retornar 404


