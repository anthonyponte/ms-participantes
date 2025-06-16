# ms-participantes
Microservicio de participantes para el proyecto final del curso de Docker y Kubernetes Intermedio

## Requerimientos
- [ms-eventos](https://github.com/anthonyponte/ms-eventos) - Microservicio de eventos para el proyecto final del curso de Docker y Kubernetes Intermedio

## Instalacion
Ejecutar los siguientes comandos para desplegar el microservicio:
```
kubectl apply -f ms-participantes-configmap.yml
kubectl apply -f ms-participantes-deployment.yml
kubectl apply -f ms-participantes-service.yml
```

## Uso
| Metodo | Url                                | Descripción                                              |
|--------|------------------------------------|----------------------------------------------------------|
| GET    | /api/v1/participantes?dni={número} | Listar todos los participantes cuyo dni sea ```número``` |
| GET    | /api/v1/participantes?dni={número} | Listar todos los participantes cuyo dni sea ```número``` |
| POST   | /api/v1/participantes              | Crear participante                                       |
| DELETE | /api/v1/participantes/{id}         | Eliminar participante por ```id```                       |
