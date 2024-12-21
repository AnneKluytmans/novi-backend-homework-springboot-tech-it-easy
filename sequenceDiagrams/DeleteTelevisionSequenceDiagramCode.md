//Code for sequence diagram in mermaid
---
config:
  theme: dark
---
sequenceDiagram
actor User
User ->> TelevisionController: DELETE /televisions/{tvId} (Long tvId)
activate TelevisionController
TelevisionController ->> TelevisionService: deleteTelevision(tvId)
activate TelevisionService
TelevisionService ->> TelevisionRepository: findById(tvId)
activate TelevisionRepository
alt Television exists
TelevisionRepository -->> TelevisionService: Optional<Television>
TelevisionService ->> TelevisionRepository: deleteById(tvId)
TelevisionRepository -->> TelevisionService: Success
TelevisionService -->> TelevisionController: Success
TelevisionController -->> User: Respose 204 No Content
else Television not found
TelevisionService -->> TelevisionController: throw RecordNotFoundException
TelevisionController -->> User: Response 404 Not Found
end
deactivate TelevisionRepository
deactivate TelevisionService