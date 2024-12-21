//Code for sequence diagram in mermaid
---
config:
  theme: dark
---
sequenceDiagram
    actor User
    User ->> TelevisionController: PUT /televisions/{tvId}/remotecontroller/{remoteId} (Long tvId, Long remoteId)
    activate TelevisionController
    TelevisionController ->> TelevisionService: assignRemoteControllerToTelevision(Long tvId, Long remoteId)
    activate TelevisionService
    TelevisionService ->> RemoteControllerRepository: findById(Long remoteId)
    activate RemoteControllerRepository
    alt RemoteController exists
        RemoteControllerRepository -->> TelevisionService: Optional<RemoteController>
        TelevisionService ->> TelevisionRepository: findById(Long tvId)
        activate TelevisionRepository
        alt Television exists
            TelevisionRepository -->> TelevisionService: Optional<Television>
            TelevisionService ->> TelevisionService: setRemoteController(RemoteController remoteController)
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
    else RemoteController not found
        TelevisionService -->> TelevisionController: throw RecordNotFoundException
        TelevisionController -->> User: Response 404 Not Found
    end
    deactivate RemoteControllerRepository
    deactivate TelevisionService
