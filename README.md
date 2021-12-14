# API REST Routes 
Projeto de API REST de rotas para a Descartes

## Proposta

Criar um microsserviço contendo uma API REST que permita realizar as operações de CRUD (Create, Recover, Update and Delete) de Rotas, obedecendo corretamente os verbos e status codes.

## Implementações

- Route contém "id", "date", "status" (NOT_STATED, STARTED ou DONE) e "stops";
- Stop contém "id", "description", "address", "latitude", "longitude" e "status" (NOT_ANSWER ou ANSWER);
- Requisição POST em /Route, requisições GET, PUT e DELETE em /{id}, e requisição PATCH em /{id}/{statusRoute};
- Sistema de logging com Graylog como agregador de logs que gera um log sempre que há mudança de status na rota.
