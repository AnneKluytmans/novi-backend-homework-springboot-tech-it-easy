//Code for sequence diagram in mermaid
---
config:
  theme: dark
---
sequenceDiagram
actor User
User ->> TelevisionController: PUT /televisions/{tvId}/wallbracket/{wbId} (Long tvId, Long wbId)
activate TelevisionController
TelevisionController ->> TelevisionService: assignWallBracketToTelevision(Long tvId, Long wbId)
activate TelevisionService
TelevisionService ->> WallBracketRepository: findById(Long wbId)
activate WallBracketRepository
alt Wall Bracket exists
WallBracketRepository -->> TelevisionService: Optional<WallBracket>
TelevisionService ->> TelevisionRepository: findById(Long tvId)
activate TelevisionRepository
alt Television exists
TelevisionRepository -->> TelevisionService: Optional<Television>
TelevisionService ->> TelevisionService: setWallBracket(WallBracket wallBracket)
TelevisionService ->> TelevisionRepository: save(Television updatedTelevision)
TelevisionRepository -->> TelevisionService: updatedTelevision
TelevisionService -->> TelevisionService: Mapper.toDto(updatedTelevision)
TelevisionService -->> TelevisionController: updatedTelevisionDto
TelevisionController -->> User: Response 200 OK(updatedTelevisionDto)
else Television not found
TelevisionService -->> TelevisionController: throw RecordNotFoundException
TelevisionController -->> User: Response 404 Not Found
end
deactivate TelevisionRepository
else Wall Bracket not found
TelevisionService -->> TelevisionController: throw RecordNotFoundException
TelevisionController -->> User: Response 404 Not Found
end
deactivate WallBracketRepository
deactivate TelevisionService