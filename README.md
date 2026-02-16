# RETO #6: Sistema de Soporte Técnico  
### Diego Ortiz - Brandon Peña - Julio Mayorquin

---

## Patrón de Diseño

- **Categoría:** Comportamiento  
- **Patrón Utilizado:** Chain of Responsibility  

---

## Justificación

El patrón **Chain of Responsibility** es ideal para este caso porque:

- Permite procesar solicitudes mediante una cadena de técnicos.
- Cada técnico decide si puede resolver el ticket o delegarlo al siguiente.
- Evita el acoplamiento entre el cliente y un técnico específico.
- Permite agregar nuevos niveles de técnicos sin modificar la lógica principal.
- Modela correctamente el concepto de escalamiento de tickets.

En este sistema, si un técnico no puede resolver un ticket, lo pasa automáticamente al siguiente en la cadena de responsabilidad.

---

## Cómo lo aplico

1. **Handler abstracto:**  
   `Tecnico` define el método `procesar(Ticket)` y mantiene la referencia al siguiente técnico en la cadena.

2. **Concrete Handlers:**  
   - `TecnicoBasico`
   - `TecnicoIntermedio`
   - `TecnicoAvanzado`  
   Cada uno implementa su propia lógica para determinar si puede resolver el ticket.

3. **Request:**  
   `Ticket` representa la solicitud con:
   - Nivel de dificultad
   - Prioridad
   - Descripción
   - Estado de resolución

4. **Cliente:**  
   `Reto6LabDOSW2` crea la cadena de técnicos, recibe los tickets por consola y ejecuta el procesamiento.

---

## Principios SOLID aplicados

### S - Single Responsibility Principle
Cada clase tiene una única responsabilidad:
- `Ticket` maneja los datos del ticket.
- `Tecnico` gestiona la lógica de escalamiento.
- Cada tipo de técnico define su capacidad de resolución.
- La clase principal gestiona la entrada y salida del sistema.

---

### O - Open/Closed Principle
El sistema está abierto a extensión pero cerrado a modificación:
- Podemos agregar nuevos técnicos (ej: Técnico Senior) sin modificar la lógica existente.
- Solo se crea una nueva clase que herede de `Tecnico`.

---

### L - Liskov Substitution Principle
Las clases `TecnicoBasico`, `TecnicoIntermedio` y `TecnicoAvanzado` pueden sustituir a `Tecnico` sin afectar el funcionamiento del sistema.

---

### I - Interface Segregation Principle
El diseño evita interfaces innecesarias.  
La clase abstracta `Tecnico` define únicamente los métodos necesarios para el procesamiento.

---

### D - Dependency Inversion Principle
La clase principal depende de la abstracción `Tecnico`, no de implementaciones concretas.  
La cadena se construye dinámicamente sin acoplarse a tipos específicos.

---

## Uso de Programación Funcional (Streams)

Se utilizaron **Streams de Java** para:

- Contar tickets resueltos y pendientes.
- Agrupar tickets por técnico.
- Calcular el promedio de prioridad.
- Generar estadísticas dinámicas.

Esto permite:

- Código más limpio.
- Mayor escalabilidad.
- Menor repetición de lógica.
- Mejor separación entre procesamiento y análisis.

---

## Ejecución

El sistema solicita por consola:

- Número de tickets
- Nivel
- Prioridad
- Descripción

Luego procesa la cadena de responsabilidad y muestra:

- Qué técnico resolvió cada ticket
- Tickets pendientes
- Estadísticas generales

## Diagrama de clases:
<img width="1508" height="772" alt="image" src="https://github.com/user-attachments/assets/86ca94aa-ef25-457f-95e6-a63cfbd18bd3" />



---

## Conclusión

La implementación del patrón **Chain of Responsibility** permite modelar correctamente el flujo de escalamiento de tickets en un sistema de soporte técnico, manteniendo bajo acoplamiento, alta cohesión y aplicando principios SOLID.

El uso de programación funcional complementa el diseño orientado a objetos, logrando una solución limpia, extensible y mantenible.
