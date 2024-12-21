//Code for sequence diagram in mermaid
---
config:
  theme: dark
---
sequenceDiagram
actor User
User ->> TelevisionController: PUT /televisions/{tvId}/cimodule/{ciModuleId} (Long tvId, Long ciModuleId)
activate TelevisionController
TelevisionController ->> TelevisionService: assignCiModuleToTelevision(Long tvId, Long ciModuleId)
activate TelevisionService
TelevisionService ->> CiModuleRepository: findById(Long ciModuleId)
activate CiModuleRepository
alt CI Module exists
CiModuleRepository -->> TelevisionService: Optional<CiModule>
TelevisionService ->> TelevisionRepository: findById(Long tvId)
activate TelevisionRepository
alt Television exists
TelevisionRepository -->> TelevisionService: Optional<Television>
TelevisionService ->> TelevisionService: setCiModule(CiModule ciModule)
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
else CiModule not found
TelevisionService -->> TelevisionController: throw RecordNotFoundException
TelevisionController -->> User: Response 404 Not Found
end
deactivate CiModuleRepository
deactivate TelevisionService